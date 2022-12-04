package com.github.ameen.androidkotlintemplate.domain.usecase

import com.github.ameen.androidkotlintemplate.domain.repository.IExampleRepository
import javax.inject.Inject

class SampleUseCase @Inject constructor(private val repository: IExampleRepository) {
    fun execute(): Any {
        return repository.example()
    }
}