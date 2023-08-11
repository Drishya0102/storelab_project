package com.storelab.storelab_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.storelab.storelab_project.R
import com.storelab.storelab_project.model.Image

class ImageAdapter(private val images: List<Image>, var context: Context) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
       /* val binding = ItemImageBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)*/
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = images[position]
        //Picasso.with(context).load(image.download_url).into(holder.imageView);
      /*  Picasso.with(context).
        load(image.download_url).
        into(holder.imageView);*/

    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
/*

class ImageAdapter(var context: Context) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    val imageUrls: Array<String>

    init {
        imageUrls = arrayOf("https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg", "https://i.imgur.com/kUCMPWX.jpg")
    }

    override fun getItemCount(): Int {
        return imageUrls.size;
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        var imageUrl = imageUrls[position]
        Picasso.with(context).load(imageUrl).into(holder?.imageView);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        var imageItem = LayoutInflater.from(parent?.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(imageItem)
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
*/
