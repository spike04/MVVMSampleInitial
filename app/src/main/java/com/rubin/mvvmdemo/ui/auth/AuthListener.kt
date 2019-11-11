package com.rubin.mvvmdemo.ui.auth

import com.rubin.mvvmdemo.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}