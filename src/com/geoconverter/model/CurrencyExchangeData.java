package com.geoconverter.model;

import com.geoconverter.record.ExchangeRateResponse;

public class CurrencyExchangeData {

    private final String baseCode;
    private final String targetCode;
    private final double conversionRate;
    private final double conversionResult;
    private final double amount;

    public CurrencyExchangeData(ExchangeRateResponse exchangeRateResponse, double amount) {
        this.baseCode = exchangeRateResponse.baseCode();
        this.targetCode = exchangeRateResponse.targetCode();
        this.conversionRate = exchangeRateResponse.conversionRate();
        this.conversionResult = exchangeRateResponse.conversionResult();
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Valor %.2f [%s] corresponde ao valor final de =>>> %.2f [%s]"
                .formatted(this.amount, this.baseCode, this.conversionResult, this.targetCode) ;
    }
}
