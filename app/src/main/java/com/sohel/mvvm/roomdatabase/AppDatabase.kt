package com.sohel.mvvm.roomdatabase

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.sohel.mvvm.modelData.Articles


@Database(entities = arrayOf(Articles::class), version = 1)
public abstract class AppDatabase(val context: Context) : RoomDatabase() {
    abstract fun articleDao(): ArticlesDao
    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase::class.java, "chapter.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}
