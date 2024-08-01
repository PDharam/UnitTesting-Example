package com.pdharam.unittestingexample

import android.content.Context
import com.google.gson.Gson


class DataManager {

    var quoteList = emptyArray<Quote>()
    var currentQuestionIndex = 0

    fun populateQuoteFromAssets(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quoteList = gson.fromJson(json, Array<Quote>::class.java)

    }

    fun populateQuotes(quotes: Array<Quote>) {
        quoteList = quotes
    }

    fun getNextQuote(): Quote {
        return if (currentQuestionIndex == quoteList.size - 1) quoteList[currentQuestionIndex]
        else quoteList[++currentQuestionIndex]
    }

    fun getPreviousQuote(): Quote {
        return if (currentQuestionIndex == 0) quoteList[currentQuestionIndex]
        else quoteList[--currentQuestionIndex]
    }

}