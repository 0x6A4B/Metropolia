package model;

import java.util.ArrayList;
import model.Currency;

import java.util.Collection;
import java.util.HashMap;

public class CurrencyConverterModel{
    HashMap<String, Currency> exchangeRates;

    public CurrencyConverterModel(){
/*
        exchangeRates = new HashMap<>(){
            {
                put("EUR", new Currency("EUR", "Euro", 0.89));
                put("GBP", new Currency("GBP", "Pound Sterling", 0.75));
                put("JPY", new Currency("JPY", "Japanese Yen", 143.13));
                put("AUD", new Currency("AUD", "Australian Dollar", 1.45));
                put("CAD", new Currency("CAD", "Canadian Dollar", 1.34));
                put("CHF", new Currency("CHF", "Swiss Franc", 0.84));
                put("IRR", new Currency("IRR", "Iranian Rial", 0.0000237252));
            }
        };
*/

    }

    public double convert(String from, String to, double amount){
        try {
            checkCurrency(from);
            checkCurrency(to);
            return (int)(amount / exchangeRates.get(from).getRate() * exchangeRates.get(to).getRate()*100)/100.00;
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
        currencies.addAll(exchangeRates.keySet());
//        for (String s : exchangeRates.keySet())
//            currencies.add(s);
        return currencies;  // not handling empty hashmap right now
    }

    public boolean addCurrency(String abbr, String name, double value){
        if (exchangeRates.containsKey(abbr))
            return false;
        exchangeRates.put(abbr, new Currency(abbr, name, value));
        return true;
    }

    public boolean modifyCurrency(String currency, String name, double value){
        if (!exchangeRates.containsKey(currency))
            return false;
        exchangeRates.replace(currency, new Currency(currency, name, value));
        return true;
    }
    public boolean modifyCurrency(String currency, double value){
        if (!exchangeRates.containsKey(currency))
            return false;
        return modifyCurrency(currency, exchangeRates.get(currency).getName(), value);
    }

    public boolean removeCurrency(String currency){
        if (!exchangeRates.containsKey(currency))
            return false;
        exchangeRates.remove(currency);
        return true;
    }
}
