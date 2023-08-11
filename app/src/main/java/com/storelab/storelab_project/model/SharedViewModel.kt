package com.storelab.storelab_project.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.storelab.storelab_project.repository.ImageRepository

class SharedViewModel (private val repository: ImageRepository) : ViewModel() {
    var imgList = mutableListOf<Image>()
    val favoriteList = mutableListOf<Image>()
    var _imageList = MutableLiveData<List<Image>>()
    var imageList: LiveData<List<Image>> = _imageList
 //   private val _favoriteList = MutableLiveData<List<Image>>()
   // val favoriteList: LiveData<List<Image>> = _favoriteList
    init {
        fetchImages()
    }

    private fun fetchImages() {
        repository.fetchImages { images ->
            _imageList.postValue(images)
        }
    }

    fun togglefav(image: Image)
    {
        if(!image.isFavorite)
        {
            favoriteList.add(image)
            image.isFavorite=true
        }
        else
        {
            favoriteList.remove(image)
            image.isFavorite=false
        }

    }

  /*  fun removeFromFavorites(image: Image) {
        favoriteList.remove(image)
    }*/

    /*fun toggleFavorite(image: Image) {
        image.isFavorite = !image.isFavorite
        if (image.isFavorite) {
            _favoriteList.value = (favoriteList. ?: emptyList()) + image
        } else {
            _favoriteList.value = (favoriteList.value ?: emptyList()).filter { it != image }
        }
    }*/
}