package com.hossainkhan.android.dpx.photobrowse

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.hossainkhan.android.dpx.BuildConfig
import com.hossainkhan.android.dpx.network.DpxApi
import com.hossainkhan.android.dpx.network.models.Photos
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PhotoBrowserViewModel(private val api: DpxApi) : ViewModel() {
    // TODO - data binding not working with observable field.
    val isNetworkRequestInProgress = ObservableField(false)

    val photos: LiveData<List<String>>
        get() {
            return LiveDataReactiveStreams.fromPublisher(
                api.photos(Photos.FEATURE_POPULAR, BuildConfig.API_KEY)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { isNetworkRequestInProgress.set(true) }
                    .doOnSuccess { isNetworkRequestInProgress.set(false) }
                    .doOnError { isNetworkRequestInProgress.set(false) }
                    .map { photos ->
                        photos.photos.map { it.name }
                    }.toFlowable()
            )
        }
}
