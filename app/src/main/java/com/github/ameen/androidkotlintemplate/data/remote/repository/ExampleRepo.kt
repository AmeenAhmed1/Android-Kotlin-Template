package com.github.ameen.androidkotlintemplate.data.remote.repository

import com.github.ameen.androidkotlintemplate.data.remote.ApiService
import com.github.ameen.androidkotlintemplate.domain.repository.IExampleRepository
import javax.inject.Inject

class ExampleRepo @Inject constructor(
    private val apiService: ApiService
) : IExampleRepository {

    override fun example(): Any {
        TODO("Not yet implemented")
    }

}