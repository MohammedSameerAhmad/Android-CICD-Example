package com.sameerapps.myapplication.usermodule

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

/**
 * Created by Mohammed Sameer Ahmad Android learning
 */
class UserServicesTest {
    @Mock
    lateinit var userRepository: UserRepository

//    var userRepository: UserRepository = mock() // Kotlin friendly mocking type
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testUserService(){
        Mockito.`when`(userRepository.login(any(), any())).thenReturn(LoginStatus.INVALID_PASSWORD)
        val sut = UserServices(userRepository)
        val result = sut.userLogin("sameer@gmail.com", "Wel")
        assertEquals("Password is invalid", result)
    }
    @Test
    fun loginTest_emptyEmail_expectedUserNotFound(){
        Mockito.`when`(userRepository.login(any(), any())).thenReturn(LoginStatus.INVALID_USER)
        val sut = UserServices(userRepository)
        val result = sut.userLogin("", "Welcome@1")
        assertEquals("User doest not exist", result)
    }
}