package baseline.controllers;

import baseline.TodoListApplication;
import baseline.functions.Item;
import baseline.functions.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ListController extends TodoListApplication {
    FileChooser fileChooser = new FileChooser();
    List list;
    Item items;




    @FXML
    private Button AddItemButton;
    @FXML
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

    @FXML
    private Button SortAll;

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
    private ScrollBar Scroll;

    @FXML
    public Button editDateButton;

    @FXML
    public Button editDescButton;

    @FXML
    private TableView<List> ListTable;

    @FXML
    private Button SaveButton;
    @FXML
    private Button NewListButton;

    public void initializeTable(){
        //setListTable(ListTable);
        ColRemove = new TableColumn("Remove?");
        ColEditDesc = new TableColumn("Edit Desc");
        ColDescription = new TableColumn("Description");
        ColEditDate = new TableColumn("Edit Date");
        ColDueDate = new TableColumn("Due Date");
        ColComplete = new TableColumn("Completed?");
        setUp();
    }
    private void setUp(){
        ColRemove.setCellValueFactory(new PropertyValueFactory<>("removeItem"));
        ColEditDesc.setCellValueFactory(new PropertyValueFactory<>("editDescription"));
        ColDescription.setCellValueFactory(new PropertyValueFactory<>("todoDescription"));
        ColEditDate.setCellValueFactory(new PropertyValueFactory<>("editDueDate"));
        ColDueDate.setCellValueFactory(new PropertyValueFactory<>("duedate"));
        ColComplete.setCellValueFactory(new PropertyValueFactory<>("complete"));
        getListTable();
        //ListTable((ObservableList<List>) list);
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
    void OpenUpNewItem(ActionEvent event) throws IOException {
        closeAndOpen("AddItem","Make a New Item!");
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

    public void setListTable(TableView<List> listTable) {
        this.ListTable = listTable;
    }

    public TableView<List> getListTable() {
        return ListTable;
    }
}