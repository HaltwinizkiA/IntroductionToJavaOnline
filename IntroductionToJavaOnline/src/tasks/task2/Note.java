package tasks.task2;

import java.text.SimpleDateFormat;

public class Note {
    Long date;
    String email="";
    String theme="";
    String message="";

    public Long getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getTheme() {
        return theme;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return date+"/"+email+"/"+theme+"/"+message;
    }
    public String toString(int a) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return " Date of creation: "+simpleDateFormat.format(date)+" Email: "+email+"\n"+" Theme: "+theme+"\n Message: "+message;
    }
    public Note(Long date, String email, String theme, String message) {
        this.date = date;
        this.email = email;
        this.theme = theme;
        this.message = message;
    }
}
