package com.servlet;

import com.dao.SalaryDao;
import com.dao.SalaryDaoImpl;
import com.model.Salary;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SearchSalaryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SalaryDao Sdao = new SalaryDaoImpl();
        int Pno = 0;
        String Date = null;
        ArrayList<Salary> salarray = new ArrayList<Salary>();
        try {
            Pno = Integer.parseInt(req.getParameter("Pno"));
            Date = req.getParameter("Date");
        } catch (Exception e) {
            e.printStackTrace();
            Date = null;
        }
        if (Pno == 0 && Date.equals("")) {
            RequestDispatcher rd = req.getRequestDispatcher("/Management.do");
            rd.forward(req, resp);
        }
        if (Pno != 0 && Date.equals("")) {
            try {
                salarray = Sdao.findById(Pno);
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.setAttribute("Sarray", salarray);
            RequestDispatcher rd = req.getRequestDispatcher("/showSalary.jsp");
            rd.forward(req, resp);
        }
        if (Pno == 0 && !Date.equals("")) {
            try {
                salarray = Sdao.findByDate(Date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.setAttribute("Sarray", salarray);
            RequestDispatcher rd = req.getRequestDispatcher("/showSalary.jsp");
            rd.forward(req, resp);
        }
        if (Pno != 0 && !Date.equals("")) {
            try {
                Salary salary = Sdao.findByIdAndDate(Pno, Date);
                salarray.add(salary);
            } catch (Exception e) {
                e.printStackTrace();
                RequestDispatcher rd = req.getRequestDispatcher("/Management.do");
                rd.forward(req, resp);
            }
            req.setAttribute("Sarray", salarray);
            RequestDispatcher rd = req.getRequestDispatcher("/showSalary.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
