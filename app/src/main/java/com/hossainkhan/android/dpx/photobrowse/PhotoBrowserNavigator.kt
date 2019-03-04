package com.hossainkhan.android.dpx.photobrowse

import com.hossainkhan.android.dpx.network.models.Photo

/**
 * Navigator for photo browser to navigate to different screens.
 */
interface PhotoBrowserNavigator {
    fun openPhotoDetailsView(photo: Photo)
    fun showApiKeyMissingError()
}