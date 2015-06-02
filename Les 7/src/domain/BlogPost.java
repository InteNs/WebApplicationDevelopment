package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class BlogPost implements Serializable {
    private int ID;
    private String message;
    private final LocalDate ld;
    private final LocalTime lt;

    public BlogPost(String message, int ID) {
        this.ID = ID;
        this.message = message;
        ld = LocalDate.now();;
        lt = LocalTime.now();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalTime getLt() {
        return lt;
    }

    public LocalDate getLd() {
        return ld;
    }

    public String getMessage() {
        return message;
    }
}


