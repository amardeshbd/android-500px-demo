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
import com.hossainkhan.android.dpx.network.models.Photo
import com.hossainkhan.android.dpx.ui.RoundedCornersTransformation
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_photo_details.view.*
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


        val photo = intent.getParcelableExtra<Photo>(INTENT_KEY_PHOTO_INFO)
        Timber.d("Found photo info: $photo")
        if (photo == null) {
            Snackbar.make(binding.root, "Photo ID Missing. Please select another photo.", Snackbar.LENGTH_LONG).show()
            return
        }

        bindPhoto(photo)
        bindUserInformation(photo)
    }

    private fun bindPhoto(photo: Photo) {
        binding.toolbar.title = photo.name
        Picasso.get().load(photo.imageUrl).into(binding.imageViewCollapsing)
    }

    private fun bindUserInformation(photo: Photo) {
        binding.mainContent.authorName.text = photo.user.fullname
        Picasso.get()
            .load(photo.user.userPicUrl)
            .transform(RoundedCornersTransformation(200, 20))
            .into(binding.mainContent.authorThumb)
    }
}
