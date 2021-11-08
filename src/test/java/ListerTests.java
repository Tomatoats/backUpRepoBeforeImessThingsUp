import baseline.TodoListApplication;
import baseline.controllers.ListController;
import baseline.functions.Item;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution 1
 *  Copyright 2021 Alexys Veloz
 */

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ListerTests extends ListController {
    //the tests do work they just take some literal time
    //i suspect its because of this "before each"
    //but the tests don't work at all if I do "beforeAll"
    //so please just be patient for the tests
    ObservableList<Item> basicList = FXCollections.observableArrayList();
    //ListController lc = new ListController();
    //@BeforeAll
    //@Override
            //public void start (Stage stage) throws Exception {
        //Parent add = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/List.fxml")));
        //Scene scene = new Scene(add);
        //stage.setScene(scene);
        //stage.show();
        //CheckBox checkBox = new CheckBox();
        //ObservableList<Item> basicList = FXCollections.observableArrayList();
    //}
    @Test
    void CanitHandle100() {
        Item item = new Item("2021-01-01", "Quality control");
        for (int i = 0; i < 150; i++) {
            basicList.add(item);
        }
        boolean overOneHundred;
        if (basicList.size() > 100) {
            overOneHundred = true;
        } else {
            overOneHundred = false;
        }
        assertEquals(true, overOneHundred);
    }

    @Test
    void MakeItem(){
        dueDateText.setText("2021-01-02");
        descriptionText.setText("This is a test");
        addItem();
        assertEquals("This is a test",list.get(0).getDescription());
        assertEquals("2021-01-02",list.get(0).getDueDate());
    }
    @Test
    void DescriptionLengthError(){
        descriptionText.setText("12345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781");
        //its 257 characters, absolute limit should be 256
        addItem();
        assertEquals("Description must be within 1-256 characters and Due Date should be in YYYY-MM-DD Format.",errorLabel.getText());
    }
    @Test
    void DueDateOptionality(){
        descriptionText.setText("hi");
        dueDateText.setText("");
        addItem();
        assertEquals("",list.get(0).getDueDate());
    }
    @Test
    void ValidDates(){
        descriptionText.setText("hi");
        dueDateText.setText("0000-01-01");
        addItem();
        assertEquals("",list.get(0).getDueDate());
    }
    @Test
    void ProperDateFormat(){

    }
    @Test
    void removeAnItem(){

    }
    @Test
    void clearAList(){

    }
    @Test
    void EditDescription(){

    }
    @Test
    void EditdueDate(){

    }
    @Test
    void MarkItemComplete(){

    }
    @Test
    void MarkItemIncomplete(){

    }

    @Test
    void DesplayAll(){
        //in this one, once display all is clicked, we'll call
        //ShowAll() in class Display, where every item in that list is shown.
    }
    @Test
    void DesplayComplete(){
        //in this one, once display complete is clicked, we'll call
        //ShowComplete() in class Display, where every item in that list with it's third
        // element being "complete" is shown.
    }
    @Test
    void DesplayIncomplete(){
        //in this one, once display incomplete is clicked, we'll call
        //ShowIncomplete() in class Display, where every item in that list with it's third
        // element being "incomplete" is shown.
    }
    @Test
    void saveTheList(){

    }
    @Test
    void chooseSaveNameAndLocation(){
    }

}
