package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean validAttempt =
                (username.length()>0 && email.length()>0 && password.length()>0);

        if (validAttempt) {
            long nuID=-1;
            User user = new User();
            try {
                Users users = DaoFactory.getUsersDao();
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
                nuID=users.insert(user);
                user.setId(nuID);
            } catch (Exception e){
                System.out.println(e);
            }
            if(nuID != -1) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/profile");
            }
        } else {
            response.sendRedirect("/register");
        }
    }
}
