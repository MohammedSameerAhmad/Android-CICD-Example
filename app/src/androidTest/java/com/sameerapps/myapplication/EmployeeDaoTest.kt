package com.sameerapps.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.sameerapps.myapplication.db.Employee
import com.sameerapps.myapplication.db.EmployeeDB
import com.sameerapps.myapplication.db.EmployeeDao
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test



/**
Created by Mohammed Sameer Ahmad Android learning
 */
class EmployeeDaoTest {
    @get:Rule
    val instantTastExecutorRule = InstantTaskExecutorRule()

    lateinit var employeeDb: EmployeeDB
    lateinit var dao: EmployeeDao
    @Before
    fun setup(){
        employeeDb = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            EmployeeDB::class.java
        ).allowMainThreadQueries()
            .build()

        dao = employeeDb.dao()
    }

    @Test
    fun insertTest_expectedSingleEmployee() =  runBlocking {
        val employee = Employee(0, "Sameer", 50000)
        dao.insertEmployee(employee)
        var result = dao.getAllEmployee().getOrAwaitValue()
        Assert.assertEquals(1, result.size)
        Assert.assertEquals("Sameer", result.get(0).name)
    }

    @Test
    fun deleteTest_expectedDeleteEmployee() =  runBlocking {
        val employee = Employee(0, "Sameer", 50000)
        dao.insertEmployee(employee)
        dao.deleteEmployee()
        var result = dao.getAllEmployee().getOrAwaitValue()
        Assert.assertEquals(0, result.size)
    }

    @Test
    fun updateTest_expectedUpdateEmployee() =  runBlocking {
        val employee = Employee(0, "Sameer", 50000)
        val employeeUpdated = Employee(0, "Ahmad", 50000)
        dao.insertEmployee(employee)
        dao.updateEmployee(employeeUpdated)
        var result = dao.getAllEmployee().getOrAwaitValue()
        Assert.assertEquals(1, result.size)
        Assert.assertEquals("Ahmad", result[0].name)
    }

    @Before
    fun tearDown(){
        employeeDb.close()
    }
}