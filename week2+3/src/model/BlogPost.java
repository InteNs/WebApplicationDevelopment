package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BlogPost {
    private String blogPost;
    private String info;

    public BlogPost(String blogPost, User user) {
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        this.blogPost = blogPost;
        // Username + date + time caption
        info = user.getUserName()+" heeft het volgende gepost op "+ ld.toString()+" om "+ lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond()+"<br/><br/>";
    }

    public void setBlogPost(String blogPost) {
        this.blogPost = blogPost;
    }

    @Override
    public String toString() {
        return "<div style=\"border: 1px solid black;\">"+info+blogPost+"<br/><br/></div>";
    }
}
