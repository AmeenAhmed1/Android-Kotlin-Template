package com.github.ameen.androidkotlintemplate.di

import android.content.Context
import com.github.ameen.androidkotlintemplate.core.SharedPreferencesManager
import com.github.ameen.androidkotlintemplate.core.SharedPreferencesManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context) =
        SharedPreferencesManagerImpl(context) as SharedPreferencesManager
}