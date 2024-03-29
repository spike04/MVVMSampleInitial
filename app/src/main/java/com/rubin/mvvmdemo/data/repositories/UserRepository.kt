package com.rubin.mvvmdemo.data.repositories

import com.rubin.mvvmdemo.data.db.AppDatabase
import com.rubin.mvvmdemo.data.db.entities.User
import com.rubin.mvvmdemo.data.network.AuthResponse
import com.rubin.mvvmdemo.data.network.MyApi
import com.rubin.mvvmdemo.data.network.SafeApiRequest

class UserRepository(private val api: MyApi, private val db: AppDatabase) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getUser()
}