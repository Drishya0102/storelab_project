package com.storelab.storelab_project.network;

import com.storelab.storelab_project.model.Image
import com.storelab.storelab_project.utils.AppConstant.Companion.QUERY_PER_PAGE
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

public interface ApiInterface {


    /*@GET("v2/list")
    fun getImagesfromurl(): Call<ImageList>*/

    @GET("v2/list")
    fun getallImages(): Call<List<Image?>?>?
    @GET("v2/list")
    fun getImagesfromurl() : Response<List<Image>>
    @GET("v2/list?page=1&limit=100")
    fun getImagesfromurl1()
       : Call<List<Image>>

    @GET("v2/list")
    suspend fun getImages(
        @Query("page")
        pageNumber: Int = 1,
        @Query("limit")
        pageSize: Int = QUERY_PER_PAGE
    ): Response<List<Image>>
}
