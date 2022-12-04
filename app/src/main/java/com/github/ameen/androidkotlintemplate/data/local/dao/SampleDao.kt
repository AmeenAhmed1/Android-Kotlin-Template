package com.github.ameen.androidkotlintemplate.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.ameen.androidkotlintemplate.data.local.entites.SampleEntity

@Dao
interface SampleDao {

    @Query("SELECT * FROM SampleTable")
    fun getAllSamples(): List<SampleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllSampled(sampleData: List<SampleEntity>)
}