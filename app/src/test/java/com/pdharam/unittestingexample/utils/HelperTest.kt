package com.pdharam.unittestingexample.utils

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HelperTest {
    lateinit var helper: Helper

    @Before
    fun setUp() {
        helper = Helper()
        println("Before Every Test Case")
    }

    @After
    fun tearDown() {
        println("After Every Test Case")
    }

    @Test
    fun isPalindrome() {

        //Act
        var result = helper.isPalindrome("")
        //Assert
        assertEquals(true, result)
    }

    @Test
    fun isPalindrome_inputString_level_expectedTrue() {
        //Act
        var result = helper.isPalindrome("level")
        //Assert
        assertEquals(true, result)
    }
}