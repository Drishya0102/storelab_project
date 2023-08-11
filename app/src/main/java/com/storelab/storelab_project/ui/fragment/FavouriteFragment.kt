package com.storelab.storelab_project.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.storelab.storelab_project.adapter.FavouriteListAdapter
import com.storelab.storelab_project.databinding.FragmentFavouriteBinding
import com.storelab.storelab_project.model.SharedViewModel

class FavouriteFragment : Fragment() {

    private lateinit var binding: FragmentFavouriteBinding
    var favimageadapter : FavouriteListAdapter?= null
    private val sharedViewModel: SharedViewModel by activityViewModels()
    // Access favorite list
    private fun accessFavoriteList() {
        val favoriteList = sharedViewModel.favoriteList
        // Use favoriteList as needed
        if(favoriteList.size==0)
        {
            binding.tvNofav.visibility=View.VISIBLE
            binding.rvFavimages.visibility=View.GONE
        }
        else
        {
            favimageadapter!!.setImageList(favoriteList)
            binding.tvNofav.visibility=View.GONE
            binding.rvFavimages.visibility=View.VISIBLE
        }
//
        /* sharedViewModel.favoriteList.observe(this.requireActivity()) { favorites ->
             favimageadapter.submitList(favorites)
         }*/

        // Observe favoriteList and update UI




    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouriteBinding.inflate(layoutInflater)
        return binding.root
    }
    //val appContext = requireContext().applicationContext

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupData()
    }

    private fun setupData() {
        binding.rvFavimages.layoutManager = GridLayoutManager(activity,2)
        favimageadapter = FavouriteListAdapter(requireContext())
        binding.rvFavimages.setAdapter(favimageadapter)

        accessFavoriteList()
    }



}