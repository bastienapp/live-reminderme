package fr.wildcodeschool.myreminder;

public class ReminderModel {

    private String reminder;
    private String createDate;

    public ReminderModel() {

    }

    public ReminderModel(String reminder, String createDate) {

        this.reminder = reminder;
        this.createDate = createDate;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
