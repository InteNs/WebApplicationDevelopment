package domain.service;

public class ServiceProvider {
    private static BlogPostService blogPostService = new BlogPostService();
    private static UserService userService = new UserService();
    private static ValidateService validateService = new ValidateService();
    private static EmailService emailService = new EmailService();
    //TODO fix service provider error when email service is initialized

    public static BlogPostService getBlogPostService(){
        return blogPostService;
    }
    public static UserService getUserService(){
        return userService;
    }
    public static ValidateService getValidateService(){ return validateService; }
    public static EmailService getEmailService() {
        return emailService;
    }
}
