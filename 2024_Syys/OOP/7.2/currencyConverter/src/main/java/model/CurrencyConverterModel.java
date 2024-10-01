package model;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.CurrencyConverterController;
import dao.CurrencyDao;
import java.util.HashMap;
import java.util.List;

public class CurrencyConverterModel{
    private HashMap<String, Currency> exchangeRates;
    private CurrencyConverterController controller;

    public CurrencyConverterModel(CurrencyConverterController ctrl){
        controller = ctrl;
    }
    public CurrencyConverterModel(){}

    public void initRates(){
        exchangeRates = new HashMap<>(); //.putAll(new CurrencyDao().getAllCurrencies());
        List<Currency> list = new ArrayList<Currency>();
        try {
            list = new CurrencyDao().getAllCurrencies();
        }catch (SQLException e) {
            System.out.println("öörrrör");
            controller.occurranceOfAnError("SQL connection error!", e);
        }
        list.forEach((c) -> { exchangeRates.put(c.getAbbreviation(), c); });
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
