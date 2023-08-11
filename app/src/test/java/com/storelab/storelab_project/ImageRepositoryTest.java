package com.storelab.storelab_project;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.storelab.storelab_project.model.Image;
import com.storelab.storelab_project.model.SharedViewModel;
import com.storelab.storelab_project.network.ApiInterface;
import com.storelab.storelab_project.repository.ImageRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Arrays;
import java.util.List;



public class ImageRepositoryTest {

    SharedViewModel sv;

    private ImageRepository imageRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        imageRepository=new ImageRepository();
        sv=new SharedViewModel(imageRepository);
       // api = mock(ApiInterface.class);
        //imageRepository = new ImageRepository();
    }

    @Test
    public void imageCreation() {
        Image image = new Image("1", "Alejandro Escamilla","https://picsum.photos/id/1/5000/3333",false);
        assertEquals("1", image.getId());
        assertEquals("https://picsum.photos/id/1/5000/3333", image.getDownload_url());
    }
    @Test
    public void testTogglefavInViewModel() {
        Image mockImage = new Image("1", "Alejandro Escamilla","https://picsum.photos/id/1/5000/3333",false);
        // Call the method under test
        sv.togglefav(mockImage);
        // Verify that the image's favorite state is toggled
        assertEquals(false, mockImage.isFavorite());
    }
}
