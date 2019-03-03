package com.hossainkhan.android.dpx.photodetails

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.hossainkhan.android.dpx.Injection
import com.hossainkhan.android.dpx.R
import com.hossainkhan.android.dpx.base.ViewModelFactory
import com.hossainkhan.android.dpx.databinding.ActivityPhotoDetailsBinding
import com.hossainkhan.android.dpx.network.models.Photo
import timber.log.Timber

/**
 * Details activity for a selected Photo.
 */
class PhotoDetailsActivity : AppCompatActivity(), PhotoDetailsNavigator {
    companion object {
        const val INTENT_KEY_PHOTO_INFO = "KEY_PHOTO_INFO"

        fun createStartIntent(context: Context, photo: Photo): Intent {
            val intent = Intent(context, PhotoDetailsActivity::class.java)
            intent.putExtra(INTENT_KEY_PHOTO_INFO, photo)
            return intent
        }
    }

    private lateinit var binding: ActivityPhotoDetailsBinding
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: PhotoDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo_details)
        binding.lifecycleOwner = this

        val photo = intent.getParcelableExtra<Photo>(INTENT_KEY_PHOTO_INFO)
        Timber.d("Found photo info: $photo")
        if (photo == null) {
            Snackbar.make(binding.root, "Photo ID Missing. Please select another photo.", Snackbar.LENGTH_LONG).show()
            return
        }


        viewModelFactory = Injection.provideViewModelFactory(photoDetailsNavigator = this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PhotoDetailsViewModel::class.java)


        setupActionBar(photo)

        // Finally binds everything related to photo
        binding.photoInfo = photo
        binding.viewModel = viewModel
    }

    private fun setupActionBar(photo: Photo) {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Updates the photo title
        supportActionBar?.title = photo.name
        binding.toolbar.title = photo.name
    }

    override fun onSharePhoto(photoUrl: String) {
        val webpage: Uri = Uri.parse(photoUrl)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Timber.w("User does not seem to have any browser or email client.")
        }
    }
}
