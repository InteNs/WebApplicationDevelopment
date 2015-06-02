package filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {
                                    /* Filter is being placed into service, do nothing. */
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;

        if(httpServletRequest.getSession().getAttribute("loggedInUser") == null) {
            httpServletRequest.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else{
            chain.doFilter(req, resp);
        }
    }
    public void destroy() {
                                    /* Filter is being taken out of service, do nothing. */
    }
}