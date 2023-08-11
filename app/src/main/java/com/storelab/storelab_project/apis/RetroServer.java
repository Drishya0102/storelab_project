package com.storelab.storelab_project.apis;

import static com.storelab.storelab_project.utils.AppConstant.BASE_URL;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {

    private static Retrofit retrofit = null;

    public static ApiRequestData getRetrofitServer() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiRequestData.class);

    }

}
