package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;


public class Controller {
    private Notebook notebook;
    private Note currentNote;
    private UUID systemID;

    private boolean useCloudSave = true;
    private boolean updated = false;
    private final String file = SaveFile.getFileName();

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
                updateNote();
            }
        });

        text.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV){
                System.out.println("Fopcus lost on textarea");
                currentNote.setText(text.getText());
                updateNote();
            }
        });

        refreshList();

        if (notes.getItems().size() > 0)
            currentNote = notes.getItems().get(0);
        refreshView();
    }

    public Controller() {
        // AWS deprecated the SDK v1 I used and I'm not doing it from scratch because of it
        // we'll use the deprecated one but let's disable nagging
        System.setProperty("aws.java.v1.disableDeprecationAnnouncement", "true");

        systemID = new UniqueSystem().getId();  // maybe just save this once to config?
        // would allow setting of old ID after the change of username or hostname
        System.out.println("SystemID: " + systemID);

        new Cloud().load(systemID);

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
        title.requestFocus();
    }

    @FXML
    void exitApplication(ActionEvent event){
        System.out.println("EXIT");
    }

    @FXML
    void menuCloudDelete(ActionEvent e){
        new Cloud().delete(systemID);
    }

    @FXML
    void menuCloudSaveAction(ActionEvent e){
        useCloudSave = ((CheckMenuItem) e.getSource()).isSelected();
        System.out.println("Cloud save set to: " + useCloudSave);
    }


    private void refreshList(){
        ArrayList<Note> notelist = notebook.getNotes();

        notes.getItems().clear();

        System.out.println("Populating viewlist: ");
        notelist.forEach((n) -> notes.getItems().add(n));
    }

    private void updateNote(){
        System.out.println("Updating note: " + currentNote.getId());
        if (notebook.update(currentNote))
            updated = true;
        refreshList();
        notebook.getNotes().forEach(System.out::println);
    }

    private void refreshView(){
        title.setText(currentNote.getTitle());
        text.setText(currentNote.getText());
        details.setText("Created: " + currentNote.getCreated()
                + "\nModified: " + currentNote.getModified()
                + "\nEdited: " + currentNote.getEdited() + " times"
        );
    }

    // saving/loading so simple no real reason to use a class for it?
    // TODO: maybe put this to a fileoperations class with config file manipulation
    private void load(){
        System.out.println("Trying to load:");

        if (!new File("save.dat").exists()){
            System.err.println("No save found!");
            return;
        }

        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))){
            System.out.println("Loading..");
            notebook = (Notebook) is.readObject();
            System.out.println("NN:" + notebook.size());
        }catch (IOException | ClassNotFoundException e){
            //HANDEL
            System.err.println(e.getMessage());
        }
    }

    public void save(){
        if (!currentNote.getTitle().equals(title.getText())) {
            currentNote.setTitle(title.getText());
            updated = true;
        }
        if (!currentNote.getText().equals(text.getText())) {
            currentNote.setText(text.getText());
            updated = true;
        }

        if (!updated){
            System.out.println("Not updated => not saving");
            cloudSave(); // if cloud save doesn't exist we make sure to upload even if no changes
            return;
        }

        System.out.println("Saving on close");
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))){
            System.out.println("Saving...");
            os.writeObject(notebook);
            System.out.println("Saved");
        }catch(IOException e){
            // handle
            System.err.println(e.getMessage());
        }

        cloudSave();
    }

    private void cloudSave(){
        if (useCloudSave)
            new Cloud().save(systemID);
    }

}
