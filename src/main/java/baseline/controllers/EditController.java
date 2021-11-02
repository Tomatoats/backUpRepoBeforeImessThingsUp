package baseline.controllers;

import baseline.functions.Verify;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditController  {
    Verify verifier = new Verify();

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
        if (verifier.DescriptionLength(DescText.getText()) == false)
        {
            ErrorLabel.setText("The description needs to be within 1 and 256 characters.");
        }
        else
        {
            //update the description
            close();
            Parent root = FXMLLoader.load(getClass().getResource("/List.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("List!");
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    void SubmitPressedDue(ActionEvent event) throws IOException {
        //make sure if whatever it was got verified. If it was Verified true, then open up list
        if (verifier.DueDateRegex(DueText.getText()) == false)
        {
            ErrorLabel.setText("The due date has to be in the form YYYY-MM-DD.");
        }
        else
        {
            //update the due date
            close();
            Parent root = FXMLLoader.load(getClass().getResource("/List.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("List!");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        close();
        Parent root =  FXMLLoader.load(getClass().getResource("/List.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("List!");
        stage.setScene(scene);
        stage.show();

    }
    public void close(){
        Stage stage = (Stage) SubmitButton.getScene().getWindow();
        stage.close();
    }
}
