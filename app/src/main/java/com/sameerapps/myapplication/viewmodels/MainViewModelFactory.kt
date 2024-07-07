package com.sameerapps.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sameerapps.myapplication.repository.QuoteRepository

/**
Created by Mohammed Sameer Ahmad Android learning
 */
class MainViewModelFactory(private val repository: QuoteRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}