package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.Note;
import model.Notebook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Controller {

    private Notebook notebook;
    private Note currentNote;
    private boolean updated = false;

    @FXML
    public void initialize(){

        // TODO: better way to handle listview
        //ObservableList<String> o = FXCollections.observableArrayList();
        //o.add("X");
        //notes.setItems(o);

        title.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                System.out.println("focus lost");
                currentNote.setTitle(title.getText());
                noteChanged();
            }
        });

        text.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV){
                System.out.println("Fopcus lsot on textarea");
                currentNote.setText(text.getText());
                noteChanged();
            }
        });

        refreshList();

    }

    public Controller() {
        load();

        // dev/demo mode
        if (notebook == null) {
            notebook = new Notebook();
            notebook.add(new Note());
            notebook.add(new Note());
        }


    }

    @FXML
    private TextArea details;

    @FXML
    private ListView<Note> notes;

    @FXML
    private Button removeButton;

    @FXML
    private TextField title;

    @FXML
    private TextArea text;

    @FXML
    void notesClicked(MouseEvent event) {
        if (notes.getSelectionModel().getSelectedItem() == null)
            return;
        currentNote = notes.getSelectionModel().getSelectedItem();
        System.out.println(notes.getSelectionModel().getSelectedItem().getId());

        refreshView();

    }

    @FXML
    void removePressed(ActionEvent event) {
        notebook.remove(currentNote);
        refreshList();
    }

    @FXML
    void newClicked(ActionEvent event){
        currentNote = new Note();
        notebook.add(currentNote);
        refreshList();
        refreshView();

    }

    @FXML
    void exitApplication(ActionEvent event){
        System.out.println("EXIT");
    }


    private void refreshList(){
        HashMap<UUID, Note> notemap = notebook.getNotes();

        notes.getItems().clear();

        System.out.println("Populating list: ");
        for (Map.Entry<UUID, Note> entry : notemap.entrySet()){
            notes.getItems().add(entry.getValue());
            System.out.println("__");
        }
        System.out.println("Listsize: " + notes.getItems().size());

    }

    private void updateNote(){
        System.out.println("Updating note: " + currentNote.getId());
        notebook.update(currentNote);
        refreshList();
        notebook.getNotes().forEach((u, n) -> System.out.println(n.getTitle()));
        updated = false;
    }

    private void noteChanged(){
        if (!currentNote.getText().equals(text.getText()))
            updated = true;
        System.out.println("UPDATED: " + updated);
        if (!currentNote.getTitle().equals(title.getText()))
            updated = true;
        System.out.println("UPDATED: " + updated);

        // TODO where to put this?
        // must catch all possible actions by user but not update unnecessarily
        if (updated)
            updateNote();
    }

    private void refreshView(){
        title.setText(currentNote.getTitle());
        text.setText(currentNote.getText());
        details.setText("Created: " + currentNote.getCreated()
                + "\nModified: " + currentNote.getModified()
                + "\nEdited: " + currentNote.getEdited() + " times"
        );
    }

    private void load(){
        System.out.println("Trying to load:");
        if (!new File("save.dat").exists()){
            System.out.println("No save found!");
            return;
        }
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("save.dat"))){
            System.out.println("Loading..");
            notebook = (Notebook) is.readObject();
            System.out.println("NN:" + notebook.size());
        }catch (IOException | ClassNotFoundException e){
            //HANDEL
            System.out.println(e);
        }
    }

    public void save(){
        if (!currentNote.getTitle().equals(title.getText()))
            currentNote.setTitle(title.getText());
        if (!currentNote.getText().equals(text.getText()))
            currentNote.setText(text.getText());


        System.out.println("Saving on close");
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("save.dat"))){
            System.out.println("Saving...");
            os.writeObject(notebook);
            System.out.println("Savved");
        }catch(IOException e){
            // handle
        }
    }

}
