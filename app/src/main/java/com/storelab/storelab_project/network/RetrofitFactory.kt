package com.storelab.storelab_project.network

import com.google.gson.GsonBuilder
import com.storelab.storelab_project.utils.AppConstant.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    fun retrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()



   /* var retrofit =  Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .build()*/

/*Retrofit.Builder()
        .client(getUnsafeOkHttpClient())
        .baseUrl(BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()*/

}