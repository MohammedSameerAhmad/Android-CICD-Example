package com.sameerapps.myapplication.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sameerapps.myapplication.QuoteApplication
import com.sameerapps.myapplication.api.QuotesService
import com.sameerapps.myapplication.db.QuoteDatabase
import com.sameerapps.myapplication.models.QuoteList
import com.sameerapps.myapplication.utils.isInternetAvailable

/**
Created by Mohammed Sameer Ahmad Android learning
 */
class QuoteRepository(
    private val quoteService: QuotesService,
    private val quoteDatabase: QuoteDatabase,
    private val context: Context
) {

    private val quoteListLiveData = MutableLiveData<QuoteList>()
    val quoteList: LiveData<QuoteList>
        get() = quoteListLiveData
    suspend fun getQuoteList(pageNumber: Int){
        if (isInternetAvailable(context)){
            val result = quoteService.getQuotesList(pageNumber)
            if (result != null && result.isSuccessful){
                quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
                quoteListLiveData.postValue(result.body())
            }
        }else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1,2,2,quotes,1,1)
            quoteListLiveData.postValue(quoteList)
        }

    }
}