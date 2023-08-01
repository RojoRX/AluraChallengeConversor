package model;

public class CurrencyConverter {
    private ExchangeRates exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new ExchangeRates();
    }

    public double convertToCurrency(double amount, String toCurrency) {
        double rateTo = exchangeRates.getExchangeRate(toCurrency);
        return amount / rateTo;
    }

    public double convertFromCurrency(double amount, String fromCurrency) {
        double rateFrom = exchangeRates.getExchangeRate(fromCurrency);
        return amount * rateFrom;
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();

        double amountBOB = 1;
        String toCurrency = "USD";
        double convertedAmountTo = converter.convertToCurrency(amountBOB, toCurrency);

        System.out.println(amountBOB + " BOB es igual a " + convertedAmountTo + " " + toCurrency);

        double amountUSD = 1;
        String fromCurrency = "USD";
        double convertedAmountFrom = converter.convertFromCurrency(amountUSD, fromCurrency);

        System.out.println(amountUSD + " " + fromCurrency + " es igual a " + convertedAmountFrom + " BOB");
    }
}

