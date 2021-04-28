package com.alc.module_project.http

import android.content.Context
import android.text.TextUtils
import com.alc.lib_common.uitle.CheckNetwork
import com.alc.module_project.BuildConfig
import com.google.gson.FieldNamingPolicy
import com.google.gson.FieldNamingStrategy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import org.apache.commons.lang.StringUtils
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.IOException
import java.lang.reflect.Field
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
class HttpUtils {


    private var gson: Gson? = null
    private var context: Context? = null

    companion object {
        private lateinit var instance: HttpUtils

        // wanandroid、gankio、时光网
        val API_GANKIO = "https://gank.io/api/"
        val API_DOUBAN = "Https://api.douban.com/"
        val API_TING = "https://tingapi.ting.baidu.com/v1/restserver/"
        val API_GITEE = "https://gitee.com/"
        val API_WAN_ANDROID = "https://www.wanandroid.com/"
        val API_QSBK = "http://m2.qiushibaike.com/"
        val API_MTIME = "https://api-m.mtime.cn/"
        val API_MTIME_TICKET = "https://ticket-api-m.mtime.cn/"

        fun getInstance(): HttpUtils {
            if (instance == null) {
                synchronized(HttpUtils::class.java) {
                    if (instance == null) {
                        instance = HttpUtils()
                    }
                }
            }
            return instance
        }
    }

    fun init(context: Context?) {
        this.context = context
    }

    fun getBuilder(apiUrl: String?): Retrofit.Builder {
        val builder = Retrofit.Builder()
        builder.client(getOkClient())
        builder.baseUrl(apiUrl) // 设置远程地址
        builder.addConverterFactory(NullOnEmptyConverterFactory())
        builder.addConverterFactory(GsonConverterFactory.create(getGson()))
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        return builder
    }


    private fun getGson(): Gson? {
        if (gson == null) {
            val builder = GsonBuilder()
            builder.setLenient()
            builder.setFieldNamingStrategy(AnnotateNaming())
            builder.serializeNulls()
            gson = builder.create()
        }
        return gson
    }


    private class AnnotateNaming : FieldNamingStrategy {
        override fun translateName(field: Field): String {
            val a: ParamNames = field.getAnnotation(ParamNames::class.java)
            return a?.value ?: FieldNamingPolicy.IDENTITY.translateName(field)
        }
    }

    private fun getUnsafeOkHttpClient(): OkHttpClient {
        return try {
            // Install the all-trusting trust manager TLS
            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, trustAllCerts, SecureRandom())
            //cache url
            val httpCacheDirectory = File(context!!.cacheDir, "responses")
            // 50 MiB
            val cacheSize = 50 * 1024 * 1024
            val cache = Cache(httpCacheDirectory, cacheSize.toLong())
            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory
            val okBuilder = OkHttpClient.Builder()
            okBuilder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            okBuilder.readTimeout(30, TimeUnit.SECONDS)
            okBuilder.connectTimeout(30, TimeUnit.SECONDS)
            okBuilder.writeTimeout(30, TimeUnit.SECONDS)
            okBuilder.addInterceptor(HttpHeadInterceptor())
            // 持久化cookie
            okBuilder.addInterceptor(ReceivedCookiesInterceptor(context))
            okBuilder.addInterceptor(AddCookiesInterceptor(context))
            // 添加缓存，无网访问时会拿缓存,只会缓存get请求
            okBuilder.addInterceptor(AddCacheInterceptor(context))
            okBuilder.cache(cache)
            okBuilder.addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
            )
            okBuilder.hostnameVerifier(HostnameVerifier { hostname, session -> true })
            okBuilder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    private fun getOkClient(): OkHttpClient? {
        val client1: OkHttpClient
        client1 = getUnsafeOkHttpClient()
        return client1
    }

    inner class HttpHeadInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request: Request = chain.request()
            val builder: Request.Builder = request.newBuilder()
            builder.addHeader("Accept", "application/json;versions=1")
            if (CheckNetwork.isNetworkConnected(context)) {
                val maxAge = 60
                builder.addHeader("Cache-Control", "public, max-age=$maxAge")
            } else {
                val maxStale = 60 * 60 * 24 * 28
                builder.addHeader("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
            }
            return chain.proceed(builder.build())
        }
    }

    private class AddCacheInterceptor internal constructor(private val context: Context?) :
        Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val cacheBuilder = CacheControl.Builder()
            cacheBuilder.maxAge(0, TimeUnit.SECONDS)
            cacheBuilder.maxStale(365, TimeUnit.DAYS)
            val cacheControl: CacheControl = cacheBuilder.build()
            var request: Request = chain.request()
            if (!CheckNetwork.isNetworkConnected(context)) {
                request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build()
            }
            val originalResponse: Response = chain.proceed(request)
            return if (CheckNetwork.isNetworkConnected(context)) {
                // read from cache
                val maxAge = 0
                originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public ,max-age=$maxAge")
                    .build()
            } else {
                // tolerate 4-weeks stale
                val maxStale = 60 * 60 * 24 * 28
                originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                    .build()
            }
        }
    }

    private class ReceivedCookiesInterceptor internal constructor(private val context: Context?) :
        Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalResponse: Response = chain.proceed(chain.request())
            //这里获取请求返回的cookie
            if (!originalResponse.headers("Set-Cookie").isEmpty()) {
                val d = originalResponse.headers("Set-Cookie")
                //                Log.e("jing", "------------得到的 cookies:" + d.toString());

                // 返回cookie
                if (!TextUtils.isEmpty(d.toString())) {
                    val sharedPreferences =
                        context!!.getSharedPreferences("config", Context.MODE_PRIVATE)
                    val editorConfig = sharedPreferences.edit()
                    val oldCookie = sharedPreferences.getString("cookie", "")
                    val stringStringHashMap = HashMap<String, String>()

                    // 之前存过cookie
                    if (!TextUtils.isEmpty(oldCookie)) {
                        val substring = oldCookie!!.split(";".toRegex()).toTypedArray()
                        for (aSubstring in substring) {
                            if (aSubstring.contains("=")) {
                                val split = aSubstring.split("=".toRegex()).toTypedArray()
                                stringStringHashMap[split[0]] = split[1]
                            } else {
                                stringStringHashMap[aSubstring] = ""
                            }
                        }
                    }
                    val join: String = StringUtils.join(d, ";")
                    val split = join.split(";".toRegex()).toTypedArray()

                    // 存到Map里
                    for (aSplit in split) {
                        val split1 = aSplit.split("=".toRegex()).toTypedArray()
                        if (split1.size == 2) {
                            stringStringHashMap[split1[0]] = split1[1]
                        } else {
                            stringStringHashMap[split1[0]] = ""
                        }
                    }

                    // 取出来
                    val stringBuilder = StringBuilder()
                    if (stringStringHashMap.size > 0) {
                        for (key in stringStringHashMap.keys) {
                            stringBuilder.append(key)
                            val value = stringStringHashMap[key]
                            if (!TextUtils.isEmpty(value)) {
                                stringBuilder.append("=")
                                stringBuilder.append(value)
                            }
                            stringBuilder.append(";")
                        }
                    }
                    editorConfig.putString("cookie", stringBuilder.toString())
                    editorConfig.apply()
                    //                    Log.e("jing", "------------处理后的 cookies:" + stringBuilder.toString());
                }
            }
            return originalResponse
        }
    }

    private class AddCookiesInterceptor internal constructor(private val context: Context?) :
        Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val builder: Request.Builder = chain.request().newBuilder()
            val sharedPreferences = context!!.getSharedPreferences("config", Context.MODE_PRIVATE)
            val cookie: String? = sharedPreferences.getString("cookie", "")
            builder.addHeader("Cookie", cookie!!)
            return chain.proceed(builder.build())
        }
    }

    val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
        @Throws(CertificateException::class)
        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
        }

        @Throws(CertificateException::class)
        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
        }

        override fun getAcceptedIssuers(): Array<X509Certificate> {
            return arrayOf()
        }
    })

}