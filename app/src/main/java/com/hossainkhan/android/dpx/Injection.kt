package com.hossainkhan.android.dpx

import com.hossainkhan.android.dpx.base.ViewModelFactory
import com.hossainkhan.android.dpx.network.DpxApi
import com.hossainkhan.android.dpx.network.DpxService
import com.hossainkhan.android.dpx.photobrowse.PhotoBrowserNavigator

/**
 * Enables injection of different data sources without setting up Dagger.
 */
object Injection {
    fun provideServiceApi(): DpxApi {
        return DpxService.api
    }

    fun provideViewModelFactory(photoBrowserNavigator: PhotoBrowserNavigator): ViewModelFactory {
        return ViewModelFactory(provideServiceApi(), photoBrowserNavigator)
    }
}
