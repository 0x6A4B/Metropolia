package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.CurrencyConverterModel;
import entity.Currency;
import view.CurrencyConverterView;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.UnaryOperator;

public class CurrencyConverterController {
    CurrencyConverterModel model;
    CurrencyConverterView view;

    public CurrencyConverterController(){ model = new CurrencyConverterModel(this); }
    public void setView(CurrencyConverterView view){ this.view = view; model.initRates(); initialize();}

    public void addCurrency(String abbr, String name, double rate){ model.addCurrency(abbr, name, rate); initialize(); }
    public void removeCurrency(String abbr){ model.removeCurrency(abbr); initialize(); }
    public double convert(String from, String to, double value){ return model.convert(from, to, value); }
    public void modifyCurrency(String abbr, String name, double rate){ model.modifyCurrency(abbr, name, rate); }
    public ArrayList<String> getCurrencies(){ return model.getCurrencies(); }

    public void occurranceOfAnError(String s, Exception e){
        System.err.println("Awful örrör has occurred and I'm not playing with you anymore mr. user");
        view.errorPopup(s + "\n\n\n" + e.getMessage());
    }

    private void initialize(){
        currencyTo.setItems(FXCollections.observableArrayList(getCurrencies()));
        currencyFrom.setItems(FXCollections.observableArrayList(getCurrencies()));
    }

    public void refresh(){
        currencyTo.getSelectionModel().select("USD");
        currencyFrom.getSelectionModel().select("USD");
    }

    @FXML
    private Button convertButton;

    @FXML
    private ChoiceBox<String> currencyFrom;

    @FXML
    private ChoiceBox<String> currencyTo;

    @FXML
    private TextField currencyValue;

    @FXML
    private TextArea results;

    @FXML
    private void convertCurrency(){
        if (currencyFrom.getValue() == null || currencyTo.getValue() == null || currencyValue.getText().equals(""))
            return;
        double result = convert(currencyFrom.getValue().toString()
                , currencyTo.getValue().toString(), Double.parseDouble(currencyValue.getText()));
        results.setText(results.getText()
                + currencyFrom.getValue().toString() + " => "
                + currencyTo.getValue().toString() + " == " + result + "\n");
        results.setScrollTop(Double.MAX_VALUE);

    }

    @FXML
    private void valueChanged(){
        UnaryOperator<TextFormatter.Change> numberValidator = change ->{
            if (change.getText().matches("\\d+|[.]{0,1}")) {
                if ((currencyValue.getText() + change.getText()).matches("\\d*[.]{0,1}\\d*"))
                    return change;
                else
                    return null;
            }
            return null;
        };
        currencyValue.setTextFormatter(new TextFormatter<String>(numberValidator));
    }

    @FXML
    private void addCurrencyPopup(){
        view.openSavePopup(false);
    }

    @FXML
    private void delCurrencyPopup(){
        if (currencyFrom.getValue() == null)
            return;
        Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION);
        deleteAlert.setContentText("Are you sure you want to delete currency " + currencyFrom.getValue() + "?");
        deleteAlert.setTitle("DELETING CURRENCY FROM DATABASE!");
        deleteAlert.setHeaderText("Confirm deletion of currency");
        Optional<ButtonType> decision = deleteAlert.showAndWait();
        if (decision.get().equals(ButtonType.OK))
            removeCurrency(currencyFrom.getValue());
    }

    @FXML
    private void modifyCurrencyPopup(){
        if (currencyFrom.getValue() == null)
            return;
        view.openSavePopup(true);
    }

    public Currency getUpdatedCurrency(){
        return model.getCurrency(currencyFrom.getValue());
    }

}
