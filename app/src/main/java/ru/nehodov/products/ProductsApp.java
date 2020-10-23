package ru.nehodov.products;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public final class ProductsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
