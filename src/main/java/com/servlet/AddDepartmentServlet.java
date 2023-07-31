package com.servlet;

import com.dao.DepartmentDao;
import com.dao.DepartmentDaoImpl;
import com.model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AddDepartmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentDao Ddao = new DepartmentDaoImpl();
        Department department = new Department();
        String message = null;
        boolean success = false;
        try {
            department.setDno(Integer.parseInt(req.getParameter("Dno")));
            department.setName(new String(req.getParameter("Dname").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
            department.setHead(new String(req.getParameter("Dhead").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
            Department temp = null;
            temp = Ddao.findById(department.getDno());
            if (temp == null) {
                success = Ddao.addDepartment(department);
            } else {
                success = Ddao.updateDepartment(department);
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
        DepartmentDao Ddao = new DepartmentDaoImpl();
        int content = Integer.parseInt(req.getParameter("content"));
        try {
            Ddao.delDepartment(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = req.getRequestDispatcher("/Management.do");
        rd.forward(req, resp);
    }
}
