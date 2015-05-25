package model;

public class BlogPost {
    private String blogPost;

    public BlogPost(String blogPost) {
        this.blogPost = blogPost;
    }

    public void setBlogPost(String blogPost) {
        this.blogPost = blogPost;
    }

    @Override
    public String toString() {
        return blogPost;
    }
}
