package ru.nehodov.products.entities;

import java.util.List;
import java.util.Objects;

public class Product {
    private int id;
    private String title;
    private String short_description;
    private String image_url;
    private int amount;
    private double price;
    private String producer;
    private List<Category> categories;

    public Product(int id, String title, String short_description, String image_url, int amount,
                   double price, String producer, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.short_description = short_description;
        this.image_url = image_url;
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

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                amount == product.amount &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(title, product.title) &&
                Objects.equals(short_description, product.short_description) &&
                Objects.equals(image_url, product.image_url) &&
                Objects.equals(producer, product.producer) &&
                Objects.equals(categories, product.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, short_description, image_url, amount, price, producer, categories);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", short_description='" + short_description + '\'' +
                ", image_url='" + image_url + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", producer='" + producer + '\'' +
                ", categories=" + categories +
                '}';
    }
}
