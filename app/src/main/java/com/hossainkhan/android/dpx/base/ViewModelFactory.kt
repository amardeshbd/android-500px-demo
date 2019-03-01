package com.hossainkhan.android.dpx.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hossainkhan.android.dpx.network.DpxApi
import com.hossainkhan.android.dpx.photobrowse.PhotoBrowserViewModel

/**
 * Factory for ViewModels
 */
class ViewModelFactory(private val api: DpxApi) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoBrowserViewModel::class.java)) {
            return PhotoBrowserViewModel(api) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
