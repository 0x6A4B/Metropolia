package oop.task1.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import oop.task1.Controller.DictionaryController;

public class DictionaryView extends Application {
    private DictionaryController controller;

//    public DictionaryView(DictionaryController cntrlr){ this.controller = cntrlr; }

    private GridPane pane;
    private TextField word;
    private Button search;
    private Label translationLabel;
    private Label translation;
    private Label words;
    private Label amount;
    private Button addButton;

    @Override
    public void start(Stage stage) throws Exception {
        pane = new GridPane(20, 220);
        word = new TextField();
        search = new Button();
        translation = new Label();
        translationLabel = new Label();
        words = new Label();
        amount = new Label();
        addButton = new Button(("Add word"));

        search.setText("Search");
        word.setText("Saerch");
        translationLabel.setText("Translation: ");
        translation.setText("Search to get a translation");
        words.setText("Words in dictionary: ");
        amount.setText("");

        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (word.getText().equals(""))
                    translation.setText("NO WORD GIVEN!!");
                else
                    controller.search(word.getText());
            }
        });
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addWord();
            }
        });

        pane.setAlignment(Pos.TOP_LEFT);
        pane.setVgap(10);
        pane.setHgap(5);

        pane.add(word, 0, 0);
        pane.add(search, 1, 0);
        pane.add(translationLabel, 0, 1);
        pane.add(translation, 1, 1);
        pane.add(words, 0, 2);
        pane.add(amount, 1, 2);

        refresh();

        Scene scene = new Scene(pane);
        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    public void searchResult(String result){
        translation.setText(result);
    }
    public void sizeResult(int size){ amount.setText("" + size); }

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
