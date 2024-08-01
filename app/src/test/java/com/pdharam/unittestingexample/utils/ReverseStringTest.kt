package com.pdharam.unittestingexample.utils

import org.junit.Assert
import org.junit.Test

class ReverseStringTest {

    @Test
    fun testStringReversal_EmptyInput_ExpectedEmptyString() {
        val sut = Utils()
        val result = sut.reverseString("")
        Assert.assertEquals("", result)
    }

    @Test
    fun testStringReversal_SingleCharInput_ExpectedSingleChar() {
        val sut = Utils()
        val result = sut.reverseString("A")
        Assert.assertEquals("A", result)
    }

    @Test
    fun testStringReversal_ValidInput_ExpectedSameString() {
        val sut = Utils()
        val result = sut.reverseString("Pravin")
        Assert.assertEquals("nraviP", result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReversal_NullInput_ExpectedException() {
        val sut = Utils()
        val result = sut.reverseString(null)

    }
}