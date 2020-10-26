package ru.nehodov.products.data;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.nehodov.products.entities.Category;
import ru.nehodov.products.entities.Product;
import ru.nehodov.products.network.NetworkService;

public class ProductsRepository {

    private final NetworkService networkService;
    private final MutableLiveData<List<Category>> categoriesData =
            new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<Product>> products =
            new MutableLiveData<>(new ArrayList<Product>());

    @Inject
    public ProductsRepository(NetworkService networkService) {
        this.networkService = networkService;
    }

}
