package baseline.controllers;

import baseline.TodoListApplication;
import baseline.functions.Item;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class itemController extends TodoListApplication {
    ObservableList<Item> list;
    Item items = new Item("","");
    ListController lc = new ListController();


    //public void getList(List test){
    //this.list = test;
    //}
    //public void addToList(){
    //list.addItem(items);
    //}
    @FXML
    private Button submit;

    @FXML
    private TextField DescriptionText;

    @FXML
    private TextArea DueDateText;

    @FXML
    private Label ErrorLabel;

    @FXML
    private Button BackButtonAdd;

    @FXML
    private Button BackButtonNew;

    @FXML
    void GoBack(ActionEvent event) throws IOException {
        closeAndOpen("List","List!");
    }

    @FXML
    void GoToStart(ActionEvent event) throws IOException {
        closeAndOpen("start","Lister");
    }

    @FXML
    void SubmitPressed(ActionEvent event) throws IOException {
        if (!Boolean.TRUE.equals(Boolean.TRUE.equals(items.dueDateRegex(DueDateText.getText()))) || !items.descriptionLength(DescriptionText.getText())) {
            ErrorLabel.setText("You have at least one error. Fix and try again.");
        } else
        {
            newItem();
            list = getCurrentList();
            //items = getItem();
            list.add(items);


            //Oclass ThingStore{
            //private ObersvableList<>() things;
            //public ThingStore(){
            //things = new Observableist<>()
            //public void addThing (thing T) {
            // things.add(t)
            closeAndOpen("List","List!");

            //System.out.println(list.getAt(0).getDueDate());
            //System.out.println(list.getAt(0).getDescription());
        }
    }

    public void close() {
        Stage stage = (Stage) submit.getScene().getWindow();
        stage.close();
    }

    public void closeAndOpen(String fxmlname, String stageTitle) throws IOException {
        close();
        addscenes();
        Map theScenemap = getScenemap();
        Scene scene = (Scene) theScenemap.get(fxmlname);
        Stage stage = new Stage();
        stage.setTitle(stageTitle);
        stage.setScene(scene);
        stage.show();
    }
    public void newItem(){

        items.setDueDate(DueDateText.getText());
        items.setDescription(DescriptionText.getText());
        items.setComplete(lc.checkBox);
    }
    public Item getItem(){
        return items;
    }

}