package baseline.functions;

import java.lang.reflect.Array;
import java.util.ArrayList;
/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution 1
 *  Copyright 2021 Alexys Veloz
 */

public class Save {
    /* This will ask the user what list(s) they want to save, and where they want it to be saved.
     it will add its changes to the txt and letting the user know that everything was saved to the txt file
     */
    ArrayList<String[]> List;

    private void AskListsToSave(){
        //it will getLists for all the possible
        //lists it has previously saved or made, then show to the user
        //which ones they'd like to save. For each one the user chooses,
        //we'll add a final String[] to the list that will have "Savethis"
        //as it's 0th element, used as a marker to save.
    }

    private void Save(){
        //once it get's where the file will be saved to
        //and after the user names it to whatever they want,
        //we will print to that .txt file, printing every String[]
        //saved in the array (except SaveThis), that's a key that we're done printing that arrayList
        //and we start printing out the next arraylist with SaveThis to the .txt
    }

    private ArrayList<String[]> getList(){
        return List;
    }
}
