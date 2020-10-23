package ru.nehodov.products.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.nehodov.products.ProductsApp;
import ru.nehodov.products.network.NetworkContract;
import ru.nehodov.products.network.NetworkService;
import ru.nehodov.products.network.RSTestApi;

@InstallIn(ApplicationComponent.class)
@Module
public class NetworkModule {

    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(GsonConverterFactory converterFactory) {
        return new Retrofit.Builder()
                .baseUrl(NetworkContract.BASE_URL)
                .addConverterFactory(converterFactory)
                .build();
    }

    @Singleton
    @Provides
    RSTestApi provideRSTestApi(Retrofit retrofit) {
        return retrofit.create(RSTestApi.class);
    }
}
