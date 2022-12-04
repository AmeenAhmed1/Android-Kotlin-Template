package com.github.ameen.androidkotlintemplate.di

import com.github.ameen.androidkotlintemplate.data.remote.ApiService
import com.github.ameen.androidkotlintemplate.data.remote.repository.ExampleRepo
import com.github.ameen.androidkotlintemplate.domain.repository.IExampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesAuthRepository(api: ApiService) =
        ExampleRepo(api) as IExampleRepository

}