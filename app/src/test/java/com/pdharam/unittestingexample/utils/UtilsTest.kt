package com.pdharam.unittestingexample.utils

import org.junit.Assert
import org.junit.Test

class UtilsTest {

    @Test
    fun validatePassword_blankInput_expectRequiredField() {
        val sut = Utils()
        val result = sut.isValidPassword("    ")

        Assert.assertEquals("Password is required field", result)
    }

    @Test
    fun validatePassword_2CharInput_expectValidationMsg() {
        val sut = Utils()
        val result = sut.isValidPassword("ab")

        Assert.assertEquals("Length of the password should be greater than 6", result)
    }

    @Test
    fun validatePassword_CorrectInput_expectValidPass() {
        val sut = Utils()
        val result = sut.isValidPassword("Pass123")

        Assert.assertEquals("Valid", result)
    }
}