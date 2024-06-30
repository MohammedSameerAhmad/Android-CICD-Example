package com.sameerapps.myapplication

import android.content.Context
import java.io.FileNotFoundException

/**
Created by Mohammed Sameer Ahmad Android learning
 */
class QuoteManager {
    var quoteList = emptyArray<QuoteModel>()
    var currentIndex = 0
    fun populateQuoteFromAssets(context: Context, filename : String){
        if (filename.isEmpty()){
            throw FileNotFoundException("File name is empty...")
        }
        if (context == null){
            throw NullPointerException("context object is null")
        }
        quoteList = arrayOf(QuoteModel("title", "description"), QuoteModel("title", "description"), QuoteModel("title", "description"))
    }
    fun populateQuote(quote : Array<QuoteModel>){
        quoteList = quote
    }
    fun getCurrentQuote(): QuoteModel{
        if (currentIndex == quoteList.size - 1) return quoteList.get(currentIndex)
        return quoteList.get(currentIndex)
    }
    fun getPreviousQuote(): QuoteModel{
        if (currentIndex == 0) return getCurrentQuote()
        return quoteList.get(--currentIndex)
    }
    fun getNextQuote(): QuoteModel{
        if (currentIndex == quoteList.size - 1) quoteList.get(currentIndex)
        return quoteList.get(++currentIndex)
    }
}