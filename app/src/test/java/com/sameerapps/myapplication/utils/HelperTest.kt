package com.sameerapps.myapplication.utils

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


/**
 * Created by Mohammed Sameer Ahmad Android learning
 */
class HelperTest{
    lateinit var helper: Helper
    @Before
    fun setup(){
        helper = Helper()
    }

    @After
    fun tearDown(){
        
    }

    @Test
    fun isPalindrome_inputHello_expectedFalse(){
        val helper = Helper()
        var result = helper.isPalindrome("hello")
        assertEquals(false, result)
    }
    @Test
    fun isPalindrome_inputLevel_expectedTrue(){
        val helper = Helper()
        var result = helper.isPalindrome("level")
        assertEquals(true, result)
    }
}