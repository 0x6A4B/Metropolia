package dao;

import datasource.MariaDbJpaConnection;
import entity.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDao {

    public void persist(Transaction transaction){
        EntityManager eManager = MariaDbJpaConnection.getInstance();
        eManager.getTransaction().begin();
        eManager.persist(transaction);
        eManager.getTransaction().commit();
    }
}
