package view;

import controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;


/*
    TODO:
    - [DONE] splashscreen
    - [DONE] R2 bucket / option to switch it off
    - [DONE] remove R2 object file(cloud savefile)
    - config file
    - [DONE] minimize R2 mutations by comparing modified date to local modified
    - [DONE] make sure to not save local file if nothing has changed or above just won't work
    - [DONE (partly)] clean file operations to their own class and filename to variable instead of hardcoding
    - using the cloud class as static so change to static methods instead of anonymous instantiation?
    - [DONE] watch season 2 of rings of power!!
    - damnit, last episode not released yet!!! watch the last episode too
    - [DONE] start with last edited note
    - [DONE] sort in order of last modified
    - [DONE?] saving of note state reliably without unnecessary updates to modified date
    - [DONE] procrastinate like you've never procrastinated before! Like your life depends on it!
    - [DONE] hashcode/UUID for user + system
    - [DONE] when new created focus the title? or focus text and make the first sentence the title?
    - [DONE] swap the hashmap to arraylist, not benefiting from hashmap. 'twas a silly idea anyways, young hobbit
    - [DONE?] refresh viewlist ALWAYS when updating modified date
    - [DONE] forget to do all the boring and unnecessary error handling, it's for peasants anyway


 */

public class NotetakerView extends Application {
    private Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
        // All jsut for splash ==>
        Pane pane = new Pane();
        pane.getChildren().add(new ImageView(new Image("splash.png")));
        Scene splash = new Scene(pane);
        stage.setScene(splash);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setTitle("Splash");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3)));
        timeline.getKeyFrames();
        timeline.setOnFinished(e -> {
            stage.close();  // <== all for splash. smart? oh yes :)
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
                Parent root = loader.load();
                controller = loader.getController();

                Stage mainStage = new Stage();
                mainStage.setScene(new Scene(root));
                mainStage.setTitle("NoteTaker3000Pro AI Crypto.com Web3.0!!!"); // and let the investor bro's money roll in
                // not gonna care about elements resizability, just live with the size... lazy is as lazy does
                stage.setResizable(false);
                mainStage.show();
            }catch (IOException ee){ System.err.println(ee.getMessage()); }
        });
        timeline.play(); // me <3 timeline and animationtimer, so simple
    }

    @Override
    public void stop(){
        System.out.println("Closing");
        controller.save();
    }
}
