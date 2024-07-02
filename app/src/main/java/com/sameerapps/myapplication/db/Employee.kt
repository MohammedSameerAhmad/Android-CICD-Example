package com.sameerapps.myapplication.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
Created by Mohammed Sameer Ahmad Android learning
 */
@Entity
data class Employee(
    @PrimaryKey
    val id: Int,
    val name: String,
    val salary: Int)

