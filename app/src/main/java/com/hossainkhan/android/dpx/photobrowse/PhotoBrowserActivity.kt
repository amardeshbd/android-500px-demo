package com.hossainkhan.android.dpx.photobrowse

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hossainkhan.android.dpx.Injection
import com.hossainkhan.android.dpx.R
import com.hossainkhan.android.dpx.base.ViewModelFactory
import com.hossainkhan.android.dpx.databinding.ActivityPhotoBrowserBinding
import com.hossainkhan.android.dpx.network.models.Photo
import com.hossainkhan.android.dpx.photodetails.PhotoDetailsActivity
import com.hossainkhan.android.dpx.ui.GridSpacingItemDecoration
import timber.log.Timber

class PhotoBrowserActivity : AppCompatActivity(), PhotoBrowserNavigator {

    private lateinit var binding: ActivityPhotoBrowserBinding
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: PhotoBrowserViewModel
    private lateinit var adapter: PhotoItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo_browser)
        binding.lifecycleOwner = this

        viewModelFactory = Injection.provideViewModelFactory(photoBrowserNavigator = this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PhotoBrowserViewModel::class.java)
        binding.viewModel = viewModel

        setupRecyclerView(binding.recyclerView)

        observePhotoUpdates()
    }

    private fun observePhotoUpdates() {
        viewModel.photos.observe(this, Observer { photos ->
            Timber.d("Received photos. Total items: ${photos.size}")
            adapter.updateData(photos)
        })
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        adapter = PhotoItemAdapter(viewModel)
        val spanSize = resources.getInteger(R.integer.grid_column_count)
        recyclerView.layoutManager = GridLayoutManager(this, spanSize)
        recyclerView.addItemDecoration(
            GridSpacingItemDecoration(
                spanSize,
                resources.getDimension(R.dimen.grid_item_spacing).toInt(),
                true
            )
        )
        recyclerView.adapter = adapter
    }


    override fun openPhotoDetailsView(photo: Photo) {
        startActivity(PhotoDetailsActivity.createStartIntent(this, photo))
    }

    override fun showApiKeyMissingError() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.dialog_message_api_key_missing)
            .setTitle(R.string.dialog_title_api_key_missing)
            .setPositiveButton(android.R.string.ok, null)

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
