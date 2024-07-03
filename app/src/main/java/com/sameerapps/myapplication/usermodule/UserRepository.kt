package com.sameerapps.myapplication.usermodule

/**
Created by Mohammed Sameer Ahmad Android learning
 */
class UserRepository {
    val userList = listOf(
        User(1, "Mohammed Sameer", "sameer@gmail.com", "Welcome@1"),
        User(2, "Aakash Sharma", "aakash@gmail.com", "Welcome@2"),
        User(2, "Anil Kumar Thallepalli", "anil@gmail.com", "Welcome@3"),
    )

    fun login(email:String, password:String): LoginStatus {
        val users = userList.filter { user: User -> user.email == email }
        return if (users.size == 1){
            if (users[0].password == password) LoginStatus.SUCCESS else LoginStatus.INVALID_PASSWORD
        }else{
            LoginStatus.INVALID_USER
        }
    }
}