package com.sameerapps.myapplication

import android.app.Application
import com.sameerapps.myapplication.api.QuotesService
import com.sameerapps.myapplication.api.RetrofitHelper
import com.sameerapps.myapplication.db.QuoteDatabase
import com.sameerapps.myapplication.repository.QuoteRepository

/**
Created by Mohammed Sameer Ahmad Android learning
 */
class QuoteApplication: Application() {
    lateinit var quoteRepository: QuoteRepository
    override fun onCreate() {
        super.onCreate()
        val retrofit = RetrofitHelper.getRetrofit().create(QuotesService::class.java)
        val quoteDatabase = QuoteDatabase.getDatabase(context = this)
        quoteRepository = QuoteRepository(retrofit, quoteDatabase, this)
    }

    fun getQuoteRepository(): QuoteRepository {
        return quoteRepository;
    }
}