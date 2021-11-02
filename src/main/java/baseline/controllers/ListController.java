package baseline.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;

public class ListController {
    FileChooser fileChooser = new FileChooser();


    @FXML
    private Button AddItemButton;

    @FXML
    private CheckBox CheckBox;

    @FXML
    private Button ClearButton;

    @FXML
    private ComboBox<?> ComboBox;

    @FXML
    private Label DateLabel;

    @FXML
    private Label DescriptionLabel;

    @FXML
    private Button LoadButton;

    @FXML
    private Button RemoveItemButton;

    @FXML
    private ScrollBar Scroll;

    @FXML
    private Button editDateButton;

    @FXML
    private Button editDescButton;

    @FXML
    private Button SaveButton;
    @FXML
    private Button NewListButton;


    @FXML
    void WarnNewList(ActionEvent event) throws IOException {
        close();
        Parent root =  FXMLLoader.load(getClass().getResource("/WarningNew.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Are you sure?");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void EditDueDate(ActionEvent event) throws IOException {
        close();
        Parent root =  FXMLLoader.load(getClass().getResource("/EditDueDate.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Due Date:");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void OpenUpNewItem(ActionEvent event) throws IOException {
        close();
        Parent root =  FXMLLoader.load(getClass().getResource("/AddItem.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Make a New Item!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void PopUpWarningClear(ActionEvent event) throws IOException {
        close();
        Parent root =  FXMLLoader.load(getClass().getResource("/WarningClear.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Are you sure?");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void PopUpWarningLoad(ActionEvent event) throws IOException {
        close();
        Parent root =  FXMLLoader.load(getClass().getResource("/WarningLoad.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Are you sure?");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void PopUpWarningRemove(ActionEvent event) throws IOException {
        close();
        Parent root =  FXMLLoader.load(getClass().getResource("/WarningRemove.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Are you sure?");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void editDescription(ActionEvent event) throws IOException {
        close();
        Parent root =  FXMLLoader.load(getClass().getResource("/EditDescription.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Description:");
        stage.setScene(scene);
        stage.show();
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
        Stage stage = (Stage) ComboBox.getScene().getWindow();
        stage.close();
    }


}
