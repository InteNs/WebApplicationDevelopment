package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class BlogPost implements Serializable {
    private String  blogPost;
    private final String userName;
    private final String date;
    private final String time;
    private final LocalDate ld;
    private final LocalTime lt;

    public BlogPost(String blogPost, User user) {
        this.blogPost   = blogPost;
        userName        = user.getUserName();
        ld              = LocalDate.now();
        date            = ld.toString();
        lt              = LocalTime.now();
        time            = lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond();
    }

    public void setBlogPost(String blogPost) {
        this.blogPost = blogPost;
    }

    public LocalTime getLt() {
        return lt;
    }

    public LocalDate getLd() {
        return ld;
    }

    public String getBlogPost() {
        return blogPost;
    }

    public String getUserName() {
        return userName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
