package entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table //(name="currency")
public class Currency implements Serializable{

    @Id
    //@Column(name="abbr")
    private String abbreviation;
    private String name;
    private double rate;  // rate USD / this currency

    public Currency(){}
    public Currency(String abbr, String name, double rate){
        abbreviation = abbr;
        this.name = name;
        this.rate = rate;
    }

    public String getAbbreviation(){ return abbreviation; }
    public String getName(){ return name; }
    public double getRate(){ return rate; }
    public void setRate(double rate){ this.rate = rate; }
}