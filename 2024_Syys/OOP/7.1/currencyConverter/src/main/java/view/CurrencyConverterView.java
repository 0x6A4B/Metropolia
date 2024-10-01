package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class CurrencyConverterView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/converter.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setResizable(false);  // size is perfect, user must not wreak havoc
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }
}
