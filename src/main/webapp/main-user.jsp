<%@ page import="com.model.Department" %>
<%@ page import="com.model.Person" %>
<%@ page import="com.model.Salary" %>
<%@ page import="com.model.Attendance" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人工资查询</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <script>
        window.onload = function () {
            let lis = document.querySelectorAll(" .list h5");
            let divs = document.querySelectorAll(".main .depart");
            let ps = document.querySelectorAll(".main p");
            for (let i = 0; i < lis.length; i++) {
                lis[i].addEventListener('click', function () {
                    ps[0].style = "display:none;";
                    for (let j = 0; j < lis.length; j++) {
                        lis[j].className = '';
                        divs[j].style = "display:none;";
                        this.className = 'hover';
                        divs[i].style = "display:block;";
                    }
                });
            }
        }
    </script>
</head>
<body>
<div class="top">
    <div class="title">
        <div class="text">
            员工工资管理系统
        </div>
    </div>
    <div class="user">
        <div class="username">
            <% Person per = (Person) request.getAttribute("Person");
                if (per != null) {
            %>
            你好，<%=per.getPname() %>
            <%
                }
            %>
        </div>
        <div class="logout">
            [
            <a href="login.jsp">退出登录</a>
            ]
        </div>
    </div>
</div>
<div class="wrap">
    <div class="header">导航</div>
    <div class="nav">
        <ul>
            <li class="list">
                <h2><i></i>部门相关</h2>
                <div class="hide">
                    <h5>我的部门</h5>
                </div>
            </li>
            <li class="list">
                <h2><i></i>人员相关</h2>
                <div class="hide">
                    <h5>个人信息</h5>
                    <h5>考勤记录</h5>
                </div>
            </li>
            <li class="list">
                <h2><i></i>工资相关</h2>
                <div class="hide">
                    <h5>工资查询</h5>
                </div>
            </li>
        </ul>
    </div>
</div>
<script>
    (function () {
        var oList = document.querySelectorAll('.list h2'),
            oHide = document.querySelectorAll('.hide'),
            oIcon = document.querySelectorAll('.list i'),
            lastIndex = 0;
        for (var i = 0; i < oList.length; i++) {
            oList[i].index = i;//自定义属性
            oList[i].isClick = false;
            oList[i].initHeight = oHide[i].clientHeight;
            oHide[i].style.height = '0';
            oList[i].onclick = function () {
                if (this.isClick) {
                    oHide[this.index].style.height = '0';
                    oIcon[this.index].className = '';
                    oList[this.index].className = '';
                    oList[this.index].isClick = false;
                } else {
                    oHide[lastIndex].style.height = '0';
                    oIcon[lastIndex].className = '';
                    oList[lastIndex].className = '';
                    oHide[this.index].style.height = '150px';
                    oIcon[this.index].className = 'on';
                    oList[this.index].className = 'on';
                    oList[lastIndex].isClick = false;
                    oList[this.index].isClick = true;
                    lastIndex = this.index;
                }
            }
        }
    })();
</script>
<div class="main">
    <p class="welcome">
        欢迎使用个人工资查询系统！
    </p>
    <div class="depart" id="management" style="display: none;">
        <div class="main-top">
            <div class="main-title">我的部门</div>
        </div>
        <table class="list">
            <thead>
            <tr>
                <th>部门编号</th>
                <th>部门名</th>
                <th>部门负责人</th>
            </tr>
            </thead>
            <tbody>
            <% Department dep = (Department) request.getAttribute("Depart");
                if (dep != null) {
            %>
            <tr>
                <td><%=dep.getDno() %>
                </td>
                <td><%=dep.getName() %>
                </td>
                <td><%=dep.getHead() %>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

    <div class="depart" id="person" style="display: none;">
        <div class="main-top">
            <div class="main-title">个人信息</div>
        </div>
        <table class="list">
            <thead>
            <tr>
                <th>员工编号</th>
                <th>员工名</th>
                <th>员工部门编号</th>
                <th>员工电话</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (per != null) {
            %>
            <tr>
                <td><%=per.getPno() %>
                </td>
                <td><%=per.getPname() %>
                </td>
                <td><%=per.getDno() %>
                </td>
                <td><%=per.getPtel() %>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <div class="depart" id="attendance" style="display: none;">
        <div class="main-top">
            <div class="main-title">考勤记录</div>
        </div>
        <table class="list">
            <thead>
            <tr>
                <th>员工编号</th>
                <th>应出勤天数</th>
                <th>实际出勤</th>
            </tr>
            </thead>
            <tbody>
            <% Attendance att = (Attendance) request.getAttribute("Attend");
                if (att != null) {
            %>
            <tr>
                <td><%=att.getPno() %>
                </td>
                <td><%=att.getNeed() %>
                </td>
                <td><%=att.getFact() %>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <div class="depart" id="salary" style="display: none;">
        <div class="main-top">
            <div class="main-title">工资查询</div>
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
            </tr>
            <%
                    }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
