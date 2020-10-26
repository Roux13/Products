package ru.nehodov.products.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.hilt.android.AndroidEntryPoint;
import ru.nehodov.products.viewmodels.ProductListViewModel;
import ru.nehodov.products.R;

@AndroidEntryPoint
public class ProductListFragment extends Fragment {

    private ProductListViewModel viewModel;

    public static ProductListFragment newInstance() {
        ProductListFragment fragment = new ProductListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ProductListViewModel.class);
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        RecyclerView recycler = view.findViewById(R.id.products_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(requireActivity()));
        ProductListPagedAdapter adapter = new ProductListPagedAdapter(new ProductDiffUtilCallback());
        recycler.setAdapter(adapter);
        viewModel.getProductsLiveData().observe(
                getViewLifecycleOwner(),
                adapter::submitList);
        return view;
    }
}