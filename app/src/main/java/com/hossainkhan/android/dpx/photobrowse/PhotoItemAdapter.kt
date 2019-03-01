package com.hossainkhan.android.dpx.photobrowse

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hossainkhan.android.dpx.databinding.ItemListPhotoBinding
import com.squareup.picasso.Picasso

class PhotoItemAdapter(
    private val viewModel: PhotoBrowserViewModel
) :
    RecyclerView.Adapter<PhotoItemAdapter.ViewHolder>() {
    private val values: MutableList<String> = mutableListOf()

    fun updateData(data: List<String>) {
        values.clear()
        values.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListPhotoBinding.inflate(android.view.LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, this::itemClickHandler)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        Picasso.get().load(item).into(holder.contentView)
    }

    override fun getItemCount() = values.size

    class ViewHolder(
        binding: ItemListPhotoBinding,
        private val onClickListener: (Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        val contentView: ImageView = binding.photoItem

        init {
            binding.photoItem.setOnClickListener {
                onClickListener(adapterPosition)
            }
        }
    }

    private fun itemClickHandler(position: Int) {
        viewModel.onPhotoSelected(values[position])
    }
}