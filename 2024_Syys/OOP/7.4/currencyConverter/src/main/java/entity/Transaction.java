package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import entity.Currency;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Currency fromCurrency;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Currency toCurrency;
    private LocalDateTime date;
    private double amount;

    public Transaction(){}
    public Transaction(Currency fromCurrency, Currency toCurrency, double amount, LocalDateTime date){
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.date = date;
    }

    public void stamp(){ date = LocalDateTime.now(); }
    public void setAmount(double amount) { this.amount = amount; }
    public void setFromCurrency(Currency fromCurrency) { this.fromCurrency = fromCurrency; }
    public void setToCurrency(Currency toCurrency) { this.toCurrency = toCurrency; }

    //    public int getId() { return id; }
//    public Currency getFromCurrency() { return fromCurrency; }
}
