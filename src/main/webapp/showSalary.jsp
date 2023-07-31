<%@ page import="com.model.Salary" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShowSalary</title>
    <link href="css/show.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main">
    <div class="main-top">
        <div class="main-title">
            工资搜索结果[
            <a href="Management.do">返回</a>
            ]
        </div>
    </div>
    <table class="list">
        <thead>
        <tr>
            <th>员工编号</th>
            <th>基本工资</th>
            <th>岗位津贴</th>
            <th>午餐补贴</th>
            <th>加班工资</th>
            <th>全勤工资</th>
            <th>社保</th>
            <th>公积金</th>
            <th>税</th>
            <th>迟到、请假等</th>
            <th>日期</th>
            <th>实发</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <% ArrayList<Salary> salList = (ArrayList<Salary>) request.getAttribute("Sarray");
            if (salList != null) for (Salary salary : salList) {
        %>
        <tr>
            <td><%=salary.getPno() %>
            </td>
            <td><%=salary.getBasesal() %>
            </td>
            <td><%=salary.getPostallow() %>
            </td>
            <td><%=salary.getLunchsub() %>
            </td>
            <td><%=salary.getOvertimepay() %>
            </td>
            <td><%=salary.getFullattend() %>
            </td>
            <td><%=salary.getSocialsec() %>
            </td>
            <td><%=salary.getAccufund() %>
            </td>
            <td><%=salary.getTax() %>
            </td>
            <td><%=salary.getPunish() %>
            </td>
            <td><%=salary.getDate() %>
            </td>
            <td><%= salary.getPno() + salary.getBasesal() + salary.getPostallow() + salary.getLunchsub() + salary.getOvertimepay() + salary.getFullattend() + salary.getSocialsec() + salary.getAccufund() + salary.getTax() + salary.getPunish()%>
            </td>
            <td><a href="addSalary.do?id=<%= salary.getPno()%>&&date=<%= salary.getDate()%>" methods="get">删除</a></td>
        </tr>
        <%
                }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
