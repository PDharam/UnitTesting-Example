package com.pdharam.unittestingexample

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.FileNotFoundException

class DataManagerTest {


    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets() {
        val dataManager = DataManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        dataManager.populateQuoteFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun testPopulateQuoteFromAssets_InvalidJSON_expected_Exception() {
        val dataManager = DataManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        dataManager.populateQuoteFromAssets(context, "malformed.json")
    }

    @Test
    fun testPopulateQuoteFromAssets_ValidJSON_expected_Count() {
        val dataManager = DataManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        dataManager.populateQuoteFromAssets(context, "quotes.json")
        assertEquals(1643, dataManager.quoteList.size)
    }

    @Test
    fun testPrevQuote_expected_CorrectQuote() {
        val dataManager = DataManager()
        dataManager.populateQuotes(
            arrayOf(
                Quote("This is first quote", "1"),
                Quote("This is second quote", "2"),
                Quote("This is third quote", "3")
            )
        )

        val quote = dataManager.getPreviousQuote()

        assertEquals("1", quote.author)
    }

    @Test
    fun testNextQuote_expected_CorrectQuote() {
        val dataManager = DataManager()
        dataManager.populateQuotes(
            arrayOf(
                Quote("This is first quote", "1"),
                Quote("This is second quote", "2"),
                Quote("This is third quote", "3")
            )
        )

        val quote = dataManager.getNextQuote()

        assertEquals("2", quote.author)
    }
}