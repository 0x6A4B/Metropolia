package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import view.CurrencyConverterView;

import entity.Currency;
import java.util.function.UnaryOperator;

public class AddCurrencyController {
    CurrencyConverterView view;
    CurrencyConverterController controller;
    boolean updateMode = false;

    public void setView(CurrencyConverterView view){ this.view = view;}
    public void setController(CurrencyConverterController controller){ this.controller = controller; }

    @FXML private TextField rateValue;
    @FXML private TextField abbrText;
    @FXML private TextField nameText;
    @FXML private Label infoLabel;

    @FXML
    private void valueChanged(){
        UnaryOperator<TextFormatter.Change> numberValidator = change ->{
            if (change.getText().matches("\\d+|[.]{0,1}")) {
                if ((rateValue.getText() + change.getText()).matches("\\d*[.]{0,1}\\d*"))
                    return change;
                else
                    return null;
            }
            return null;
        };
        rateValue.setTextFormatter(new TextFormatter<String>(numberValidator));
    }

    @FXML
    private void saveCurrency(){
        System.out.println("save button clicked");

        if (checkFields()) {
            if (updateMode) {
                controller.modifyCurrency(abbrText.getText(), nameText.getText(), Double.parseDouble(rateValue.getText()));
                updateMode = false;
            }
            else
                controller.addCurrency(abbrText.getText(), nameText.getText(), Double.parseDouble(rateValue.getText()));
            view.closeSavePopup();
        }
    }

    @FXML
    private void cancel(){
        System.out.println("cancel clicked");
        view.closeSavePopup();
    }

    private boolean checkFields(){
        if (abbrText.getText().length() != 3 | !abbrText.getText().matches("^[A-Z]{3}")) {
            infoLabel.setText("Abbreviation must be 3 UPPERCASE characters, e.g. USD");
            return false;
        }
        if (nameText.getText().equals("")){
            infoLabel.setText("Must have a name");
            return false;
        }
        if (rateValue.getText().equals("")){
            infoLabel.setText("Must have exchange rate");
            return false;
        }
        return true;
    }

    public void updateMode(){
        updateMode = true;
        Currency currency = controller.getUpdatedCurrency();
        abbrText.setText(currency.getAbbreviation());
        abbrText.setEditable(false);
        nameText.setText(currency.getName());
        rateValue.setText(((Double)currency.getRate()).toString());
    }
}
