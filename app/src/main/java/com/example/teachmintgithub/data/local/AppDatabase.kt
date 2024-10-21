package com.example.assignmenttrial1.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assignmenttrial1.App
import com.example.assignmenttrial1.domain.model.Contributor
import com.example.teachmintgithub.data.local.ContributorDao
import com.example.teachmintgithub.data.local.ContributorEntity

@Database(entities = [ContributorEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contributorDao(): ContributorDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    App.instance.applicationContext(),
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
