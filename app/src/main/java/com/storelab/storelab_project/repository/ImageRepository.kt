package com.storelab.storelab_project.repository

import com.storelab.storelab_project.model.Image
import com.storelab.storelab_project.network.ApiClient
import com.storelab.storelab_project.network.ApiInterface
import com.storelab.storelab_project.utils.AppConstant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImageRepository {
    private val api: ApiInterface

    init {
        /*val retrofit = Retrofit.Builder()
            .baseUrl("https://api.example.com/") // Replace with your API base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ApiService::class.java)*/

        api = ApiClient.getClient().create(ApiInterface::class.java);
    }

    fun fetchImages(callback: (List<Image>) -> Unit) {
        api.getImagesfromurl1()!!.enqueue(object : Callback<List<Image>> {
            override fun onResponse(call: Call<List<Image>>, response: Response<List<Image>>) {
                if (response.isSuccessful) {
                    val images = response.body() ?: emptyList()
                    callback(images)
                }
            }

            override fun onFailure(call: Call<List<Image>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
