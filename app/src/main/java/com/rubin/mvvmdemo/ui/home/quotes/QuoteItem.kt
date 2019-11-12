package com.rubin.mvvmdemo.ui.home.quotes

import com.rubin.mvvmdemo.R
import com.rubin.mvvmdemo.data.db.entities.Quote
import com.rubin.mvvmdemo.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(private val quote: Quote) : BindableItem<ItemQuoteBinding>() {

    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }
}