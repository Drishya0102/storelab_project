package com.storelab.storelab_project.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.storelab.storelab_project.repository.ImageRepository

class SharedViewModelFactory(private val repository: ImageRepository) : ViewModelProvider.Factory {
    /* override fun <T : ViewModel> create(modelClass: Class<T>): T {
         if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
             @Suppress("UNCHECKED_CAST")
             return SharedViewModel(repository) as T
         }
         throw IllegalArgumentException("Unknown ViewModel class")
     }*/
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        try
        {
            if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SharedViewModel(repository) as T
            }
        }
        catch (Ex: Exception)
        {
            Ex.toString()
            //return
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
