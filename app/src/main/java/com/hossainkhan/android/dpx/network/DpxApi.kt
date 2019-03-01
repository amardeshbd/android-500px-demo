package com.hossainkhan.android.dpx.network

import com.hossainkhan.android.dpx.network.models.Photos
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * APIs for 500px (Dpx).
 *
 * See https://github.com/500px/legacy-api-documentation/tree/master/endpoints
 */
interface DpxApi {
    /**
     * https://github.com/500px/legacy-api-documentation/blob/master/endpoints/photo/GET_photos.md
     *
     * Example API: https://api.500px.com/v1/photos?feature=popular
     */
    @GET("/v1/photos")
    fun photos(
        @Query("consumer_key") key: String,
        @Query("feature") feature: String,
        @Query("image_size") imageSize: Int
    ): Single<Photos>
}