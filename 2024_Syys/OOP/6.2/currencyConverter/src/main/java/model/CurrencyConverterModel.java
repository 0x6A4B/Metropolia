package model;

import java.util.ArrayList;
import java.util.HashMap;

public class CurrencyConverterModel{
    HashMap<String, Double> exchangeRates;

    public CurrencyConverterModel(){

        exchangeRates = new HashMap<>();
        // TEMP
        // give me a comma separated list with few biggest currencies and their rate to USD,
        // put the currency code in " doubleuotes
        // llama: "EUR" 0.84, "GBP" 0.77, "JPY" 114.55, "AUD" 1.47, "CAD" 1.33, "CHF" 0.98
        // wown't be up to date but no matter, it should be changed to use some APi off the web
        // lazy continues:
        // put those in to hashmap exchangeRates (exchangeRates.add("EUR", 0.84);
        // llama:
        exchangeRates.put("EUR", 0.89);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("JPY", 143.13);
        exchangeRates.put("AUD", 1.45);
        exchangeRates.put("CAD", 1.34);
        exchangeRates.put("CHF", 0.84);
        // thank you for making my life easier mr. SkyNet
        // scratch that, they were wrong, out of date and llama is not capable of calculating...
        // had to manually get current ones. Good try though...
        // future modification to pull from some currencyrate api
        exchangeRates.put("USD", 1.0);

    }

    public double convert(String from, String to, double amount){
        try {
            checkCurrency(from);
            checkCurrency(to);
            return (int)(amount / exchangeRates.get(from) * exchangeRates.get(to)*100)/100.00;
        }catch (CurrencyNotFoundException e){
            System.out.printf("Currency not found! \n%s\n", e.getMessage());
            return -1; //ERROR
        }
    }

    private void checkCurrency(String currency) throws CurrencyNotFoundException{
        if (!exchangeRates.containsKey(currency))
            throw new CurrencyNotFoundException();
    }

    public ArrayList<String> getCurrencies(){
        ArrayList<String> currencies = new ArrayList<>();
        for (String s : exchangeRates.keySet())
            currencies.add(s);
        return currencies;  // not handling empty hashmap right now
    }

    public boolean addCurrency(String currency, double value){
        if (exchangeRates.containsKey(currency))
            return false;
        exchangeRates.put(currency, value);
        return true;
    }

    public boolean modifyCurrency(String currency, double value){
        if (!exchangeRates.containsKey(currency))
            return false;
        exchangeRates.replace(currency, value);
        return true;
    }

    public boolean removeCurrency(String currency){
        if (!exchangeRates.containsKey(currency))
            return false;
        exchangeRates.remove(currency);
        return true;
    }
}
