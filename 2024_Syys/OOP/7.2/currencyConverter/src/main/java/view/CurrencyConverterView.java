package view;

import controller.CurrencyConverterController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.Parent;


public class CurrencyConverterView extends Application {
    private CurrencyConverterController controller;

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
}
