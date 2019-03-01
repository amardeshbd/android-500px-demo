package com.hossainkhan.android.dpx.network

import com.hossainkhan.android.dpx.network.models.Photos
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DpxApi {
    /**
     * https://github.com/500px/legacy-api-documentation/blob/master/endpoints/photo/GET_photos.md
     *
     * Example API: https://api.500px.com/v1/photos?feature=popular
     */
    @GET("/v1/photos")
    fun photos(
        @Query("feature") feature: String,
        @Query("consumer_key") key: String
    ): Single<Photos>
}