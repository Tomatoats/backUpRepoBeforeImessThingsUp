import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution 1
 *  Copyright 2021 Alexys Veloz
 */

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ListerTests {
    //the tests do work they just take some literal time
    //i suspect its because of this "before each"
    //but the tests don't work at all if I do "beforeAll"
    //so please just be patient for the tests
    {
        //so I'm gonna have a List be an Arraylist of String[]
        //where an item is a String[4] for Title(String[0]), Due Date(String[1]), Description(String[2]),
        // and completed(String[3]) or not
        //the arrayList name is going to be in the first String[] we take in, the actual arrayList name will be a number
        //the String[] name is just going to be a number since technically each item doesn't neeeeed a title
        ArrayList<String[]> List1 = new ArrayList<>();
        String[] ListName = new String[1];
        ListName[0] = "School Projects";
        List1.add(ListName);

        String[] item1 = new String[4];
        item1[0] = "Birthday Party";
        item1[1] = "2021-11-11";
        item1[2] = "Make sure to buy dad's gift before hand! Address: 123 Sesame Street";
        item1[3] = "incomplete";
        List1.add(item1);
    }
    @Test
    void CanitHandle100(){

    }
    @Test
    void MakeItem(){

    }
    @Test
    void DescriptionLengthError(){

    }
    @Test
    void DueDateOptionality(){

    }
    @Test
    void ValidDates(){

    }
    @Test
    void ProperDateFormat(){

    }
    @Test
    void removeItem(){

    }
    @Test
    void clearList(){

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
