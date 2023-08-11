package com.storelab.storelab_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.storelab.storelab_project.R
import com.storelab.storelab_project.databinding.ItemImageBinding
import com.storelab.storelab_project.model.Image

class ImageDisplayAdapter(private val images: List<Image>, var context: Context) :
    RecyclerView.Adapter<ImageDisplayAdapter.ImageDisplayAdapterViewHolder>()
{
    var imageClickListener: ImageItemClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ImageDisplayAdapterViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ImageDisplayAdapterViewHolder, position: Int) {
        holder.bind(images.get(position))
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ImageDisplayAdapterViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                imageClickListener?.onImageClicked(
                    binding,
                    images.get(position)
                )
            }
        }

        fun bind(item: Image) = with(binding) {
            Glide.with(itemView.context)
                .load(item.download_url)
                .placeholder(R.drawable.default_img)
                .into(imageView)
        }
    }

    object ItemComparator : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image) =
            oldItem.download_url == newItem.download_url

        override fun areContentsTheSame(oldItem: Image, newItem: Image) =
            oldItem == newItem
    }

    interface ImageItemClickListener {
        fun onImageClicked(binding: ItemImageBinding, item: Image)
    }
}