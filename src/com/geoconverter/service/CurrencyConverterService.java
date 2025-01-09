package com.geoconverter.service;

import com.geoconverter.api.ExchangeRateApiClient;
import com.geoconverter.exception.CurrencyConversionException;
import com.geoconverter.model.CurrencyExchangeData;
import com.geoconverter.record.ExchangeRateResponse;

import java.io.IOException;

public class CurrencyConverterService {

    ExchangeRateApiClient apiClient;

    public CurrencyConverterService() {
        this.apiClient = new ExchangeRateApiClient();

    }

    public CurrencyExchangeData convert(String fromCurrency, String toCurrency, double amount) {
        validateInputs(fromCurrency, toCurrency, amount);

        try {
            ExchangeRateResponse exchangeRateResponse = this.apiClient.getExchangeRateDetails(fromCurrency, toCurrency, amount);

            if (exchangeRateResponse.result().equalsIgnoreCase("error")) {
                throw new CurrencyConversionException("Failed to retrieve exchange rate data");
            }

            return new CurrencyExchangeData(exchangeRateResponse, amount);
        } catch (IOException | InterruptedException e) {
            throw new CurrencyConversionException("Error while fetching exchange rate data", e);
        }
    }

    private void validateInputs(String fromCurrency, String toCurrency, double amount) {
        validateExistenceOfCurrencyCode(fromCurrency);
        validateExistenceOfCurrencyCode(toCurrency);
        validateAmount(amount);
    }

    private void validateExistenceOfCurrencyCode(String currency) {
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("Currency codes cannot be null or empty");
        }
    }

    private void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}
