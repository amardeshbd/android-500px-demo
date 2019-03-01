package com.hossainkhan.android.dpx.photodetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.hossainkhan.android.dpx.R
import kotlinx.android.synthetic.main.activity_photo_details.*
import timber.log.Timber

/**
 * Details activity for a selected Photo.
 */
class PhotoDetailsActivity : AppCompatActivity() {
    companion object {
        const val INTENT_KEY_PHOTO_ID = "KEY_PHOTO_ID"

        fun createStartIntent(context: Context, photoId: Long): Intent {
            val intent = Intent(context, PhotoDetailsActivity::class.java)
            intent.putExtra(INTENT_KEY_PHOTO_ID, photoId)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_details)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "TODO: Share Image", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val photoId = intent.getLongExtra(INTENT_KEY_PHOTO_ID, -1L)
        Timber.d("Found photo ID: $photoId")
        if(photoId == -1L) {
            Snackbar.make(fab, "Photo ID Missing. Please select another photo.", Snackbar.LENGTH_LONG).show()
            return
        }
    }
}
