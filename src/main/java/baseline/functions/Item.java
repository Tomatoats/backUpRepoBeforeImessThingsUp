package baseline.functions;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Alexys Veloz
 */

public class Item {
    String dueDate;
    String description;
    public CheckBox complete;


    public Item(String dd, String desc){
        this.dueDate = dd;
        this.description = desc;
        this.complete = new CheckBox();

    }

    public String getDueDate(){
        return dueDate;
    }
    public String getDescription(){
        return description;
    }



    public void setComplete(CheckBox complete) {
        this.complete = complete;
    }
    public void whatComplete (String string){
        if (string.equals("true")){
            this.complete.setSelected(true);
            setComplete(complete);
        }

    }

    public CheckBox getComplete() {
        return complete;
    }


    public void setDueDate(String string){
        this.dueDate = string;
    }
    public void setDescription(String string){
        this.description = string;
    }


    public Boolean dueDateRegex(String dueDate) {
        if (dueDate.matches("([0-9]{4})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])") || dueDate.isEmpty()) {
            setDueDate(dueDate);
            return true;
        } else {
            return false;
        }
    }
    public boolean descriptionLength(String description){
        if (description.length() > 0 && description.length() < 257)
        {
            setDescription(description);
            return  true;
        }
        else
        {
            return false;
        }
    }
}
