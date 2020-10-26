package ru.nehodov.products.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Product {
    private int id;
    private String title;
    @SerializedName("short_description")
    private String shortDescription;
    @SerializedName("image_url")
    private String imageUrl;
    private int amount;
    private double price;
    private String producer;
    private List<Category> categories;

    public Product(int id, String title, String shortDescription, String imageUrl, int amount,
                   double price, String producer, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.imageUrl = imageUrl;
        this.amount = amount;
        this.price = price;
        this.producer = producer;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return id == product.id
                && amount == product.amount
                && Double.compare(product.price, price) == 0
                && Objects.equals(title, product.title)
                && Objects.equals(shortDescription, product.shortDescription)
                && Objects.equals(imageUrl, product.imageUrl)
                && Objects.equals(producer, product.producer)
                && Objects.equals(categories, product.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, shortDescription,
                imageUrl, amount, price, producer, categories);
    }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", short_description='" + shortDescription + '\''
                + ", image_url='" + imageUrl + '\''
                + ", amount=" + amount
                + ", price=" + price
                + ", producer='" + producer + '\''
                + ", categories=" + categories
                + '}';
    }
}
