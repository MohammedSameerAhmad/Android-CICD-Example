package com.sameerapps.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sameerapps.myapplication.models.Result

/**
Created by Mohammed Sameer Ahmad Android learning
 */
@Dao
interface QuoteDao {
    @Insert
    suspend fun addQuotes(quotes: List<Result>)

    @Query("Select * from quote ")
    suspend fun getQuotes(): List<Result>


}