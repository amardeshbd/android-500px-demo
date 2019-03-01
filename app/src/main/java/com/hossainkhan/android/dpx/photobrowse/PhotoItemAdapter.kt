package com.hossainkhan.android.dpx.photobrowse

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hossainkhan.android.dpx.databinding.ItemListPhotoBinding
import com.squareup.picasso.Picasso

class PhotoItemAdapter :
    RecyclerView.Adapter<PhotoItemAdapter.ViewHolder>() {
    private val values: MutableList<String> = mutableListOf()

    fun updateData(data: List<String>) {
        values.clear()
        values.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListPhotoBinding.inflate(android.view.LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        Picasso.get().load(item).into(holder.contentView)
    }

    override fun getItemCount() = values.size

    inner class ViewHolder(binding: ItemListPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        val contentView: ImageView = binding.photoItem
    }
}