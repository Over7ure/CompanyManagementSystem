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

public class ManagementServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentDao Ddao = new DepartmentDaoImpl();
        PersonDao Pdao = new PersonDaoImpl();
        SalaryDao Sdao = new SalaryDaoImpl();
        AttendanceDao Adao = new AttendanceDaoImpl();
        ArrayList<Department> depList = null;
        ArrayList<Person> perList = null;
        ArrayList<Salary> salList = null;
        ArrayList<Attendance> attList = null;
        try {
            depList = Ddao.findAllDepartment();
            perList = Pdao.findAllPerson();
            salList = Sdao.findByDate("201901");
            attList = Adao.findAllAttendance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("Darray", depList);
        req.setAttribute("Parray", perList);
        req.setAttribute("Sarray", salList);
        req.setAttribute("Aarray", attList);
        RequestDispatcher rd = req.getRequestDispatcher("/main-admin.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
