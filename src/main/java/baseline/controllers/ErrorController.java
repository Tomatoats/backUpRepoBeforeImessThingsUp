package baseline.controllers;

import baseline.TodoListApplication;
import baseline.functions.Item;
import baseline.functions.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ErrorController extends TodoListApplication {
    List currentList = new List();
    Item items = new Item();


    @FXML
    private Label ErrorLabel;

    public void SetError(String prompt){
        ErrorLabel.setText(prompt);
    }

}
