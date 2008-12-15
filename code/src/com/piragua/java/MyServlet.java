package com.piragua.java;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        if (username != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedInUser", username);
        }

    }
}
