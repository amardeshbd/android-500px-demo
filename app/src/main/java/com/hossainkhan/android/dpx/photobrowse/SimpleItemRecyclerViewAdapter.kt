package com.hossainkhan.android.dpx.photobrowse

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hossainkhan.android.dpx.databinding.ItemListContentBinding

class SimpleItemRecyclerViewAdapter :
    RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {
    private val values: MutableList<String> = mutableListOf()

    fun updateData(data: List<String>) {
        values.clear()
        values.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListContentBinding.inflate(android.view.LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.contentView.text = item
    }

    override fun getItemCount() = values.size

    inner class ViewHolder(binding: ItemListContentBinding) : RecyclerView.ViewHolder(binding.root) {
        val contentView: TextView = binding.content
    }
}