package com.alc.lib_common.uitle

import androidx.lifecycle.AndroidViewModel
import com.alc.lib_common.ui.base.mvvm.NoViewModel
import java.lang.reflect.ParameterizedType

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
class ClassUtil {
    companion object {
        /**
         * 获取泛型ViewModel的class对象
         */
        fun <T> getViewModel(obj: Any): Class<T>? {
            val currentClass: Class<*> = obj.javaClass
            val tClass: Class<T>? = getGenericClass(currentClass, AndroidViewModel::class.java)
            return if (tClass == null || tClass == AndroidViewModel::class.java || tClass == NoViewModel::class.java) {
                null
            } else tClass
        }

        private fun <T> getGenericClass(klass: Class<*>, filterClass: Class<*>): Class<T>? {
            val type = klass.genericSuperclass
            if (type == null || type !is ParameterizedType) return null
            val types = type.actualTypeArguments
            for (t in types) {
                val tClass = t as Class<T>
                if (filterClass.isAssignableFrom(tClass)) {
                    return tClass
                }
            }
            return null
        }
    }
}