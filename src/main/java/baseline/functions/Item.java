package baseline.functions;

public class Item {
    String duedate;
    String todo;
    String[] putin = new String[2];
    boolean complete;

    private void turnComplete(){
        complete = true;
    }

    private void turnIncomplete(){
        complete = false;
    }
    public String TheDueDate(){
        return putin[1];
    }
    public String TheDescription(){
        return putin[0];
    }


    public Boolean DueDateRegex(String DueDate) {
        if (DueDate.matches("((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])") || DueDate.isEmpty()) {
            System.out.printf("test\n");
            putin[1] =DueDate;
            return true;
        } else {
            return false;
        }
    }
    public boolean DescriptionLength(String Description){
        if (Description.length() > 0 && Description.length() < 257)
        {
            System.out.printf("haha xd\n");
            putin[0] = Description;
            return  true;
        }
        else
        {
            return false;
        }
    }
}
