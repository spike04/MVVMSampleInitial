package com.rubin.mvvmdemo.data.network

import com.rubin.mvvmdemo.data.db.entities.User

data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)