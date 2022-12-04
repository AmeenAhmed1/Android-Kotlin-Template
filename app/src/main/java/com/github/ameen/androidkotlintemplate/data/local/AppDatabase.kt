package com.github.ameen.androidkotlintemplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.ameen.androidkotlintemplate.data.local.dao.SampleDao
import com.github.ameen.androidkotlintemplate.data.local.entites.SampleEntity

@Database(
    entities = [SampleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    // TODO: PUT YOUR DAOs HERE
    abstract fun sampleDao(): SampleDao
}