package com.servlet;

import com.dao.AttendanceDao;
import com.dao.AttendanceDaoImpl;
import com.model.Attendance;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAttendanceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AttendanceDao Adao = new AttendanceDaoImpl();
        Attendance attendance = new Attendance();
        String message = null;
        boolean success = false;
        try {
            attendance.setPno(Integer.parseInt(req.getParameter("Pno")));
            attendance.setNeed(Integer.parseInt(req.getParameter("Need")));
            attendance.setFact(Integer.parseInt(req.getParameter("Fact")));
            Attendance temp = null;
            temp = Adao.findById(attendance.getPno());
            if (temp == null) {
                success = Adao.addAttendance(attendance);
            } else {
                success = Adao.updateAttendance(attendance);
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
        AttendanceDao Adao = new AttendanceDaoImpl();
        int content = Integer.parseInt(req.getParameter("content"));
        try {
            Adao.delAttendance(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = req.getRequestDispatcher("/Management.do");
        rd.forward(req, resp);
    }
}
