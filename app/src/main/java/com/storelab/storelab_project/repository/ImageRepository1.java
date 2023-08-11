package com.storelab.storelab_project.repository;

import androidx.lifecycle.MutableLiveData;

import com.storelab.storelab_project.model.Image;
import com.storelab.storelab_project.network.ApiClient;
import com.storelab.storelab_project.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageRepository1 {

    /*ArrayList<Image> ImageArrayList = new ArrayList<>();
    MutableLiveData<List<Image>> mutableLiveData = new MutableLiveData<>();
    Application application;
    public ImageRepository(Application application) {
        this.application = application;
    }*/
    ArrayList<Image> ImageArrayList = new ArrayList<>();
    private MutableLiveData<ArrayList<Image>> imageList = new MutableLiveData<ArrayList<Image>>();


    /*public MutableLiveData<List<Image>> getImages()
    {
        if (AppConstant.isNetworkConnected(application.getApplicationContext()))
        {


            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<List<Image>> call = apiService.getImagesfromurl1();
            call.enqueue(new Callback<List<Image>>() {
                @Override
                public void onResponse(Call<List<Image>> call, Response<List<Image>> response) {
                    if (response.body() != null) {
                        ImageArrayList = (ArrayList<Image>) response.body();
                        mutableLiveData.setValue(ImageArrayList);
                    }
                }

                @Override
                public void onFailure(Call<List<Image>> call, Throwable t) {
                }
            });
        }
            return mutableLiveData;
    }*/

    /*public List<Image> fetchImages()
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        apiService.getImagesfromurl1().enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call, Response<List<Image>> response) {
                if (response.isSuccessful()) {
                    response.body();
                    callback(images)
                }
            }

            @Override
            public void onFailure(Call<List<Image>> call, Throwable t) {

            }
        })
    }*/
    public List<Image> getImages()
    {
        /*if (AppConstant.isNetworkConnected(application.getApplicationContext()))
        {*/
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<List<Image>> call = apiService.getImagesfromurl1();
            call.enqueue(new Callback<List<Image>>() {
                @Override
                public void onResponse(Call<List<Image>> call, Response<List<Image>> response) {
                    if (response.body() != null) {
                        ImageArrayList = (ArrayList<Image>) response.body();
                        imageList.setValue(ImageArrayList);
                    }
                }

                @Override
                public void onFailure(Call<List<Image>> call, Throwable t) {
                }
            });
       // }
        return (List<Image>) imageList;
    }

}
