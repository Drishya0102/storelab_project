package com.storelab.storelab_project.apis;

import com.storelab.storelab_project.model.Image;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequestData {
    @GET("v2/list")
    Call<List<Image>> getImages();

}
