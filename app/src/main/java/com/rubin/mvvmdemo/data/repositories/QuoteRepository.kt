package com.rubin.mvvmdemo.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rubin.mvvmdemo.data.db.AppDatabase
import com.rubin.mvvmdemo.data.db.entities.Quote
import com.rubin.mvvmdemo.data.network.MyApi
import com.rubin.mvvmdemo.data.network.SafeApiRequest
import com.rubin.mvvmdemo.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteRepository(private val api: MyApi, private val db: AppDatabase) : SafeApiRequest() {

    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.observeForever {
            saveQuotes(it)
        }
    }

    suspend fun getQuotes(): LiveData<List<Quote>> {
        return withContext(Dispatchers.IO) {
            fetchQuotes()
            db.getQuoteDao().getAllQuotes()
        }
    }

    private fun saveQuotes(quotes: List<Quote>) {
        Coroutines.io {
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }

    private suspend fun fetchQuotes() {
        if (isFetchNeeded()) {
            val response = apiRequest { api.getQuotes() }
            quotes.postValue(response.quotes)
        }
    }

    private fun isFetchNeeded() = true
}