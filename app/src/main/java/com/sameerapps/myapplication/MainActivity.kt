package com.sameerapps.myapplication

import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sameerapps.myapplication.api.QuotesService
import com.sameerapps.myapplication.api.RetrofitHelper
import com.sameerapps.myapplication.repository.QuoteRepository
import com.sameerapps.myapplication.viewmodels.MainViewModel
import com.sameerapps.myapplication.viewmodels.MainViewModelFactory

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = (application as QuoteApplication).quoteRepository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository = repository)).get(MainViewModel::class.java)
        mainViewModel.quotes.observe(this) {
            Log.i(TAG, "onCreate: ${it.results}")
        }
    }
}