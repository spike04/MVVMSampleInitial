package com.rubin.mvvmdemo.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

private const val KEY_SAVED_AT = "KEY_SAVED_AT"

class PreferenceProvider(context: Context) {
    private val appContext = context.applicationContext

    private val preference: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(appContext)

    fun saveLastSavedAt(savedAt: String) {
        preference.edit().putString(
            KEY_SAVED_AT, savedAt
        ).apply()
    }

    fun getLastSavedAt() = preference.getString(KEY_SAVED_AT, null)
}