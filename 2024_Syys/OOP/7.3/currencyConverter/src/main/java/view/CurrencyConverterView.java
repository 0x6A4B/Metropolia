package view;

import controller.AddCurrencyController;
import controller.CurrencyConverterController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;


public class CurrencyConverterView extends Application {
    private CurrencyConverterController controller;
    private Stage addCurrencyStage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/converter.fxml"));

        Parent root = loader.load();
        controller = loader.getController();
        controller.setView(this);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setResizable(false);  // size is perfect, user must not wreak havoc
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

    public void errorPopup(String s){
        Alert error = new Alert(Alert.AlertType.ERROR, "Error has occurred!!\n" + s
                + "\n\nShutting down!", ButtonType.OK);
        error.showAndWait().ifPresent(btn -> Platform.exit());
    }

    public void openSavePopup(Boolean update) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/addCurrency.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            AddCurrencyController ctrl = loader.getController();
            ctrl.setView(this);
            ctrl.setController(controller);
            if (update)
                ctrl.updateMode();
            addCurrencyStage = new Stage();
            addCurrencyStage.setResizable(false);
            addCurrencyStage.setTitle("Add new currency");
            addCurrencyStage.setScene(scene);
            addCurrencyStage.show();
        } catch (IOException e) {
            System.err.println("Couldn't load addCurrency.fxml");
        }
    }

    // easiest way? it's just a popup for adding currency and I just want it dead
    public void closeSavePopup(){
        addCurrencyStage.close();
        controller.refresh();
    }

}
