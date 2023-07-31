package com.servlet;

import com.dao.PersonDao;
import com.dao.PersonDaoImpl;
import com.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AddPersonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonDao Pdao = new PersonDaoImpl();
        Person person = new Person();
        String message = null;
        boolean success = false;
        try {
            person.setPno(Integer.parseInt(req.getParameter("Pno")));
            person.setPname(new String(req.getParameter("Pname").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
            person.setDno(Integer.parseInt(req.getParameter("Dno")));
            person.setPtel(new String(req.getParameter("Ptel").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
            Person temp = null;
            temp = Pdao.findById(person.getPno());
            if (temp == null) {
                success = Pdao.addPerson(person);
            } else {
                success = Pdao.updatePerson(person);
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
        PersonDao Pdao = new PersonDaoImpl();
        int content = Integer.parseInt(req.getParameter("content"));
        try {
            Pdao.delPerson(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = req.getRequestDispatcher("/Management.do");
        rd.forward(req, resp);
    }
}
