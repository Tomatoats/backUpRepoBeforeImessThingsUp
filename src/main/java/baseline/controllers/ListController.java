package baseline.controllers;

import baseline.TodoListApplication;
import baseline.functions.Item;
import baseline.functions.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class ListController extends TodoListApplication implements Initializable {
    FileChooser fileChooser = new FileChooser();
    private  ObservableList<Item> list = FXCollections.observableArrayList();
    Item items = new Item("","");




    @FXML
    private Button AddItemButton;
    /*@FXML
    private TableColumn<Item, String> ColComplete;

    @FXML
    private TableColumn<Item, String> ColDescription;

    @FXML
    private TableColumn<Item, String> ColDueDate;

    @FXML
    private TableColumn<Item, String> ColEditDate;

    @FXML
    private TableColumn<Item, String> ColEditDesc;

    @FXML
    private TableColumn<Item, String> ColRemove;
    */
    @FXML
    private Button SortAll;
    @FXML
    private Label ErrorLabel;

    @FXML
    private TextField DescriptionText;
    @FXML
    private TextField DueDateText;

    @FXML
    private Button SortComplete;

    @FXML
    private Button SortIncomplete;


    @FXML
    public CheckBox CheckBox;

    @FXML
    private Button ClearButton;


    @FXML
    private Label DateLabel;

    @FXML
    private Label DescriptionLabel;

    @FXML
    private Button LoadButton;

    @FXML
    public Button RemoveItemButton;


    @FXML
    public Button editDateButton;

    @FXML
    public Button editDescButton;

    @FXML
    private TableView<Item> ListTable;

    @FXML
    private Button SaveButton;
    @FXML
    private Button NewListButton;

    @FXML
    void AddPressed(ActionEvent event) throws IOException {
        if (!Boolean.TRUE.equals(Boolean.TRUE.equals(items.DueDateRegex(DueDateText.getText()))) || !items.DescriptionLength(DescriptionText.getText())) {
            ErrorLabel.setText("Description must be within 1-256 characters and Due Date should be in YYYY-MM-DD Format.");
        } else {

            ErrorLabel.setText("");
            Item  quiz = new Item(DueDateText.getText(),DescriptionText.getText());
            list = getCurrentList();
            //items = getItem();
            list.add(quiz);
            DueDateText.clear();
            DescriptionText.clear();
            setUp();
            initializeTable(items);

            //Oclass ThingStore{
            //private ObersvableList<>() things;
            //public ThingStore(){
            //things = new Observableist<>()
            //public void addThing (thing T) {
            // things.add(t)
            //closeAndOpen("List", "List!");
        }
    }
    public Item newItem(){

        items.setDueDate(DueDateText.getText());
        items.setDescription(DescriptionText.getText());
        items.setComplete(CheckBox);
        items.setEditDueDate(editDateButton);
        items.setEditDescription(editDescButton);
        items.setRemoveItem(RemoveItemButton);
        return items;
    }
    private void setUp(){
        //list = getCurrentList();

        items.getRemoveItem();
        items.getEditDescription();
        items.getDescription();
        items.getEditDueDate();
        items.getDueDate();
        items.getComplete();

    }
    public void initializeTable(Item items){
        TableView listTable = new TableView();
        setListTable(listTable);
        TableColumn<Item,Button> ColRemove = new TableColumn<>("Remove?");
        TableColumn<Item,Button> ColEditDesc = new TableColumn<>("Edit Desc");
        TableColumn<Item,String> ColDescription = new TableColumn<>("Description");
        TableColumn<Item,Button>  ColEditDate = new TableColumn<>("Edit Date");
        TableColumn<Item,String> ColDueDate = new TableColumn<>("Due Date");
        TableColumn<Item,CheckBox> ColComplete = new TableColumn<>("Completed?");
        listTable.getColumns().addAll(ColRemove,ColEditDesc,ColDescription,ColEditDate,ColDueDate,ColComplete);
        ColRemove.setCellValueFactory(new PropertyValueFactory<>("removeItem"));
        ColEditDesc.setCellValueFactory(new PropertyValueFactory<>("editDescription"));
        ColDescription.setCellValueFactory(new PropertyValueFactory<>("todoDescription"));
        ColEditDate.setCellValueFactory(new PropertyValueFactory<>("editDueDate"));
        ColDueDate.setCellValueFactory(new PropertyValueFactory<>("duedate"));
        ColComplete.setCellValueFactory(new PropertyValueFactory<>("complete"));
        list = getCurrentList();
        //System.out.println(list.getAt(0).getDescription());
        ListTable.setItems(list);
    }


    @FXML
    void WarnNewList(ActionEvent event) throws IOException {
        closeAndOpen("WarningNew","Are you sure?");
    }

    @FXML
    void EditDueDate(ActionEvent event) throws IOException {
        closeAndOpen("EditDueDate","Due Date:");
    }



    @FXML
    void PopUpWarningClear(ActionEvent event) throws IOException {
        closeAndOpen("WarningClear","Are you sure?");
    }

    @FXML
    void PopUpWarningLoad(ActionEvent event) throws IOException {
        closeAndOpen("WarningLoad","Are you sure?");
       }

    @FXML
    void PopUpWarningRemove(ActionEvent event) throws IOException {
        closeAndOpen("WarningRemove","Are you sure?");
    }

    @FXML
    void editDescription(ActionEvent event) throws IOException {
        closeAndOpen("EditDescription","Description:");
    }
    @FXML
    void SaveList(ActionEvent event) {
        Window stage = SaveButton.getScene().getWindow();
        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("Lister");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        try {
            File file = fileChooser.showSaveDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());
        }
        catch (Exception ex)
        {

        }

    }
    public void close(){
        Stage stage = (Stage) SaveButton.getScene().getWindow();
        stage.close();
    }
    public void show(){
            DateLabel.setText(items.getDueDate());
            DescriptionLabel.setText(items.getDescription());
    }
    public void closeAndOpen(String fxmlname, String stageTitle) throws IOException {
        close();
        Addscenes();
        Map theScenemap = getScenemap();
        Scene scene = (Scene) theScenemap.get(fxmlname);
        Stage stage = new Stage();
        stage.setTitle(stageTitle);
        stage.setScene(scene);
        stage.show();
    }
    public Item getItem(){
        return items;
    }

    public void setListTable(TableView<Item> listTable) {
        this.ListTable = listTable;
    }

    public TableView<List> getListTable() {
       TableView<List> table = new TableView<List>();
        return table;
    }

    @FXML
    void printList(ActionEvent event) {
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getDescription());
            System.out.println(list.get(i).getDueDate());
            System.out.println(list.size());
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*TableColumn ColRemove = new TableColumn("Remove?");
        TableColumn ColEditDesc = new TableColumn("Edit Desc");
        TableColumn ColDescription = new TableColumn("Description");
        TableColumn  ColEditDate = new TableColumn("Edit Date");
        TableColumn ColDueDate = new TableColumn("Due Date");
        TableColumn ColComplete = new TableColumn("Completed?");

        ListTable.getColumns().addAll(ColRemove,ColEditDesc,ColDescription,ColEditDate,ColDueDate,ColComplete);
        ColRemove.setCellValueFactory(new PropertyValueFactory<>("removeItem"));
        ColEditDesc.setCellValueFactory(new PropertyValueFactory<>("editDescription"));
        ColDescription.setCellValueFactory(new PropertyValueFactory<>("todoDescription"));
        ColEditDate.setCellValueFactory(new PropertyValueFactory<>("editDueDate"));
        ColDueDate.setCellValueFactory(new PropertyValueFactory<>("duedate"));
        ColComplete.setCellValueFactory(new PropertyValueFactory<>("complete"));
        */
    }
}