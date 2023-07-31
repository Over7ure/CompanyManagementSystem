package com.servlet;

import com.dao.*;
import com.model.Attendance;
import com.model.Department;
import com.model.Person;
import com.model.Salary;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentDao Ddao = new DepartmentDaoImpl();
        PersonDao Pdao = new PersonDaoImpl();
        SalaryDao Sdao = new SalaryDaoImpl();
        AttendanceDao Adao = new AttendanceDaoImpl();
        Department dep = null;
        Person per = null;
        ArrayList<Salary> salList = null;
        Attendance att = null;
        try {
            dep = Ddao.findById(Integer.parseInt((String) req.getSession().getAttribute("userNo")));
            per = Pdao.findById(Integer.parseInt((String) req.getSession().getAttribute("userNo")));
            salList = Sdao.findById(Integer.parseInt((String) req.getSession().getAttribute("userNo")));
            att = Adao.findById(Integer.parseInt((String) req.getSession().getAttribute("userNo")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("Depart", dep);
        req.setAttribute("Person", per);
        req.setAttribute("Sarray", salList);
        req.setAttribute("Attend", att);
        RequestDispatcher rd = req.getRequestDispatcher("/main-user.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
