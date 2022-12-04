package com.github.ameen.androidkotlintemplate.core

import android.content.Context
import android.content.SharedPreferences

interface SharedPreferencesManager {

    var userToken: String?

    fun saveUserSessionToken(token: String)
}

class SharedPreferencesManagerImpl(context: Context) : SharedPreferencesManager {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(
            sharedPreferencesKey,
            Context.MODE_PRIVATE
        )

    private val editor = sharedPreferences.edit()

    override var userToken: String?
        get() = getString(userTokenKey)
        set(token) {
            editor.putString(userTokenKey, "Bearer $token").apply()
        }


    private fun getString(key: String): String? {
        sharedPreferences.getString(key, "").let { s ->
            return if (s.isNullOrBlank())
                null
            else
                s
        }
    }

    private fun getInt(key: String): Int {
        sharedPreferences.getInt(key, 0).let { s ->
            return s
        }
    }

    private fun getBoolean(key: String): Boolean {
        sharedPreferences.getBoolean(key, false).let {
            return it
        }
    }

    override fun saveUserSessionToken(token: String) {
        userToken = token
    }

    companion object {

        // TODO: PUT YOUR PREFERENCES KEYs HERE
        private const val sharedPreferencesKey = "USERDATA"
        private const val userTokenKey = "API_TOKEN"
    }
}