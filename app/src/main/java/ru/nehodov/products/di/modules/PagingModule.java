package ru.nehodov.products.di.modules;

import androidx.paging.PagedList;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@InstallIn(ApplicationComponent.class)
@Module
public class PagingModule {

    @Provides
    PagedList.Config providePagedListConfig() {
        return new PagedList.Config.Builder()
                .setPageSize(4)
                .setPrefetchDistance(12)
                .setEnablePlaceholders(false)
                .build();
    }

}
