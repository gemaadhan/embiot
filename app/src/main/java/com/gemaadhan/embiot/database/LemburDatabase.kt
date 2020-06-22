package com.gemaadhan.embiot.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [OvertimeEntity::class], version = 2, exportSchema = false)
abstract class LemburDatabase : RoomDatabase() {

    abstract val lemburDatabaseDao: LemburDatabaseDao


    companion object {
        @Volatile
        private var INSTANCE: LemburDatabase? = null

    fun getInstance(context: Context): LemburDatabase {
        synchronized(this) {
            var instance = INSTANCE
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    LemburDatabase::class.java,
                    "lembur_database"
                ).
                    fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }

            return instance
        }
    }

    }


}