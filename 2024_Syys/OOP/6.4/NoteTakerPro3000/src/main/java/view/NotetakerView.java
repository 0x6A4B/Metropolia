package view;

import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NotetakerView extends Application {
    private Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
/*
        notes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Note>() {
            @Override
            public void changed(ObservableValue<? extends Note> observableValue, Note note, Note t1) {

            }

        });*/

        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void stop(){
        System.out.println("Closing");
        //SAVE
        controller.save();
    }
}
