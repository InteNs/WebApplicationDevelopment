package domain.service;

import domain.User;
import persistance.BlogPostDAO;
import domain.BlogPost;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by InteNs on 02.jun.2015.
 */
public class BlogPostService {

    private BlogPostDAO blogPostDAO = new BlogPostDAO();

    public List<BlogPost> getAllBlogPosts() {
        return blogPostDAO.getAllBlogPosts();
    }

    public void addBlogPost(String message, User user,LocalDateTime localDateTime){
        blogPostDAO.addBlogPost(message,user.getUserName(),localDateTime);
    }
}
