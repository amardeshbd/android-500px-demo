package com.hossainkhan.android.dpx.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hossainkhan.android.dpx.network.DpxApi
import com.hossainkhan.android.dpx.photobrowse.PhotoBrowserNavigator
import com.hossainkhan.android.dpx.photobrowse.PhotoBrowserViewModel

/**
 * Factory for ViewModels
 */
class ViewModelFactory(
    private val api: DpxApi,
    private val photoBrowserNavigator: PhotoBrowserNavigator
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoBrowserViewModel::class.java)) {
            return PhotoBrowserViewModel(api, photoBrowserNavigator) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
