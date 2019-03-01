package com.hossainkhan.android.dpx.photodetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.hossainkhan.android.dpx.Injection
import com.hossainkhan.android.dpx.R
import com.hossainkhan.android.dpx.base.ViewModelFactory
import com.hossainkhan.android.dpx.databinding.ActivityPhotoDetailsBinding
import timber.log.Timber

/**
 * Details activity for a selected Photo.
 */
class PhotoDetailsActivity : AppCompatActivity(), PhotoDetailsNavigator {
    companion object {
        const val INTENT_KEY_PHOTO_ID = "KEY_PHOTO_ID"

        fun createStartIntent(context: Context, photoId: Long): Intent {
            val intent = Intent(context, PhotoDetailsActivity::class.java)
            intent.putExtra(INTENT_KEY_PHOTO_ID, photoId)
            return intent
        }
    }

    private lateinit var binding: ActivityPhotoDetailsBinding
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: PhotoDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_details)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo_details)
        binding.lifecycleOwner = this

        viewModelFactory = Injection.provideViewModelFactory(photoDetailsNavigator = this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PhotoDetailsViewModel::class.java)


        setSupportActionBar(binding.toolbar)
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "TODO: Share Image", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val photoId = intent.getLongExtra(INTENT_KEY_PHOTO_ID, -1L)
        Timber.d("Found photo ID: $photoId")
        if(photoId == -1L) {
            Snackbar.make(binding.root, "Photo ID Missing. Please select another photo.", Snackbar.LENGTH_LONG).show()
            return
        }
    }
}
