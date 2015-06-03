package domain;

import java.io.Serializable;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


public class BlogPost implements Serializable {
    private String message;
    private User user;
    private final LocalDateTime localDateTime;

    public BlogPost(String message,User user,LocalDateTime localDateTime) {
        this.user = user;
        this.message = message;
        this.localDateTime = localDateTime;
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
}


