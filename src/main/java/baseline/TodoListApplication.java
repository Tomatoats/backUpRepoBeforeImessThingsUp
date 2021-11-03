package baseline;


import baseline.functions.Item;
import baseline.functions.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution 1
 *  Copyright 2021 Alexys Veloz
 */

public class TodoListApplication extends javafx.application.Application {
    List currentList = new List();
    Item items = new Item();

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/start.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        stage.setTitle("Lister");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        TodoListApplication myTodoListApplication;
        launch(args);
    }

}
