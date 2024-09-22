package oop.task1.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import oop.task1.Controller.DictionaryController;

public class DictionaryView extends Application {
    private DictionaryController controller;

//    public DictionaryView(DictionaryController cntrlr){ this.controller = cntrlr; }

    private FlowPane flowPane;
    private TextField word;
    private Button search;
    private Label translation;
    private Label words;
    private Button addButton;

    @Override
    public void start(Stage stage) throws Exception {
        flowPane = new FlowPane();
        word = new TextField();
        search = new Button();
        translation = new Label();
        words = new Label();
        addButton = new Button(("Add word"));

        search.setText("Search");
        word.setText("Saerch");
        translation.setText("Translation: ");
        words.setText("Words in dictionary: ");

        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.search(word.getText());
            }
        });
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addWord();
            }
        });

        flowPane.getChildren().add(word);
        flowPane.getChildren().add(search);
        flowPane.getChildren().add(translation);
        flowPane.getChildren().add(words);

        refresh();

        Scene scene = new Scene(flowPane);
        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public void searchResult(String result){
        translation.setText(result);
    }
    public void sizeResult(int size){ words.setText("" + size); }

    public void refresh(){
        controller.getSize();
    }

    private void addWord(){

    }

    @Override
    public void init(){
        this.controller = new DictionaryController(this);
    }
}
