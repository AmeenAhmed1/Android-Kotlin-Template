package com.github.ameen.androidkotlintemplate.core

import com.github.ameen.androidkotlintemplate.MainApplication
import com.github.ameen.androidkotlintemplate.R
import org.json.JSONObject
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

fun errorHandler(throwable: Throwable): String? {
    try {
        return if (throwable is HttpException) {
            val msg = responseErrorHandler(
                throwable.response()!!.errorBody()!!.string(),
                throwable.code()
            )
            msg.replace("[", "").replace("]", "")
        } else failureHandler(throwable)
    } catch (e: Exception) {
        Timber.d(e)
    }
    return null
}

private fun failureHandler(t: Throwable): String {
    val context = MainApplication().applicationContext
    return if (t is IOException) {
        context.getString(R.string.no_internet)
    } else {
        Timber.d(t)
        context.getString(R.string.error)
    }
}

private fun responseErrorHandler(response: String, responseCode: Int): String {

    val context = MainApplication().applicationContext

    return when {
        responseCode < 500 -> {
            try {
                val responseObject = JSONObject(response)
                if (responseObject.has("errors")) {
                    val error = responseObject.get("errors")

                    if (error is String)
                        return error
                    if (error is JSONObject) {
                        for (key: String in error.keys().iterator()) {
                            return error.getString(key)
                        }
                    }
                }
                responseObject.getString("message")
            } catch (e: Exception) {
                // Timber.e(e)
                if (null != e.message)
                    e.message!!
                else
                    context.getString(R.string.error)

            }
        }

        responseCode == 500 -> {
            context.getString(R.string.server_error)
        }

        else -> {
            context.getString(R.string.error)
        }
    }
}
