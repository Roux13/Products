package ru.nehodov.products.ui;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import ru.nehodov.products.entities.Product;

public class ProductDiffUtilCallback extends DiffUtil.ItemCallback<Product> {
    @Override
    public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
        return oldItem.getTitle().equals(newItem.getTitle())
                && oldItem.getTitle().equals(newItem.getTitle())
                && oldItem.getCategories().get(0).getTitle()
                .equals(newItem.getCategories().get(0).getTitle())
                && oldItem.getProducer().equals(newItem.getProducer())
                && oldItem.getPrice() == newItem.getPrice();
    }
}
