package com.hossainkhan.android.dpx.photobrowse

import androidx.lifecycle.ViewModel
import com.hossainkhan.android.dpx.BuildConfig
import com.hossainkhan.android.dpx.network.DpxApi
import com.hossainkhan.android.dpx.network.models.Photos
import io.reactivex.Single

class PhotoBrowserViewModel(private val api: DpxApi) : ViewModel() {

    fun photoList(): Single<List<String>> {
        return api.photos(Photos.FEATURE_POPULAR, BuildConfig.API_KEY)
            .map { photos ->
                photos.photos.map { it.name }
            }
    }
}
