package com.storelab.storelab_project.adapter;

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.storelab.storelab_project.R
import com.storelab.storelab_project.databinding.ItemImageBinding
import com.storelab.storelab_project.model.Image
import com.storelab.storelab_project.ui.fragment.FavouriteFragment


class FavouriteListAdapter(var context: Context) :
    RecyclerView.Adapter<FavouriteListAdapter.FavouriteListAdapterHolder>()
{
    var images=arrayListOf<Image>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =

        FavouriteListAdapterHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: FavouriteListAdapterHolder, position: Int) {
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

    fun setImageList(loadedimages: MutableList<Image>) {
        try
        {
            this.images.clear()
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


    inner class FavouriteListAdapterHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {

        }

        fun bind(item: Image) = with(binding) {
            Glide.with(itemView.context)
                .load(item.download_url)
                .placeholder(R.drawable.default_img)
                .into(imageView)
        }
    }



}
