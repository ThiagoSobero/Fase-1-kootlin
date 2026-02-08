package com.example.fase1.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fase1.data.entity.ContactEntity
import com.example.fase1.data.local.dao.ContactDao

@Database(
    entities = [ContactEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}