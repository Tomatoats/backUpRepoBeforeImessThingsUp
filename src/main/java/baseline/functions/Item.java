package baseline.functions;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class Item {
    private SimpleStringProperty duedate;
    private SimpleStringProperty todoDescription;
    String[] putin = new String[2];
    CheckBox complete;
    Button editDueDate;
    Button editDescription;
    Button removeItem;


    public Item(String dd, String desc){
        this.duedate = new SimpleStringProperty(dd);
        this.todoDescription = new SimpleStringProperty(desc);
        this.complete = new CheckBox();
        this.editDueDate = new Button("\uD83D\uDCDD");
        this.editDescription = new Button("\uD83D\uDCDD");
        this.removeItem = new Button("X");
    }

    public void setComplete(CheckBox complete) {
        this.complete = complete;
    }

    public void setEditDueDate(Button editDueDate) {
        this.editDueDate = editDueDate;
    }

    public void setEditDescription(Button editDescription) {
        this.editDescription = editDescription;
    }

    public void setRemoveItem(Button removeItem) {
        this.removeItem = removeItem;
    }

    public CheckBox getComplete() {
        return complete;
    }

    public Button getEditDueDate() {
        return editDueDate;
    }

    public Button getEditDescription() {
        return editDescription;
    }
    public Button getRemoveItem(){
        return removeItem;
    }

    public void turnComplete(){
    }

    public void turnIncomplete(){
    }
    public void editThisDueDate(){}
    public void editThisDescription(){}
    public void removethisItem(){}

    public void setDueDate(String string){
        duedate.set(string);
    }
    public void setDescription(String string){
        todoDescription.set(string);
    }
    public String getDueDate(){
        return duedate.get();
    }
    public String getDescription(){
        return  todoDescription.get();
    }


    public Boolean DueDateRegex(String DueDate) {
        if (DueDate.matches("([0-9]{4})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])") || DueDate.isEmpty()) {
            setDueDate(DueDate);
            return true;
        } else {
            return false;
        }
    }
    public boolean DescriptionLength(String Description){
        if (Description.length() > 0 && Description.length() < 257)
        {
            setDescription(Description);
            return  true;
        }
        else
        {
            return false;
        }
    }
}
