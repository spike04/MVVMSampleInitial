package com.rubin.mvvmdemo

import android.app.Application
import com.rubin.mvvmdemo.data.db.AppDatabase
import com.rubin.mvvmdemo.data.network.MyApi
import com.rubin.mvvmdemo.data.network.NetworkConnectionInterceptor
import com.rubin.mvvmdemo.data.repositories.UserRepository
import com.rubin.mvvmdemo.ui.auth.AuthViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { AuthViewModelFactory(instance()) }
    }
}