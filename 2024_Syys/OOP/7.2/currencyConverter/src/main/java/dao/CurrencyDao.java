package dao;

import datasource.MariaDbConnection;
import model.Currency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {

    public List<Currency> getAllCurrencies() throws SQLException{
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT abbr, name, rate FROM currencies";
        List<Currency> currencies = new ArrayList<>();

        if (conn == null)
            throw new SQLException("No connection!");

        try{
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
                currencies.add(new Currency(
                        rs.getString("abbr"),
                        rs.getString("name"),
                        rs.getDouble("rate")
                ));
        }catch (SQLException e){ /*e.printStackTrace();*/ }
        return currencies;
    }

    public Currency getCurrency(String abbr){
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT abbr, name, rate FROM currencies WHERE abbr=?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, abbr);

            ResultSet rs = ps.executeQuery();

            // we are expecting only one as abbr is unique
            // should we expect trouble?
            //rs.next();
            rs.last();
            if (rs.getRow() != 1){
                System.err.println("Something went wrong fetching currency: " + abbr);
                return null;
            }

            return new Currency(rs.getString("abbr")
                    , rs.getString("name"), rs.getDouble("rate"));
        }catch (SQLException e){ e.printStackTrace(); }
        return null;
    }

    public void persist(Currency currency){
        Connection conn = MariaDbConnection.getConnection();
        String sql = "INSERT INTO currencies (abbr, name, rate) VALUES (?, ?, ?)";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, currency.getAbbreviation());
            ps.setString(2, currency.getName());
            ps.setDouble(3, currency.getRate());

            ps.executeUpdate();
        }catch (SQLException e){ e.printStackTrace(); }
    }
}
