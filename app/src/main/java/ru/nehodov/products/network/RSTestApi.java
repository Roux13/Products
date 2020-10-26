package ru.nehodov.products.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.nehodov.products.entities.Product;
import ru.nehodov.products.entities.ApiResponse;

public interface RSTestApi {

    @GET("api/v1/products")
    Call<ApiResponse> getProductsByTitle(@Query("filter[]") String title,
                                              @Query("startFrom") int startFrom,
                                              @Query("maxItems") int maxItems);

    @GET("api/v1/product/{id}")
    Call<Product> getProduct(@Path("id") int id);
}
