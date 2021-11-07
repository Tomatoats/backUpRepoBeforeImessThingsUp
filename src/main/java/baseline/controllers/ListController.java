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
import java.nio.file.Paths;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;


/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Alexys Veloz
 */
public class ListController extends TodoListApplication implements  Initializable{
    FileChooser fileChooser = new FileChooser();
    ObservableList<Item> list = FXCollections.observableArrayList();
    Item items = new Item("","");
    int k = 0;

    @FXML
    private Button removeButton;
    @FXML
    private Button addItemButton;


    @FXML
    private Button sortAll;
    @FXML
    private Button sortComplete;
    @FXML
    private Button sortIncomplete;


    @FXML
    private TextField descriptionText;
    @FXML
    private TextField dueDateText;
    @FXML
    private Label errorLabel;


    @FXML
    private Button clearButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button saveButton;


    @FXML
    private TableView<Item> listTable;
    @FXML
    public TableColumn colComplete;
    @FXML
    public TableColumn colDescription;
    @FXML
    public TableColumn colDueDate;
    @FXML
    public CheckBox checkBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTable();

    }
    @FXML
    void addPressed(ActionEvent event) {
        addItem();
    }
    @FXML
    void removePressed(ActionEvent event) {
        removeItem();
    }

    @FXML
    void allPress(ActionEvent event) {
        allList();
    }

    @FXML
    void completePress(ActionEvent event) {
       completeLists();
    }

    @FXML
    void incompletePress(ActionEvent event) {
        incompleteLists();
    }

    @FXML
    void clearPressed(ActionEvent event) {
        clearList();
    }

    @FXML
    void loadPressed(ActionEvent event) throws IOException {
        listload();
    }

    @FXML
    void saveList(ActionEvent event) {
        findAndSave();
    }

    public void removeItem(){
        listTable.getItems().removeAll(listTable.getSelectionModel().getSelectedItem());
    }
    public void findAndSave(){
        Window stage = saveButton.getScene().getWindow();
        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("Lister");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        try {

            File file = fileChooser.showSaveDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());
            save(file);
        }
        catch (Exception ignored){}


    }
    public void incompleteLists(){
        ObservableList<Item> incompleteList = FXCollections.observableArrayList();
        for (Item item : list) {
            if (!item.complete.isSelected()) {
                incompleteList.add(item);
            }
        }
        listTable.setItems(incompleteList);
    }
    public void completeLists(){
        ObservableList<Item> completeList = FXCollections.observableArrayList();
        for (Item item : list) {
            if (item.complete.isSelected()) {
                completeList.add(item);
            }
        }
        listTable.setItems(completeList);
    }
    public void allList(){
        listTable.setItems(list);
    }
    public void addItem(){
        if (!Boolean.TRUE.equals(Boolean.TRUE.equals(items.dueDateRegex(dueDateText.getText()))) || !items.descriptionLength(descriptionText.getText())) {
            errorLabel.setText("Description must be within 1-256 characters and Due Date should be in YYYY-MM-DD Format.");
        } else {
            errorLabel.setText("");
            list.add(new Item (dueDateText.getText(), descriptionText.getText()));
            k++;
            dueDateText.clear();
            descriptionText.clear();
        }
    }

    public Item getItem(){
        return items;
    }

    public void setListTable(TableView<Item> listTable) {
        this.listTable = listTable;
    }

    public TableView<List> getListTable() {
        return new TableView<>();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setList(ObservableList<Item> list){
        this.list = list;
    }

    public void clearList(){
        list.remove(0,list.size());
        //listTable.setItems(list);
    }

    @FXML
    public void initializeTable(){

        listTable.setEditable(true);
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        colDescription.setOnEditCommit((EventHandler<TableColumn.CellEditEvent>) event -> {
                    if (items.descriptionLength(String.valueOf(event.getNewValue())) == true) {
                        ((Item) event.getTableView().getItems().get(event.getTablePosition().getRow())).setDescription(String.valueOf(event.getNewValue()));
                        errorLabel.setText("");
                    } else {
                        errorLabel.setText("Description must be within 1-256 characters");
                    }
                }
        );

        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colDueDate.setCellFactory(TextFieldTableCell.forTableColumn());
        colDueDate.setOnEditCommit((EventHandler<TableColumn.CellEditEvent>) event -> {
                    if (Boolean.FALSE.equals(items.dueDateRegex(String.valueOf(event.getNewValue())))) {
                        errorLabel.setText("Due Date must either be empty or in the format YYYY-MM-DD");
                    } else {
                        ((Item) event.getTableView().getItems().get(event.getTablePosition().getRow())).setDueDate(String.valueOf((event.getNewValue())));
                        errorLabel.setText("");
                    }
                }
        );
        colComplete.setCellValueFactory(new PropertyValueFactory<>("complete"));
        listTable.setItems(list);
    }

    public void listload() {
        Window originalstage = errorLabel.getScene().getWindow();
        fileChooser.setTitle("Load Dialog");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        File file = fileChooser.showOpenDialog(originalstage);
        fileChooser.setInitialDirectory(file.getParentFile());
        try (Scanner input = new Scanner(Paths.get(String.valueOf(file))).useDelimiter("\n"))
        {
            clearList();
            //also use a while to make sure it continues after the delimiter
            while (input.hasNext()) {
                Item items = new Item("", "");
                String str = input.next();
                String[] ArrayofString = str.split(",", 3);
                items.setDescription(ArrayofString[0]);
                items.setDueDate(ArrayofString[1]);
                items.whatComplete(ArrayofString[2]);
                list.add(items);
            }
            errorLabel.setText("");
        }
        catch (ArrayIndexOutOfBoundsException | IOException arrayIndexOutOfBoundsException) {
            errorLabel.setText("Either the file was corrupted or not in Lister format.");

        }
}

    void save(File file) throws IOException {
        try {

            FileWriter fileWriter = null;

            fileWriter = new FileWriter(file);
            for (int i = 0; i < list.size();i++) {
                fileWriter.write(list.get(i).getDescription() + ",");
                fileWriter.write( list.get(i).getDueDate() + ",");
                if (list.get(i).complete.isSelected()) {
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

    public void close(){
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }


}