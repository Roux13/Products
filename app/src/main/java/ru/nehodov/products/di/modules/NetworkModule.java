package ru.nehodov.products.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.nehodov.products.BuildConfig;
import ru.nehodov.products.ProductsApp;
import ru.nehodov.products.network.NetworkContract;
import ru.nehodov.products.network.NetworkService;
import ru.nehodov.products.network.RSTestApi;

@InstallIn(ApplicationComponent.class)
@Module
public class NetworkModule {

    @Singleton
    @Provides
    HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(
                BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                        : HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Singleton
    @Provides
    OkHttpClient provideHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

//    @Singleton
//    @Provides
//    Retrofit provideRetrofit(GsonConverterFactory converterFactory) {
//        return new Retrofit.Builder()
//                .baseUrl(NetworkContract.BASE_URL)
//                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }

    @Singleton
    @Provides
    Retrofit provideRetrofitWithLogging(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(NetworkContract.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    RSTestApi provideRSTestApi(Retrofit retrofit) {
        return retrofit.create(RSTestApi.class);
    }
}
