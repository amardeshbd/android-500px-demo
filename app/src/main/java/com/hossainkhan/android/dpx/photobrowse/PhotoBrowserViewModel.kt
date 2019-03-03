package com.hossainkhan.android.dpx.photobrowse

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.hossainkhan.android.dpx.BuildConfig
import com.hossainkhan.android.dpx.network.DpxApi
import com.hossainkhan.android.dpx.network.models.Photo
import com.hossainkhan.android.dpx.network.models.Photos
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class PhotoBrowserViewModel(private val api: DpxApi,
                            private val navigator: PhotoBrowserNavigator) : ViewModel() {
    val isNetworkRequestInProgress = ObservableField(false)

    val photos: LiveData<List<Photo>>
        get() {
            return LiveDataReactiveStreams.fromPublisher(
                api.photos(BuildConfig.API_KEY, Photos.FEATURE_POPULAR, Photos.IMAGE_SIZE_600)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { isNetworkRequestInProgress.set(true) }
                    .doOnSuccess { isNetworkRequestInProgress.set(false) }
                    .doOnError { isNetworkRequestInProgress.set(false) }
                    .map { photos ->
                        photos.photos
                    }.toFlowable()
            )
        }


    fun onPhotoSelected(photo: Photo) {
        Timber.d("Selected photo with URL: ${photo.imageUrl}")
        navigator.openPhotoDetailsView(photo)
    }
}
