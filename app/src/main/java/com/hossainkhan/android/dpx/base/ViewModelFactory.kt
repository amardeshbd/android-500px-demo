package com.hossainkhan.android.dpx.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hossainkhan.android.dpx.network.DpxApi
import com.hossainkhan.android.dpx.photobrowse.PhotoBrowserNavigator
import com.hossainkhan.android.dpx.photobrowse.PhotoBrowserViewModel
import com.hossainkhan.android.dpx.photodetails.PhotoDetailsNavigator
import com.hossainkhan.android.dpx.photodetails.PhotoDetailsViewModel

/**
 * Factory for android [ViewModel]s
 */
class ViewModelFactory(
    private val api: DpxApi,
    private val photoBrowserNavigator: PhotoBrowserNavigator?,
    private val photoDetailsNavigator: PhotoDetailsNavigator?
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (photoBrowserNavigator != null && modelClass.isAssignableFrom(PhotoBrowserViewModel::class.java)) {
            return PhotoBrowserViewModel(api, photoBrowserNavigator) as T
        } else if (photoDetailsNavigator != null && modelClass.isAssignableFrom(PhotoDetailsViewModel::class.java)) {
            return PhotoDetailsViewModel(api, photoDetailsNavigator) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
