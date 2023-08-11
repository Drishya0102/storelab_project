package com.storelab.storelab_project.model;

import static com.storelab.storelab_project.utils.AppConstant.TOTAL_PAGES;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.storelab.storelab_project.repository.ImageRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    public UserViewModel(@NonNull Application application) {
        super(application);
    }
  /*  ImageRepository repository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new ImageRepository(application);
    }

    *//*public LiveData<List<Image>> getAllUsers() {
        return repository.getImages(1);
    }*//*


    public LiveData<List<Image>> getImagePagewise() {
        *//*int nextPageNumber = 0;
        int pageNumber =1;
        if (pageNumber < TOTAL_PAGES) {
            nextPageNumber = pageNumber + 1;
        }*//*

        return repository.getImages();
    }*/
}
