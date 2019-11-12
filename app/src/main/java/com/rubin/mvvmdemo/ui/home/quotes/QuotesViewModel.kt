package com.rubin.mvvmdemo.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.rubin.mvvmdemo.data.repositories.QuoteRepository
import com.rubin.mvvmdemo.util.lazyDeferred

class QuotesViewModel(quoteRepository: QuoteRepository) : ViewModel() {

    val quotes by lazyDeferred {
        quoteRepository.getQuotes()
    }
}
