package ru.nehodov.products.viewmodels;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.nehodov.products.data.ProductDataSourceFactory;
import ru.nehodov.products.data.ProductPositionalDataSource;
import ru.nehodov.products.entities.Category;
import ru.nehodov.products.entities.Product;
import ru.nehodov.products.data.ProductsRepository;

public class ProductListViewModel extends ViewModel {

    private final ProductsRepository repository;
    private final SavedStateHandle savedStateHandle;

    private LiveData<PagedList<Product>> products;

    @ViewModelInject
    public ProductListViewModel(ProductsRepository repository,
                                ProductDataSourceFactory dataSourceFactory,
                                PagedList.Config config,
                                @Assisted SavedStateHandle savedStateHandle) {
        this.repository = repository;
        this.savedStateHandle = savedStateHandle;
        products = new LivePagedListBuilder<>(dataSourceFactory, config)
                .build();
    }

    public LiveData<PagedList<Product>> getProductsLiveData() {
        return products;
    }
}
