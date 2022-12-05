package com.github.ameen.androidkotlintemplate.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

@ApplicationContext
fun Context.hasInternetConnection(): Boolean {
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val activeNetwork = connectivityManager.activeNetwork ?: return false

    val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

    return when {
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> false
    }
}

fun hasServerConnected(): Boolean {

    try {
        val connection = URL(BASE_URL).openConnection() as HttpURLConnection

        connection.setRequestProperty("User-Agent", "Test")
        connection.setRequestProperty("Connection", "close")
        connection.connectTimeout = 80 //configurable

        connection.connect()

        Timber.e("hasServerConnected: ${(connection.responseCode == 200)}")

        return (connection.responseCode == 200)

    } catch (e: IOException) {
        Timber.e("Error checking server connection $e")
    }

    return false
}