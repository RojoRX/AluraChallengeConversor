package model;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRates {
    private Map<String, Double> exchangeRates;

    public ExchangeRates() {
        // Inicializar el mapa de tasas de cambio
        exchangeRates = new HashMap<>();
        // Agregar las tasas de cambio para diferentes monedas
        exchangeRates.put("BOB", 1.0);
        exchangeRates.put("USD", 6.92); // Tasa de cambio de 1 USD a BOB
        exchangeRates.put("EUR", 7.83); // Tasa de cambio de 1 EUR a BOB
        exchangeRates.put("GBP", 9.22); // Tasa de cambio de 1 GBP a BOB
        exchangeRates.put("JPY", 0.06); // Tasa de cambio de 1 JPY a BOB
        exchangeRates.put("KRW", 0.0007); // Tasa de cambio de 1 KRW a BOB
        // Puedes agregar más tasas de cambio aquí según tus necesidades
    }

    public double getExchangeRate(String currencyCode) {
        if (!exchangeRates.containsKey(currencyCode)) {
            throw new IllegalArgumentException("Moneda no soportada: " + currencyCode);
        }
        return exchangeRates.get(currencyCode);
    }

    // Puedes agregar otros métodos si necesitas modificar o acceder a las tasas de cambio

    // Método para agregar una nueva tasa de cambio
    public void addExchangeRate(String currencyCode, double rate) {
        exchangeRates.put(currencyCode, rate);
    }
}
