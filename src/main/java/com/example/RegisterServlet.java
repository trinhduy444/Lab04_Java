package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String birthtime = request.getParameter("birthtime");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String[] ides = request.getParameterValues("favorite_ide[]");
        String toeic = request.getParameter("toeic");
        String message = request.getParameter("message");

        RequestDispatcher rd = null;

        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("birthday", birthday);
        request.setAttribute("birthtime", birthtime);
        request.setAttribute("gender", gender);
        request.setAttribute("country", country);
        request.setAttribute("ides", ides);
        request.setAttribute("toeic", toeic);
        request.setAttribute("message", message);
        rd = request.getRequestDispatcher("profile.jsp");

        rd.forward(request, response);
    }

}
