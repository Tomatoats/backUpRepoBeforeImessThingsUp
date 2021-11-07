package baseline.controllers;

import baseline.TodoListApplication;
import baseline.functions.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class WarningController extends TodoListApplication {
    ListController lc = new ListController();
    FileChooser fileChooser = new FileChooser();
    ObservableList<Item> list = FXCollections.observableArrayList();

    @FXML
    private Button backButton;

    @FXML
    private Button proceedButton;
    @FXML
    private Label warningLabel;


    @FXML
    void clearListPress(ActionEvent event) throws IOException {
        lc.clearList();
        closeAndOpen("List", "List!");
    }


    @FXML
    void loadList(ActionEvent event) throws IOException {
        listLoad();
        closeAndOpen("List", "List!");

    }

    public void listLoad() {
        Window originalstage = warningLabel.getScene().getWindow();
        fileChooser.setTitle("Load Dialog");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        File file = fileChooser.showOpenDialog(originalstage);
        fileChooser.setInitialDirectory(file.getParentFile());
        try (Scanner input = new Scanner(Paths.get(String.valueOf(file))).useDelimiter(",")) {
            Item items = new Item("", "");
            //also use a while to make sure it continues after the delimiter
            int i = 0;
            int k;
            ArrayList<String[]> userInput = new ArrayList<>();
            String[] user = new String[3];
            while (input.hasNext()) {
                k = i%3;

                user[k] = input.next();
                if (k == 2){
                    items.setDescription(user[0]);
                    items.setDueDate(user[1]);
                    items.whatComplete(user[2]);
                    userInput.add(user);
                    list.add(items);
                }
                i++;
            }
            lc.setList(list);

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void close(){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
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


    public void goBack(ActionEvent event) throws IOException {
        closeAndOpen("List", "List!");
    }
}




