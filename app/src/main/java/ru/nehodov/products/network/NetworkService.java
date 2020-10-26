package ru.nehodov.products.network;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;
import ru.nehodov.products.entities.ApiResponse;
import ru.nehodov.products.entities.Product;

public class NetworkService {

    private static final String TAG = NetworkService.class.getSimpleName();

    private RSTestApi api;

    @Inject
    public NetworkService(RSTestApi api) {
        this.api = api;
    }

    public List<Product> getProductsByName(int startFrom, int maxItems) {
        Call<ApiResponse> call = api.getProductsByTitle("", startFrom, maxItems);
        try {
            Response<ApiResponse> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                return  response.body().getData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
