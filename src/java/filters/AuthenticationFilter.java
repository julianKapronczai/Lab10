
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JRKap
 */
@WebFilter(filterName = "AuthenticationFilter", servletNames = {"NoteServlet", "AdminServlet"})
public class AuthenticationFilter implements Filter {

    

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        
       String email = (String)session.getAttribute("email");
       
       if(email == null){
           HttpServletResponse httpresponse = (HttpServletResponse)response;
           httpresponse.sendRedirect("login");
           return; 
       }
         chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    


}