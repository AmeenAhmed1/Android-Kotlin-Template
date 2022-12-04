package com.github.ameen.androidkotlintemplate.data.local.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SampleTable")
data class SampleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String
)
