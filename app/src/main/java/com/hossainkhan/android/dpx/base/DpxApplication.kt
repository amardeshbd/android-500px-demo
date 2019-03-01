package com.hossainkhan.android.dpx.base

import android.app.Application
import com.hossainkhan.android.dpx.BuildConfig
import timber.log.Timber


class DpxApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}