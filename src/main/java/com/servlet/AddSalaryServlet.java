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
import java.nio.charset.StandardCharsets;

public class AddSalaryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SalaryDao Sdao = new SalaryDaoImpl();
        Salary salary = new Salary();
        String message = null;
        boolean success = false;
        try {
            salary.setPno(Integer.parseInt(req.getParameter("Pno")));
            salary.setBasesal(Double.parseDouble(req.getParameter("BaseSal")));
            salary.setPostallow(Double.parseDouble(req.getParameter("PostAllow")));
            salary.setLunchsub(Double.parseDouble(req.getParameter("LunchSub")));
            salary.setOvertimepay(Double.parseDouble(req.getParameter("OvertimePay")));
            salary.setFullattend(Double.parseDouble(req.getParameter("FullAttend")));
            salary.setSocialsec(Double.parseDouble(req.getParameter("SocialSec")));
            salary.setAccufund(Double.parseDouble(req.getParameter("AccuFund")));
            salary.setTax(Double.parseDouble(req.getParameter("Tax")));
            salary.setPunish(Double.parseDouble(req.getParameter("Punish")));
            salary.setDate(new String(req.getParameter("Date").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
            Salary temp = null;
            temp = Sdao.findByIdAndDate(salary.getPno(), salary.getDate());
            if (temp == null) {
                success = Sdao.addSalary(salary);
            } else {
                success = Sdao.updateSalary(salary);
            }
            if (success) {
                message = "<li>成功插入一条记录!</li>";
            } else {
                message = "<li>插入记录错误!</li>";
            }
        } catch (Exception e) {
            System.out.println(e);
            message = "<li>插入记录错误!</li>";
        }
        req.setAttribute("result", message);
        RequestDispatcher rd = req.getRequestDispatcher("/Management.do");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SalaryDao Sdao = new SalaryDaoImpl();
        int id = Integer.parseInt(req.getParameter("id"));
        String date = req.getParameter("date");
        try {
            Sdao.delSalary(id, date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = req.getRequestDispatcher("/Management.do");
        rd.forward(req, resp);
    }
}
