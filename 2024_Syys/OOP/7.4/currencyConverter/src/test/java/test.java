import dao.CurrencyDao;
import dao.TransactionDao;
import entity.Currency;

public class test {
    public static  void main(String[] args){
        CurrencyDao cd = new CurrencyDao();
        TransactionDao td = new TransactionDao();

        Currency c1 = new Currency("USD", "usd", 1);
        Currency c2 = new Currency("EUR", "eru", 0.85);

        cd.persist(c1);
        cd.persist(c2);



    }
}
