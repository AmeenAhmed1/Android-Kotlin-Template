package com.github.ameen.androidkotlintemplate.di

import com.github.ameen.androidkotlintemplate.core.BASE_URL
import com.github.ameen.androidkotlintemplate.core.SharedPreferencesManager
import com.github.ameen.androidkotlintemplate.core.TIME_OUT
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor(headerInterceptor: Interceptor): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
            .apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

        val client = OkHttpClient.Builder()
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(headerInterceptor)

        return client.build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()


    @Provides
    @Singleton
    fun provideHeadersInterceptor(sharedPreferencesManager: SharedPreferencesManager) =
        Interceptor { chain ->
            var request = chain.request()
            request = request.newBuilder()
                .header("Authorization", sharedPreferencesManager.userToken ?: "")
                .addHeader("Accept", "application/json")
                .build()
            chain.proceed(request)
        }


}