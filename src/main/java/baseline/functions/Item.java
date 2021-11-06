package baseline.functions;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class Item {
    String duedate;
    String todoDescription;
    String[] putin = new String[2];
    CheckBox complete;
    Button editDueDate;
    Button editDescription;
    Button removeItem;


    public Item(String dd, String desc){
        this.duedate = new String(dd);
        this.todoDescription = new String(desc);
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
        duedate = string;
    }
    public void setDescription(String string){
        todoDescription = string;
    }
    public String getDueDate(){
        return duedate;
    }
    public String getDescription(){
        return todoDescription;
    }


    public Boolean DueDateRegex(String DueDate) {
        if (DueDate.matches("([0-9]{4})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])") || DueDate.isEmpty()) {
            System.out.printf("test\n");
            duedate =DueDate;
            return true;
        } else {
            return false;
        }
    }
    public boolean DescriptionLength(String Description){
        if (Description.length() > 0 && Description.length() < 257)
        {
            System.out.printf("haha xd\n");
            todoDescription = Description;
            return  true;
        }
        else
        {
            return false;
        }
    }
}
