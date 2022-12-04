package com.github.ameen.androidkotlintemplate.data.mapper

import com.github.ameen.androidkotlintemplate.data.local.entites.SampleEntity
import com.github.ameen.androidkotlintemplate.domain.model.SampleDomainData

fun SampleEntity.toDomain(): SampleDomainData {
    return SampleDomainData(
        sampleId = this.id ?: 0,
        sampleName = this.name
    )
}