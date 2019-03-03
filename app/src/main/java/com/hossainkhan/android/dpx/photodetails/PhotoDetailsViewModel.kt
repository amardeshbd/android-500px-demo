package com.hossainkhan.android.dpx.photodetails

import androidx.lifecycle.ViewModel
import com.hossainkhan.android.dpx.network.DpxApi
import com.hossainkhan.android.dpx.network.models.Photo
import timber.log.Timber

class PhotoDetailsViewModel(
    private val api: DpxApi,
    private val navigator: PhotoDetailsNavigator
) : ViewModel() {
    companion object {
        private const val DPX_BASEURL = "https://500px.com"
    }

    fun onPhotoShareClicked(photo: Photo) {
        val photoUrl = "$DPX_BASEURL${photo.websiteUrl}"
        Timber.d("User sharing photo URL: $photoUrl")
        navigator.onSharePhoto(photoUrl)
    }
}