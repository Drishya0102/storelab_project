package com.storelab.storelab_project.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.storelab.storelab_project.repository.ImageRepository;

import java.util.List;

public class GalleryViewModel extends AndroidViewModel {
    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }
    /*ImageRepository repository;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        repository = new ImageRepository(application);
    }


    public LiveData<List<Image>> getImagePagewise() {

        return repository.getImages();
    }*/
}
