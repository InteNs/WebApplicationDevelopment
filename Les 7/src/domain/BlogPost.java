package domain;

import java.io.Serializable;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


public class BlogPost implements Serializable {
    private String message;
    private User user;
    private final LocalDateTime localDateTime;
    private final Timestamp timeStamp;

    public BlogPost(String message,User user,LocalDateTime localDateTime) {
        this.user = user;
        this.message = message;
        this.localDateTime = localDateTime;
        this.timeStamp = Timestamp.valueOf(localDateTime);
    }
    public User getUser() {
        return user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
    public String getMessage() {
        return message;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }
}


