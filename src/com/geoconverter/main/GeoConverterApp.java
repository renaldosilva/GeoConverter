package com.geoconverter.main;

import com.geoconverter.service.CurrencyConverterService;

import java.util.*;

public class GeoConverterApp {

    public static void main(String[] args){
        Map<Integer, List<String>> supportedCurrencyConversions = new HashMap<>();
        supportedCurrencyConversions.put(1, new ArrayList<>(Arrays.asList("BRL", "USD")));
        supportedCurrencyConversions.put(2, new ArrayList<>(Arrays.asList("USD", "BRL")));
        supportedCurrencyConversions.put(3, new ArrayList<>(Arrays.asList("BOB", "ARS")));
        supportedCurrencyConversions.put(4, new ArrayList<>(Arrays.asList("ARS", "BOB")));
        supportedCurrencyConversions.put(5, new ArrayList<>(Arrays.asList("CLP", "COP")));
        supportedCurrencyConversions.put(6, new ArrayList<>(Arrays.asList("COP", "CLP")));

        Scanner scanner = new Scanner(System.in);
        CurrencyConverterService converterService = new CurrencyConverterService();

        boolean continueConverting = true;
        while (continueConverting) {
            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            if (supportedCurrencyConversions.containsKey(option)) {
                System.out.println("Digite o valor que deseja converter:");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                List<String> currencyConversion = supportedCurrencyConversions.get(option);
                String fromCurrency = currencyConversion.getFirst();
                String toCurrency = currencyConversion.getLast();
                System.out.println(converterService.convert(fromCurrency, toCurrency, amount));
            } else if (option == 7) {
                continueConverting = false;
            } else {
                System.out.println("Por favor, insira uma opção válida!");
            }
        }
    }

    public static void printMenu() {
        System.out.println("""
                *******************************************************
                Seja bem-vindo(a) ao GeoConverter
                
                1) Real brasileiro >> Dólar
                2) Dólar >> Real brasileiro
                3) Boliviano >> Peso argentino
                4) Peso argentino >> Boliviano
                5) Peso chileno >> Peso colombiano
                6) Peso colombiano >> Peso chileno
                7) Sair
                Escolha uma opção válida:
                *******************************************************
                """);
    }
}
