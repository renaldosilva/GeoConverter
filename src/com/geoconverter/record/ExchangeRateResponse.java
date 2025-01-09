package com.geoconverter.record;

public record ExchangeRateResponse(String result, String baseCode, String targetCode,double conversionRate,
                                   double conversionResult) {
}
