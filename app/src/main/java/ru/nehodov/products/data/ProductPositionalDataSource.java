package ru.nehodov.products.data;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import java.util.List;

import javax.inject.Inject;

import ru.nehodov.products.entities.Product;
import ru.nehodov.products.network.NetworkService;

public class ProductPositionalDataSource extends PositionalDataSource<Product> {

    private final NetworkService networkService;

    @Inject
    public ProductPositionalDataSource(NetworkService networkService) {
        this.networkService = networkService;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params,
                            @NonNull LoadInitialCallback<Product> callback) {
        List<Product> products = networkService.getProductsByName(
                params.requestedStartPosition,
                params.requestedLoadSize
        );
        callback.onResult(products, 0);

    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params,
                          @NonNull LoadRangeCallback<Product> callback) {
        List<Product> products = networkService.getProductsByName(
                params.startPosition,
                params.loadSize
        );
        callback.onResult(products);
    }
}
