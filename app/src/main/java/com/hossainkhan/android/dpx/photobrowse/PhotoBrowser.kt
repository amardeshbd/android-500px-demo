package com.hossainkhan.android.dpx.photobrowse

import android.os.Bundle
import android.view.View
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
import com.hossainkhan.android.dpx.extensions.onChanged
import com.hossainkhan.android.dpx.ui.GridSpacingItemDecoration
import timber.log.Timber

class PhotoBrowser : AppCompatActivity() {

    private lateinit var binding: ActivityPhotoBrowserBinding
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: PhotoBrowserViewModel
    private lateinit var adapter: PhotoItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_photo_browser)
        binding.lifecycleOwner = this

        viewModelFactory = Injection.provideViewModelFactory(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PhotoBrowserViewModel::class.java)

        setupRecyclerView(binding.recyclerView)

        observePhotoUpdates()

        viewModel.isNetworkRequestInProgress.onChanged {
            // TODO - move this to data binding
            Timber.d("Is in progress: $it")
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

    private fun observePhotoUpdates() {
        viewModel.photos.observe(this, Observer { photos ->
            Timber.d("Received photos. Total items: ${photos.size}")
            adapter.updateData(photos)
        })
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        adapter = PhotoItemAdapter()
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
}
