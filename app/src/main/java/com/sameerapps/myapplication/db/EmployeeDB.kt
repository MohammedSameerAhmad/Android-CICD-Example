package com.sameerapps.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
Created by Mohammed Sameer Ahmad Android learning
 */
@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDB : RoomDatabase(){
    abstract fun dao(): EmployeeDao
}