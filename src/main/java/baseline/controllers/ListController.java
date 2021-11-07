package baseline.controllers;

import baseline.TodoListApplication;
import baseline.functions.Item;
import baseline.functions.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class ListController extends TodoListApplication implements  Initializable{
    FileChooser fileChooser = new FileChooser();
    public   ObservableList<Item> list = FXCollections.observableArrayList();
    Item items = new Item("","");




    @FXML
    private Button removeButton;



    @FXML
    private Button AddItemButton;
    @FXML
    public TableColumn colComplete;

    @FXML
    public TableColumn colDescription;

    @FXML
    public TableColumn colDueDate;


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
    void removePressed(ActionEvent event) {
        ListTable.getItems().removeAll(ListTable.getSelectionModel().getSelectedItem());
    }
    @FXML
    void AddPressed(ActionEvent event) throws IOException {
        if (!Boolean.TRUE.equals(Boolean.TRUE.equals(items.dueDateRegex(DueDateText.getText()))) || !items.descriptionLength(DescriptionText.getText())) {
            ErrorLabel.setText("Description must be within 1-256 characters and Due Date should be in YYYY-MM-DD Format.");
        } else {

            ErrorLabel.setText("");
            //items = getItem();
            list.add(new Item (DueDateText.getText(),DescriptionText.getText()));
            DueDateText.clear();
            DescriptionText.clear();


        }
    }




    @FXML
    public void initializeTable(){

        ListTable.setEditable(true);
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        colDescription.setOnEditCommit((EventHandler<TableColumn.CellEditEvent>) event -> {
            if (items.descriptionLength(String.valueOf(event.getNewValue())) == true) {
                ((Item) event.getTableView().getItems().get(event.getTablePosition().getRow())).setDescription(String.valueOf(event.getNewValue()));
                ErrorLabel.setText("");
            } else {
                ErrorLabel.setText("Description must be within 1-256 characters");
            }
        }
        );

        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colDueDate.setCellFactory(TextFieldTableCell.forTableColumn());
                colDueDate.setOnEditCommit((EventHandler<TableColumn.CellEditEvent>) event -> {
                            if (Boolean.FALSE.equals(items.dueDateRegex(String.valueOf(event.getNewValue())))) {
                                ErrorLabel.setText("Due Date must either be empty or in the format YYYY-MM-DD");
                            } else {
                                ((Item) event.getTableView().getItems().get(event.getTablePosition().getRow())).setDueDate(String.valueOf((event.getNewValue())));
                                ErrorLabel.setText("");
                            }
                        }
                );
        colComplete.setCellValueFactory(new PropertyValueFactory<>("complete"));
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
    void saveList(ActionEvent event) {
        Window stage = SaveButton.getScene().getWindow();
        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("Lister");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        try {

            File file = fileChooser.showSaveDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());
            try {
                save(file);
            }
            catch (Exception ignored){}
        }
        catch (Exception ignored){}

    }
    void save(File file) throws IOException {
        try {

            FileWriter fileWriter = null;

            fileWriter = new FileWriter(file);
            for (Item item : list) {
                fileWriter.write(item.getDescription() + ",");
                fileWriter.write(item.getDueDate() + ",");
                if (item.complete.isSelected()) {
                    fileWriter.write("true\n");
                } else {
                    fileWriter.write("false\n");
                }
            }
                fileWriter.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void close(){
        Stage stage = (Stage) SaveButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void allPress(ActionEvent event) {
        ListTable.setItems(list);
    }

    @FXML
    void completePress(ActionEvent event) {
        ObservableList<Item> completeList = FXCollections.observableArrayList();
        for (Item item : list) {
            if (item.complete.isSelected()) {
                completeList.add(item);
            }
        }
        ListTable.setItems(completeList);
    }

    @FXML
    void incompletePress(ActionEvent event) {
        ObservableList<Item> incompleteList = FXCollections.observableArrayList();
        for (Item item : list) {
            if (!item.complete.isSelected()) {
                incompleteList.add(item);
            }
        }
        ListTable.setItems(incompleteList);

    }

    public void closeAndOpen(String fxmlname, String stageTitle) throws IOException {
        close();
        addscenes();
        Map<String, Scene> theScenemap = getScenemap();
        Scene scene = theScenemap.get(fxmlname);
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
        return new TableView<>();
    }

    @FXML
    void printList(ActionEvent event) {
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getDescription());
            System.out.println(list.get(i).getDueDate());
            System.out.println(list.size());
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void setList(ObservableList<Item> list){
        this.list = list;
    }

    public void clearList(){
        for (int i = 0; i < list.size(); i++){
            list.remove(i);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTable();

    }


}