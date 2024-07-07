package com.sameerapps.myapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sameerapps.myapplication.models.QuoteList
import com.sameerapps.myapplication.repository.QuoteRepository
import kotlinx.coroutines.launch

/**
Created by Mohammed Sameer Ahmad Android learning
 */
class MainViewModel(private val repository: QuoteRepository): ViewModel() {

    init {
        viewModelScope.launch {
            repository.getQuoteList(1)
        }
    }
    val quotes : LiveData<QuoteList>
        get() =  repository.quoteList
 }