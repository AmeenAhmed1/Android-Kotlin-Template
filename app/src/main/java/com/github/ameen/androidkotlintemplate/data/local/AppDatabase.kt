package com.github.ameen.androidkotlintemplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 17,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    // TODO: PUT YOUR DAOs HERE
}