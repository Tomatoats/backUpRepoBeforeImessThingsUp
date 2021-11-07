package baseline;


import baseline.functions.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution 1
 *  Copyright 2021 Alexys Veloz
 */

public class TodoListApplication extends javafx.application.Application {
    ObservableList<Item> currentList = FXCollections.observableArrayList();
     Map<String,Scene> scenemap = new HashMap<>();


    public void start(Stage stage) throws Exception {
        addscenes();


        Scene scene = scenemap.get("start");
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());

        stage.setTitle("Lister");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    public void addscenes() throws IOException {
        Map<String,Scene> addmap = new HashMap<>();
        Parent add = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/AddItem.fxml")));
        Scene toAdd = new Scene(add);
        addmap.put("AddItem",toAdd);
        add = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FirstItem.fxml")));
        toAdd = new Scene(add);
        addmap.put("FirstItem",toAdd);
        add = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/EditDescription.fxml")));
        toAdd = new Scene(add);
        addmap.put("EditDescription",toAdd);
        add = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/EditDueDate.fxml")));
        toAdd = new Scene(add);
        addmap.put("EditDueDate",toAdd);
        add = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Error.fxml")));
        toAdd = new Scene(add);
        addmap.put("Error",toAdd);
        add = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/List.fxml")));
        toAdd = new Scene(add);
        addmap.put("List",toAdd);
        add = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/NewItem.fxml")));
        toAdd = new Scene(add);
        addmap.put("NewItem",toAdd);
        add = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/start.fxml")));
        toAdd = new Scene(add);
        addmap.put("start",toAdd);
        add = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/WarningClear.fxml")));
        toAdd = new Scene(add);
        addmap.put("WarningClear",toAdd);
        add = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/WarningLoad.fxml")));
        toAdd = new Scene(add);
        addmap.put("WarningLoad",toAdd);
        add = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/WarningNew.fxml")));
        toAdd = new Scene(add);
        addmap.put("WarningNew",toAdd);
        this.scenemap = addmap;
    }
    public ObservableList<Item> getCurrentList(){
        return currentList;
    }


    public Map<String, Scene> getScenemap(){
        return scenemap;
    }


}
