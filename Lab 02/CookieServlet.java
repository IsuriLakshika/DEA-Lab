/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/CookieServlet"})
public class CookieServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        
        // If visitCount is null, it means it's the user's first visit
        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }
        
        // Store the visitCount in session attribute
        session.setAttribute("visitCount", visitCount);
        
        // Set cookie named "visit_count" with the same value
        Cookie visitCountCookie = new Cookie("visit_count", visitCount.toString());
        response.addCookie(visitCountCookie);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Visit Counter</title></head>");
        out.println("<body>");
        out.println("<h2>Visit Counter</h2>");
        out.println("<p>Number of visits: " + visitCount + "</p>");
        out.println("</body></html>");
    }
}
   