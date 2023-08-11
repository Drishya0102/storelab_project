package com.storelab.storelab_project.adapter;

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.storelab.storelab_project.R
import com.storelab.storelab_project.databinding.ChildImageBinding
import com.storelab.storelab_project.model.Image
import com.storelab.storelab_project.ui.fragment.GalleryFragment


class ImageListAdapter(var context:Context) : RecyclerView.Adapter<ImageListAdapter.ImageListAdapterHolder>()
{
    public var listener: OnItemClickListener? = null
    var images=arrayListOf<Image>()
   // var images=arrayListOf<Image>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =

        ImageListAdapterHolder(
            ChildImageBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ImageListAdapterHolder, position: Int) {
        val currentimage: Image = images!![position]
        holder.bind(currentimage)
    }

    override fun getItemCount(): Int {
        return if (images != null) {
            images!!.size
        } else {
            0
        }
    }

   /* fun setImageList(loadedimages: ArrayList<Image>) {
        try
        {
            this.images.addAll(loadedimages)
            notifyDataSetChanged()
        }
        catch (ex:Exception)
        {
            ex.toString()
        }
    }*/

   /* fun setImageList(loadedimages: MutableList<Image>) {
        try
        {
            this.images.addAll(loadedimages)
            notifyDataSetChanged()
        }
        catch (ex:Exception)
        {
            ex.toString()
        }
    }*/

    fun setImageList(loadedimages: List<Image>) {
        try
        {

            this.images.addAll(loadedimages)
            notifyDataSetChanged()
        }
        catch (ex:Exception)
        {
            ex.toString()
        }
    }


    fun getCurrentItemAt(position: Int): Image? {
        return images!![position]
    }

    interface OnItemClickListener {
        fun onItemClick(user: Image?,position: Int)
    }

    inner class ImageListAdapterHolder(private val binding: ChildImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    var item=getCurrentItemAt(position)
                    listener!!.onItemClick(item,position)

                    val favoriteIconRes = if (item!!.isFavorite) R.drawable.selected_fav else R.drawable.unselected_fav
                    binding.imgFav.setImageResource(favoriteIconRes)
                }
            }
        }

        fun bind(item: Image) = with(binding) {
            Glide.with(itemView.context)
                .load(item.download_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(withCrossFade())
                .downsample(DownsampleStrategy.AT_MOST)
                .placeholder(R.drawable.default_img)
                .into(imageitem)

            val favoriteIconRes = if (item.isFavorite) R.drawable.selected_fav else R.drawable.unselected_fav
            imgFav.setImageResource(favoriteIconRes)

           /* // Handle favorite button click
            imgFav.setOnClickListener {
                sharedViewModel.toggleFavorite(image)
            }*/
        }
    }
    fun setOnItemClickListener(listener: GalleryFragment) {
        this.listener = listener

    }

}


