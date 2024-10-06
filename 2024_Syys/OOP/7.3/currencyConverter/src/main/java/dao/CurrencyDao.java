package dao;

import entity.Currency;
import datasource.MariaDbJpaConnection;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyDao {

    public void persist(Currency currency){
        EntityManager eManager = MariaDbJpaConnection.getInstance();
        eManager.getTransaction().begin();
        eManager.persist(currency);
        eManager.getTransaction().commit();
    }

    public Currency find(String abbr){
        EntityManager eManager = MariaDbJpaConnection.getInstance();
        return eManager.find(Currency.class, abbr);
    }

    public void update(Currency currency){
        EntityManager eManager = MariaDbJpaConnection.getInstance();
        eManager.getTransaction().begin();
        eManager.merge(currency);
        eManager.getTransaction().commit();
    }

    public void delete(Currency currency){
        EntityManager eManager = MariaDbJpaConnection.getInstance();
        eManager.getTransaction().begin();
        eManager.remove(currency);
        eManager.getTransaction().commit();
    }

    public List<Currency> getAllCurrencies(){
        EntityManager eManager = MariaDbJpaConnection.getInstance();
        // weirdly the query isn't formatted as per DB but as per Currency class..
        // also can't get automatically instantiated Currency object as it returns list of Objects
        // and can't be cast to a list of other classes e.g. List<Currency>
        // but must be iterated through and each object cast to Currency and added to a list of currency objects
        // would have been to easy, I guess
        // so returning an Object array and mapping it to a currency object and collecting those
        // to an arraylist collection
        // java is wild sometimes but it's reasonably pretty and self commenting enough
        return eManager.createQuery("SELECT abbreviation, name, rate FROM Currency", Object[].class)
                .getResultList().stream()
                .map(arr -> new Currency((String) arr[0], (String) arr[1], (Double) arr[2]))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
