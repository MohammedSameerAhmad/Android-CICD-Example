package com.sameerapps.myapplication.usermodule

/**
Created by Mohammed Sameer Ahmad Android learning
 */
class UserServices(val userRepository: UserRepository) {
    fun userLogin(email: String, password: String): String {
        val status = userRepository.login(email, password)
        return when(status){
            LoginStatus.SUCCESS -> "Logged in successfully"
            LoginStatus.INVALID_USER -> "User doest not exist"
            LoginStatus.UNKNOWN -> "Unknown error occurred"
            LoginStatus.INVALID_PASSWORD -> "Password is invalid"
        }
    }
}