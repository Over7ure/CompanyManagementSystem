package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = null;
        String password = null;
        String[] identity = null;
        try {
            username = req.getParameter("username");
            password = req.getParameter("password");
            identity = req.getParameterValues("identity");
        } catch (Exception e) {
            e.printStackTrace();
            username = null;
            password = null;
            identity = null;
        }
        if (identity != null && identity[0].equals("1")) {
            if (username != null && password != null) {
                req.getSession().setAttribute("userNo", username);
                RequestDispatcher rd = req.getRequestDispatcher("/User.do");
                rd.forward(req, resp);
            }
        } else if (identity != null && identity[0].equals("2")) {
            if (username != null && username.equals("admin") && password != null && password.equals("admin")) {
                req.getSession().setAttribute("username", username);
                RequestDispatcher rd = req.getRequestDispatcher("/Management.do");
                rd.forward(req, resp);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
                rd.forward(req, resp);
            }
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, resp);
        }
    }
}