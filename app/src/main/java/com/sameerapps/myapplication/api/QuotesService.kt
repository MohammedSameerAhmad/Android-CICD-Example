package com.sameerapps.myapplication.api

import com.sameerapps.myapplication.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
Created by Mohammed Sameer Ahmad Android learning
 */
interface QuotesService {
    @GET("quotes/")
    suspend fun getQuotesList(@Query("page") page: Int) : Response<QuoteList>
}