/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/AuthenticationServlet"})
public class AuthenticationServlet extends HttpServlet {
   
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // In a real scenario, you would perform proper authentication here.
        // For demonstration purposes, let's assume correct credentials are "admin" and "password".
        if ("admin".equals(username) && "password".equals(password)) {
            response.setStatus(HttpServletResponse.SC_OK); // 200 OK
            
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
             
        }
    }
}

 
