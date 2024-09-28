package view;

import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/*
    TODO:
    - splashscreen
    - [DONE] R2 bucket / option to switch it off
    - config file
    - [DONE] start with last edited note
    - [DONE] sort in order of last modified
    - [DONE?] saving of note state reliably without unnecessary updates to modified date
    - [DONE] hashcode/UUID for user + system
    - [DONE] when new created focus the title? or focus text and make the first sentence the title?
    - [DONE] swap the hashmap to arraylist, not benefiting from hashmap. 'twas a silly idea anyways, young hobbit
    - [DONE?] refresh viewlist ALWAYS when updating modified date


 */
public class NotetakerView extends Application {
    private Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

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
