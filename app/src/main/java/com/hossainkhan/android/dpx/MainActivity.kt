package com.hossainkhan.android.dpx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hossainkhan.android.dpx.network.DpxApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // TODO - Remove test code
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.500px.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(DpxApi::class.java)

        service.photos("popular", BuildConfig.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.d("Data $it")
            }, { error ->
                Timber.d(error)
            })
    }
}
