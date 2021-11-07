package baseline.controllers;

import baseline.TodoListApplication;
import baseline.functions.Item;
import baseline.functions.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class EditController extends TodoListApplication {
    List currentList = new List();
    Item items;

    @FXML
    private Label EditLabelDueDesc;
    @FXML
    private TextField DueText;


    @FXML
    private TextField DescText;

    @FXML
    private Label ErrorLabel;

    @FXML
    private Button SubmitButton;
    @FXML
    private Button BackButton;




    @FXML
    void SubmitPressedDesc(ActionEvent event) throws IOException {
        //make sure if whatever it was got verified. If it was Verified true, then open up list
        if (items.descriptionLength(DescText.getText()) == false)
        {
            ErrorLabel.setText("The description needs to be within 1 and 256 characters.");
        }
        else
        {
            //update the description
            closeAndOpen("List","List!");
        }
    }
    @FXML
    void SubmitPressedDue(ActionEvent event) throws IOException {
        //make sure if whatever it was got verified. If it was Verified true, then open up list
        if (items.dueDateRegex(DueText.getText()) == false)
        {
            ErrorLabel.setText("The due date has to be in the form YYYY-MM-DD.");
        }
        else
        {
            //update the due date
            //tablview checkbox (tablecell)
            closeAndOpen("List","List!");
        }
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        closeAndOpen("List","List!");
    }
    public void close(){
        Stage stage = (Stage) SubmitButton.getScene().getWindow();
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
}
