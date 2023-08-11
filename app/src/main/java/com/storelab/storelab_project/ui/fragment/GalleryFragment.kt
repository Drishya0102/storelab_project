package com.storelab.storelab_project.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.storelab.storelab_project.databinding.FragmentGalleryBinding
import com.storelab.storelab_project.model.Image
import com.storelab.storelab_project.model.SharedViewModel
import com.storelab.storelab_project.adapter.ImageListAdapter
import com.storelab.storelab_project.utils.AppConstant

class GalleryFragment : Fragment(),ImageListAdapter.OnItemClickListener {

    private lateinit var binding: FragmentGalleryBinding
    var imageadapter : ImageListAdapter?= null
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(layoutInflater)
        return binding.root
    }
//    val appContext = requireContext().applicationContext

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupData()
    }

    private fun setupData() {
        binding.rvImages.layoutManager = GridLayoutManager(activity,2)
        imageadapter = ImageListAdapter(requireContext())//ImageListAdapter(requireContext())
        binding.rvImages.setAdapter(imageadapter)
        imageadapter!!.setOnItemClickListener(this)
        getData()
    }


    private fun getData() {
        if(sharedViewModel.imgList.size==0)
        {
            if(AppConstant.isNetworkConnected(activity))
            {
                sharedViewModel.imageList.observe(this.requireActivity()) { images ->
                    // Update your UI with the list of images
                    //imageadapter!!.setImageList(images)

                    sharedViewModel.imgList = images as MutableList<Image>
                    imageadapter!!.setImageList(sharedViewModel.imgList)
                }
            }
            else
            {
                AppConstant.showToast(context,"Please check your internet Connection and try again!")
            }
        }
        else
        {
            imageadapter!!.setImageList(sharedViewModel.imgList)
        }
    }

    override fun onItemClick(item: Image?, position: Int) {
        if (item != null) {
          /*  if (sharedViewModel.favoriteList.contains(item) == true)
            {
                sharedViewModel.removeFromFavorites(item)
            }
            else
            {
                sharedViewModel.addToFavorites(item)
            }*/
           // sharedViewModel.toggleFavorite(item)
            sharedViewModel.togglefav(item)
        }
    }



    /* sharedViewModel.getImagePagewise()!!.observe(this.requireActivity()) {
               userList ->
           imageadapter?.setImageList(userList as ArrayList<Image>)
       }*/
    /* sharedViewModel.getImagePagewise()!!.observe(this.requireActivity())
     {
             userList -> sharedViewModel.imageList.addAll(userList as ArrayList<Image>)
     }
     val imagelist = sharedViewModel.imageList
     imageadapter!!.setImageList(imagelist)*/

    /*val images = sharedViewModel.imageList.value
    imageadapter!!.setImageList(images as MutableList<Image>)*/


}