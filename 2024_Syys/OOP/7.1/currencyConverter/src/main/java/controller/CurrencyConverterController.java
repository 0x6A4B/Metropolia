package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.CurrencyConverterModel;
import view.CurrencyConverterView;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class CurrencyConverterController {
    CurrencyConverterModel model;
    CurrencyConverterView view;

    public CurrencyConverterController(){
        model = new CurrencyConverterModel();
    }


    public void addCurrency(){
        model.addCurrency("", "", 1.0);
    }

    public void removeCurrency(){
        model.removeCurrency("");
    }

    public double convert(String from, String to, double value){
        return model.convert(from, to, value);
    }

    public void modifyCurrency(){
        model.modifyCurrency("", 1.0);
    }

    public ArrayList<String> getCurrencies(){ return model.getCurrencies(); }

    @FXML
    private void initialize(){
        currencyTo.setItems(FXCollections.observableArrayList(getCurrencies()));
        currencyFrom.setItems(FXCollections.observableArrayList(getCurrencies()));
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
        double result = convert(currencyFrom.getValue().toString()
                , currencyTo.getValue().toString(), Double.parseDouble(currencyValue.getText()));
        results.setText(results.getText()
                + currencyFrom.getValue().toString() + " => "
                + currencyTo.getValue().toString() + " == " + result + "\n");
    }

    @FXML
    private void valueChanged(){
        UnaryOperator<TextFormatter.Change> numberValidator = change ->{
            if (change.getText().matches("\\d+|[.]{0,1}")) {
                if ((currencyValue.getText() + change.getText()).matches("\\d+[.]{0,1}\\d*"))
                    return change;
                else
                    return null;
            }
            return null;
        };
        currencyValue.setTextFormatter(new TextFormatter<String>(numberValidator));
    }

    /*
    @FXML
    private void currencyBoxClicked(){
        currencyTo.setItems(FXCollections.observableArrayList(getCurrencies()));
        currencyFrom.setItems(FXCollections.observableArrayList(getCurrencies()));
        System.out.println(
        currencyFrom.getItems().size()
        );
    };
     */
}
