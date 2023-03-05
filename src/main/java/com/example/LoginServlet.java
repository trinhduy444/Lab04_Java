package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private HashMap<String,String> account;

    public boolean isLogin = false;

    public LoginServlet() {
        super();
        this.account = data();
    }
    private HashMap<String,String> data() {
        HashMap<String,String> account = new HashMap<String, String>();
        String[] username = {"admin", "52000655"};
        String[] pass = {"123", "123"};
        for(int i = 0; i < username.length; i++) {
            account.put(username[i], pass[i]);
        }
        return account;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        System.out.println(isValidUser(username,password));
        try {
            if (isValidUser(username, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", username);
                response.sendRedirect("/welcome");
            } else {
                response.getWriter().write("<html><body><p>Account don't match!!!</p></body></html>");
            }
        }catch (Exception error){
            response.getWriter().write("<html><body><p>Account don't match!!!</p></body></html>");
        }



    }
    protected boolean isValidUser(String username, String password){
        if (account.get(username) == null){
            return false;
        }
        if(account.get(username).equals(password)){
            isLogin = true;
            return true;
        }
        else{ return false;}

    }
}