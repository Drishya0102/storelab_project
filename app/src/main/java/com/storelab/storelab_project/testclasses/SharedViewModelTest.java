package com.storelab.storelab_project.testclasses;


//import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.storelab.storelab_project.model.Image;
import com.storelab.storelab_project.model.SharedViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class SharedViewModelTest {

   /* @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private SharedViewModel sharedViewModel;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        sharedViewModel = new SharedViewModel();
    }

    @Test
    public void testAddToFavorites() {
        Image mockImage = new Image("MockImageUrl", "MockImageTitle");

        sharedViewModel.togglefav(mockImage);

        assert(sharedViewModel.getFavoriteImages().getValue().contains(mockImage));
    }

    @Test
    public void testRemoveFromFavorites() {
        Image mockImage = new Image("1", "author","downloa_url",false);
        sharedViewModel.setImageList(mockImage);

        sharedViewModel.removeFromFavorites(mockImage);

        assert(!sharedViewModel.getFavoriteImages().getValue().contains(mockImage));
    }

    @Test
    public void testFavoriteImagesLiveData() {
        MutableLiveData<List<Image>> mockLiveData = new MutableLiveData<>();
        sharedViewModel.set(mockLiveData);

        // Assuming you update the LiveData with a list of images
        List<Image> mockImageList = new ArrayList<>();
        mockImageList.add(new Image("Url1", "Title1"));
        mockLiveData.setValue(mockImageList);

        // Observe the LiveData and verify the change
        sharedViewModel.getFavoriteImages().observeForever(images -> {
            assert(images != null);
            assert(images.size() == 1);
        });
    }*/
}