package com.rubin.mvvmdemo.data.network

import com.rubin.mvvmdemo.data.db.entities.Quote

data class QuotesResponse(
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)