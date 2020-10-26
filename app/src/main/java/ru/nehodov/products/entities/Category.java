package ru.nehodov.products.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Category {
    private int id;
    private String title;
    @SerializedName("parent_id")
    private int parentId;

    public Category(int id, String title, int parentId) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Category category = (Category) o;
        return id == category.id
                && parentId == category.parentId
                && Objects.equals(title, category.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, parentId);
    }

    @Override
    public String toString() {
        return "Category{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", parent_id=" + parentId
                + '}';
    }
}
