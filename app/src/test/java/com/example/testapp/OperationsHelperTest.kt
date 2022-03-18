package com.example.testapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class OperationsHelperTest {

    @Test
    fun testAdd() {
        assertEquals(7.0, OperationsHelper.add(2.0, 5.0), 0.0)
    }
}