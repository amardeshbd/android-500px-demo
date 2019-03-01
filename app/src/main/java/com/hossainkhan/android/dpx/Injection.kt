package com.hossainkhan.android.dpx

import android.content.Context
import com.hossainkhan.android.dpx.base.ViewModelFactory
import com.hossainkhan.android.dpx.network.DpxApi
import com.hossainkhan.android.dpx.network.DpxService

/**
 * Enables injection of different data sources without setting up Dagger.
 */
object Injection {
    fun provideServiceApi(): DpxApi {
        return DpxService.api
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        return ViewModelFactory(provideServiceApi())
    }
}
