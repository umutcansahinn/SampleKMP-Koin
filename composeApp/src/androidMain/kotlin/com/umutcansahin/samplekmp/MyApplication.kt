package com.umutcansahin.samplekmp

import android.app.Application
import com.umutcansahin.samplekmp.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApplication)
        }
    }
}