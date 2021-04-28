package com.alc.module_project.http

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/28
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class ParamNames(val value: String)
