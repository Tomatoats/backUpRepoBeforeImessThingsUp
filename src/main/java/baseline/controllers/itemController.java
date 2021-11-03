package baseline.controllers;

import baseline.TodoListApplication;
import baseline.functions.Item;
import baseline.functions.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class itemController extends TodoListApplication {
        List list;
        Item items = new Item();
        ListController lc = new ListController();

    public void getList(List test){
        this.list = test;
    }
    public void addToList(){
        list.addItem(items);
    }
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
            close();
            Parent root =  FXMLLoader.load(getClass().getResource("/List.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("List!");
            stage.setScene(scene);
            stage.show();

        }
        @FXML
        void GoToStart(ActionEvent event) throws IOException {
        close();
        Parent root = FXMLLoader.load(getClass().getResource("/start.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Lister");
        stage.setScene(scene);
        stage.show();

         }
        @FXML
        void SubmitPressed(ActionEvent event) throws IOException {
            if (!Boolean.TRUE.equals(Boolean.TRUE.equals(items.DueDateRegex(DueDateText.getText()))) || !items.DescriptionLength(DescriptionText.getText())) {
                ErrorLabel.setText("You have at least one error. Fix and try again.");
            }
            else {
                close();
                // add it to List and open up List.fxml
                Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/List.fxml")));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("List!");
                stage.setScene(scene);
                stage.show();
            }
        }
    public void close(){
        Stage stage = (Stage) submit.getScene().getWindow();
        stage.close();
    }
    }