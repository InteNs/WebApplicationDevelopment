package domain.service;

import persistance.BlogPostDAO;
import domain.BlogPost;

import java.util.List;

/**
 * Created by InteNs on 02.jun.2015.
 */
public class BlogPostService {

    private BlogPostDAO blogPostDAO = new BlogPostDAO();
    public List<BlogPost> getAllBlogPosts() {
        return blogPostDAO.getAllBlogPosts();
    }
}
