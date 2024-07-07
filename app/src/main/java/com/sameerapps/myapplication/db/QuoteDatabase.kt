package com.sameerapps.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sameerapps.myapplication.models.Result

/**
Created by Mohammed Sameer Ahmad Android learning
 */
@Database(entities = [Result::class], version = 1)
abstract class QuoteDatabase(): RoomDatabase() {
    abstract fun quoteDao(): QuoteDao
    companion object{
        @Volatile
        private var INSTANCE: QuoteDatabase? = null
         fun getDatabase(context: Context): QuoteDatabase{
             synchronized(this){
                 if (INSTANCE == null){
                     INSTANCE = Room.databaseBuilder(context, QuoteDatabase::class.java,
                         "quoteDB", ).build()
                 }
                 return INSTANCE!!
             }
         }
    }

}