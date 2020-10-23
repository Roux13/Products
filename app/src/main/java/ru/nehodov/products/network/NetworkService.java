package ru.nehodov.products.network;

import javax.inject.Inject;

public class NetworkService {

    private RSTestApi api;

    @Inject
    public NetworkService(RSTestApi api) {
        this.api = api;
    }

    public RSTestApi getApi() {
        return api;
    }
}
