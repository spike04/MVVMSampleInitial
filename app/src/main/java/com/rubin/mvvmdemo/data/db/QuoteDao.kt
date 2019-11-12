package com.rubin.mvvmdemo.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rubin.mvvmdemo.data.db.entities.Quote

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllQuotes(quotes: List<Quote>)

    @Query("SELECT * FROM quote")
    fun getAllQuotes(): LiveData<List<Quote>>
}