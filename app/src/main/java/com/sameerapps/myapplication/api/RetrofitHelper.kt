package com.sameerapps.myapplication.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
Created by Mohammed Sameer Ahmad Android learning
 */
object RetrofitHelper {
    val baseURL = "https://quotable.io/"
    fun getRetrofit() = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
}