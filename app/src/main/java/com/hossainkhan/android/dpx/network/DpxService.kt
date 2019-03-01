package com.hossainkhan.android.dpx.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit service to access [DpxApi].
 */
object DpxService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.500px.com/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: DpxApi = retrofit.create(DpxApi::class.java)
}