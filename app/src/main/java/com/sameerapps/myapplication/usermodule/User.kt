package com.sameerapps.myapplication.usermodule

/**
Created by Mohammed Sameer Ahmad Android learning
 */
data class User(val id: Int,
    val name: String,
    val email: String,
    val password: String)

enum class LoginStatus{
    INVALID_USER,
    INVALID_PASSWORD,
    UNKNOWN,
    SUCCESS
}


