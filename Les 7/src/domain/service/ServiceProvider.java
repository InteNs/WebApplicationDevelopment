package domain.service;

public class ServiceProvider {
    private static BlogPostService blogPostService = new BlogPostService();
    private static UserService userService = new UserService();

    public static BlogPostService getBlogPostService(){
        return blogPostService;
    }
    public static UserService getUserService(){
        return userService;
    }
}
