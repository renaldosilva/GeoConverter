package com.geoconverter.api;

import com.geoconverter.record.ExchangeRateResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApiClient {

    // Substitua o valor da chave pela sua chave real da API
    private static final String YOUR_API_KEY = "KEY";
    private static final String API_URL_CONVERSION = "https://v6.exchangerate-api.com/v6/" + YOUR_API_KEY + "/pair/";
    private final HttpClient client;
    private final Gson gson;

    public ExchangeRateApiClient() {
        this.client = HttpClient.newHttpClient();
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
    }

    public ExchangeRateResponse getExchangeRateDetails(String fromCurrency, String toCurrency, double amount)
            throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL_CONVERSION + fromCurrency + "/" + toCurrency + "/" + amount))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return this.gson.fromJson(response.body(), ExchangeRateResponse.class);
    }
}
