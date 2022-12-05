package com.github.ameen.androidkotlintemplate.data.remote


sealed class ResponseWrapper<T : Any> {
    class Success<T: Any>(val data: T) : ResponseWrapper<T>()
    class Error<T: Any>(val code: Int, val message: String?) : ResponseWrapper<T>()
    class Exception<T: Any>(val e: Throwable) : ResponseWrapper<T>()
}