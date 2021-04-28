package com.alc.module_project.http

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
class NullOnEmptyConverterFactory : Converter.Factory() {
    override fun responseBodyConverter(
        type: Type?,
        annotations: Array<Annotation?>?,
        retrofit: Retrofit
    ): Converter<ResponseBody?, *>? {
        val delegate: Converter<ResponseBody, *> =
            retrofit.nextResponseBodyConverter<Any>(this, type, annotations)
        return Converter { value ->
            if (value?.contentLength() == 0L) null else delegate.convert(
                value
            )
        }
    }
}