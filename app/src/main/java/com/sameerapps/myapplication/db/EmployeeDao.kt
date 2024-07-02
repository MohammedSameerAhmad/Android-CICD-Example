package com.sameerapps.myapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
Created by Mohammed Sameer Ahmad Android learning
 */
@Dao
interface EmployeeDao {
    @Insert
    suspend fun insertEmployee(employee: Employee)

    @Update
    suspend fun updateEmployee(employee: Employee)

    @Query("Delete from employee")
    suspend fun deleteEmployee()

    @Query("SELECT * FROM Employee")
    fun getAllEmployee(): LiveData<List<Employee>>

    @Query("SELECT * FROM Employee where id = :employeeId")
    suspend fun getEmployeeById(employeeId: Int): Employee

}