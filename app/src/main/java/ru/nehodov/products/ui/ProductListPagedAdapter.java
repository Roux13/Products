package ru.nehodov.products.ui;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import ru.nehodov.products.R;
import ru.nehodov.products.entities.Product;

public class ProductListPagedAdapter extends PagedListAdapter<Product, RecyclerView.ViewHolder> {

    protected ProductListPagedAdapter(@NonNull DiffUtil.ItemCallback<Product> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new RecyclerView.ViewHolder(view) { };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Product product = getItem(position);
        ImageView image = holder.itemView.findViewById(R.id.item_image);
        TextView category = holder.itemView.findViewById(R.id.category);
        TextView productName = holder.itemView.findViewById(R.id.productName);
        TextView producer = holder.itemView.findViewById(R.id.producer);
        TextView price = holder.itemView.findViewById(R.id.price);
        Picasso.get().load(product.getImageUrl()).into(image);
        if (!product.getCategories().isEmpty()) {
            category.setText(TextUtils.isEmpty(
                    product.getCategories().get(0).getTitle()) ? ""
                    : product.getCategories().get(0).getTitle());
        }
        productName.setText(TextUtils.isEmpty(product.getTitle()) ? "" : product.getTitle());
        producer.setText(TextUtils.isEmpty(product.getProducer()) ? "" : product.getProducer());
        price.setText(String.valueOf(product.getPrice()));
    }
}


