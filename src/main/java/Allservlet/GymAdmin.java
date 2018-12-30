/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shravan
 */
public class GymAdmin implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public GymAdmin() {
    }    
    

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        PrintWriter out=response.getWriter();
        HttpServletRequest req=(HttpServletRequest)request;
       // String requi=req.getRequestURI().substring(req.getContextPath().length()+1);
         HttpServletResponse res=(HttpServletResponse)response;
         //req.setAttribute("gym","gym");
         RequestDispatcher rd=req.getRequestDispatcher("/RedirectServlet");
         rd.forward(request, response);
    }

   public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
                 }
        }
    


