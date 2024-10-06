package model;

import java.util.ArrayList;
import controller.CurrencyConverterController;
import dao.CurrencyDao;
import entity.Currency;
import org.hibernate.service.spi.ServiceException;
import java.util.HashMap;
import java.util.List;

public class CurrencyConverterModel{
    private HashMap<String, Currency> exchangeRates;
    private CurrencyConverterController controller;
    private CurrencyDao currencyDao;

    public CurrencyConverterModel(CurrencyConverterController ctrl){
        controller = ctrl;
        currencyDao = new CurrencyDao();
    }
    public CurrencyConverterModel(){}

    public void initRates(){
        List<Currency> list = new ArrayList<>();
        exchangeRates = new HashMap<>();
        try {
            list = currencyDao.getAllCurrencies();
        }catch (ServiceException e) {
            System.out.println("Informative console message for developer follows: \"öörrrör\"" +
                            "\nEnd of informative console message for developer, you are welcome!");
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
            controller.occurranceOfAnError("Currency not found!", e);
            return -1; //ERROR
        }
    }

    private void checkCurrency(String currency) throws CurrencyNotFoundException{
        if (!exchangeRates.containsKey(currency))
            throw new CurrencyNotFoundException();
    }

    public ArrayList<String> getCurrencies(){
        return new ArrayList<>(){ { addAll(exchangeRates.keySet()); } };
    }

    public boolean addCurrency(String abbr, String name, double value){
        if (exchangeRates.containsKey(abbr))
            return false;
        exchangeRates.put(abbr, new Currency(abbr, name, value));
        currencyDao.persist(new Currency(abbr, name, value));
        return true;
    }

    public boolean modifyCurrency(String currency, String name, double value){
        if (!exchangeRates.containsKey(currency))
            return false;
        exchangeRates.replace(currency, new Currency(currency, name, value));
        currencyDao.update(new Currency(currency, name, value));
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
        currencyDao.delete(currencyDao.find(currency));
        return true;
    }

    public Currency getCurrency(String abbr){
        return currencyDao.find(abbr);
    }
}
