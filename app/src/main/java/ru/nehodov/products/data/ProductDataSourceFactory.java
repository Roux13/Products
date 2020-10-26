package ru.nehodov.products.data;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import javax.inject.Inject;

import ru.nehodov.products.entities.Product;

public class ProductDataSourceFactory extends DataSource.Factory<Integer, Product> {

    private ProductPositionalDataSource latestSource;

    @Inject
    public ProductDataSourceFactory(ProductPositionalDataSource latestSource) {
        this.latestSource = latestSource;
    }

    @NonNull
    @Override
    public DataSource<Integer, Product> create() {
        return latestSource;
    }
}
