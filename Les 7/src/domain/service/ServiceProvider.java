package domain.service;

/**
 * Created by InteNs on 02.jun.2015.
 */
public class ServiceProvider {
    private static BlogPostService blogPostService = new BlogPostService();

    public static BlogPostService getBlogPostService(){
        return blogPostService;
    }
}
