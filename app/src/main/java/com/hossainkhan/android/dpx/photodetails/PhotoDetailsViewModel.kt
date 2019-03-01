package com.hossainkhan.android.dpx.photodetails

import androidx.lifecycle.ViewModel
import com.hossainkhan.android.dpx.network.DpxApi

class PhotoDetailsViewModel(
    private val api: DpxApi,
    private val navigator: PhotoDetailsNavigator
) : ViewModel()