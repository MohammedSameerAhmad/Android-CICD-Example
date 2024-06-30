package com.sameerapps.myapplication

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

/**
 * Created by Mohammed Sameer Ahmad Android learning
 */
class QuoteManagerTest {
    lateinit var quoteManager: QuoteManager
    @Before
    fun setUp() {
        quoteManager = QuoteManager();
    }

    @After
    fun tearDown() {
    }

    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets_inputEmptyFileName_expectedFileNotFoundException() {
        var quoteManager = QuoteManager()
        var context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "")
    }

    @Test(expected = NullPointerException::class)
    fun populateQuoteFromAssets_inputNullContext_expectedNullPointerException() {
        var quoteManager = QuoteManager()
        var context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "")
    }


}