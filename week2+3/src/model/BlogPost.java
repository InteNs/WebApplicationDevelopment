package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class BlogPost implements Serializable {
    private String  blogPost,userName,date,time;
    private LocalDate ld = LocalDate.now();
    private LocalTime lt = LocalTime.now();

    public BlogPost(String blogPost, User user) {
        this.blogPost   = blogPost;
        userName        = user.getUserName();
        date            = ld.toString();
        time            = lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond();
    }

    public void setBlogPost(String blogPost) {
        this.blogPost = blogPost;
    }

    @Override
    public String toString() {
        return  "<div class=\"blogPostPanelBox\">" +
                "<div class=\"blogPost\">" +
                "<div><h4>Blogbericht:</h4></div>" +
                blogPost +
                "<div class=\"blogPostFooter\">" +
                "Geschreven door: " +
                userName + "." +
                "<br/>" +
                "Geposted op: " +
                date + " om " + time + ".<br/>" +
                "</div>" +
                "</div>" +
                "</div>";
    }
}
