package com.hossainkhan.android.dpx

import com.hossainkhan.android.dpx.base.ViewModelFactory
import com.hossainkhan.android.dpx.network.DpxApi
import com.hossainkhan.android.dpx.network.DpxService
import com.hossainkhan.android.dpx.photobrowse.PhotoBrowserNavigator
import com.hossainkhan.android.dpx.photodetails.PhotoDetailsNavigator

/**
 * Enables injection of different data sources without setting up Dagger.
 */
object Injection {
    fun provideServiceApi(): DpxApi {
        return DpxService.api
    }

    fun provideViewModelFactory(
        photoBrowserNavigator: PhotoBrowserNavigator? = null,
        photoDetailsNavigator: PhotoDetailsNavigator? = null
    ): ViewModelFactory {
        return ViewModelFactory(provideServiceApi(), photoBrowserNavigator, photoDetailsNavigator)
    }
}
