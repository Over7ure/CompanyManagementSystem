<%@ page import="com.model.Department" %>
<%@ page import="com.model.Person" %>
<%@ page import="com.model.Salary" %>
<%@ page import="com.model.Attendance" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工工资管理</title>
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
            你好，${sessionScope.username}
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
                    <h5>部门管理</h5>
                    <h5>添加或修改部门</h5>
                </div>
            </li>
            <li class="list">
                <h2><i></i>人员相关</h2>
                <div class="hide">
                    <h5>人员管理</h5>
                    <h5>添加或修改人员</h5>
                    <h5>考勤记录</h5>
                    <h5>添加或修改考勤记录</h5>
                </div>
            </li>
            <li class="list">
                <h2><i></i>工资相关</h2>
                <div class="hide">
                    <h5>工资管理</h5>
                    <h5>月工资录入</h5>
                    <h5>历史工资查询</h5>
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
        欢迎使用员工工资管理系统！
    </p>
    <div class="depart" id="management" style="display: none;">
        <div class="main-top">
            <div class="main-title">部门管理</div>
        </div>
        <table class="list">
            <thead>
            <tr>
                <th>部门编号</th>
                <th>部门名</th>
                <th>部门负责人</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <% ArrayList<Department> depList = (ArrayList<Department>) request.getAttribute("Darray");
                if (depList != null) for (Department department : depList) {
            %>
            <tr>
                <td><%=department.getDno() %>
                </td>
                <td><%=department.getName() %>
                </td>
                <td><%=department.getHead() %>
                </td>
                <td><a href="addDepartment.do?content=<%= department.getDno()%>" methods="get">删除</a></td>
            </tr>
            <%
                    }
            %>
            </tbody>
        </table>
    </div>
    <div class="depart" id="addManagement" style="display: none;">
        <div class="main-top">
            <div class="main-title">添加或修改部门</div>
        </div>
        <div class="form">
            <form action="addDepartment.do" method="post">
                <div class="form-body">
                    <div><span class="form-name">部门编号:</span></div>
                    <input type="text" name="Dno"/>
                </div>
                <div class="form-body">
                    <div class="form-name"><span>部门名:</span></div>
                    <input type="text" name="Dname"/>
                </div>
                <div class="form-body">
                    <div><span class="form-name">部门负责人:</span></div>
                    <input type="text" name="Dhead"/>
                </div>
                <div class="form-body">
                    <input type="submit" value="提交" class="btn"/>
                </div>
            </form>
        </div>
    </div>
    <div class="depart" id="person" style="display: none;">
        <div class="main-top">
            <div class="main-title">人员管理</div>
        </div>
        <table class="list">
            <thead>
            <tr>
                <th>员工编号</th>
                <th>员工名</th>
                <th>员工部门编号</th>
                <th>员工电话</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <% ArrayList<Person> perList = (ArrayList<Person>) request.getAttribute("Parray");
                if (perList != null) for (Person person : perList) {
            %>
            <tr>
                <td><%=person.getPno() %>
                </td>
                <td><%=person.getPname() %>
                </td>
                <td><%=person.getDno() %>
                </td>
                <td><%=person.getPtel() %>
                </td>
                <td><a href="addPerson.do?content=<%= person.getPno()%>" methods="get">删除</a></td>
            </tr>
            <%
                    }
            %>
            </tbody>
        </table>
    </div>
    <div class="depart" id="addperson" style="display: none;">
        <div class="main-top">
            <div class="main-title">添加或修改人员</div>
        </div>
        <div class="form">
            <form action="addPerson.do" method="post">
                <div class="form-body">
                    <div><span class="form-name">职工编号:</span></div>
                    <input type="text" name="Pno"/>
                </div>
                <div class="form-body">
                    <div class="form-name"><span>职工名:</span></div>
                    <input type="text" name="Pname"/>
                </div>
                <div class="form-body">
                    <div><span class="form-name">职工部门编号:</span></div>
                    <input type="text" name="Dno"/>
                </div>
                <div class="form-body">
                    <div><span class="form-name">职工电话:</span></div>
                    <input type="text" name="Ptel"/>
                </div>
                <div class="form-body">
                    <input type="submit" value="提交" class="btn"/>
                </div>
            </form>
        </div>
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
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <% ArrayList<Attendance> attList = (ArrayList<Attendance>) request.getAttribute("Aarray");
                if (attList != null) for (Attendance attendance : attList) {
            %>
            <tr>
                <td><%=attendance.getPno() %>
                </td>
                <td><%=attendance.getNeed() %>
                </td>
                <td><%=attendance.getFact() %>
                </td>
                <td><a href="addAttendance.do?content=<%= attendance.getPno()%>" methods="get">删除</a></td>
            </tr>
            <%
                    }
            %>
            </tbody>
        </table>
    </div>
    <div class="depart" id="addattendance" style="display: none;">
        <div class="main-top">
            <div class="main-title">添加或修改考勤记录</div>
        </div>
        <div class="form">
            <form action="addAttendance.do" method="post">
                <div class="form-body">
                    <div><span class="form-name">职工编号:</span></div>
                    <input type="text" name="Pno"/>
                </div>
                <div class="form-body">
                    <div class="form-name"><span>应出勤天数:</span></div>
                    <input type="text" name="Need"/>
                </div>
                <div class="form-body">
                    <div><span class="form-name">实际出勤:</span></div>
                    <input type="text" name="Fact"/>
                </div>
                <div class="form-body">
                    <input type="submit" value="提交" class="btn"/>
                </div>
            </form>
        </div>
    </div>
    <div class="depart" id="salary" style="display: none;">
        <div class="main-top">
            <div class="main-title">工资管理</div>
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
                <td><a href="addSalary.do?id=<%= salary.getPno()%>&&date=<%= salary.getDate()%>" methods="get">删除</a>
                </td>
            </tr>
            <%
                    }
            %>
            </tbody>
        </table>
    </div>
    <div class="depart" id="salaryIn" style="display: none;">
        <div class="main-top">
            <div class="main-title">月工资录入</div>
        </div>
        <div class="form">
            <form action="addSalary.do" method="post">
                <div class="form-body">
                    <div><span class="form-name">职工编号:</span></div>
                    <input type="text" name="Pno"/>
                </div>
                <div class="form-body">
                    <div class="form-name"><span>基本工资:</span></div>
                    <input type="text" name="BaseSal"/>
                </div>
                <div class="form-body">
                    <div><span class="form-name">岗位津贴:</span></div>
                    <input type="text" name="PostAllow"/>
                </div>
                <div class="form-body">
                    <div class="form-name"><span>午餐补贴:</span></div>
                    <input type="text" name="LunchSub"/>
                </div>
                <div class="form-body">
                    <div class="form-name"><span>加班工资:</span></div>
                    <input type="text" name="OvertimePay"/>
                </div>
                <div class="form-body">
                    <div class="form-name"><span>全勤工资:</span></div>
                    <input type="text" name="FullAttend"/>
                </div>
                <div class="form-body">
                    <div class="form-name"><span>社保:</span></div>
                    <input type="text" name="SocialSec"/>
                </div>
                <div class="form-body">
                    <div class="form-name"><span>公积金:</span></div>
                    <input type="text" name="AccuFund"/>
                </div>
                <div class="form-body">
                    <div class="form-name"><span>税:</span></div>
                    <input type="text" name="Tax"/>
                </div>
                <div class="form-body">
                    <div class="form-name"><span>迟到、请假等:</span></div>
                    <input type="text" name="Punish"/>
                </div>
                <div class="form-body">
                    <div class="form-name"><span>日期:</span></div>
                    <input type="text" name="Date"/>
                </div>
                <div class="form-body">
                    <input type="submit" value="提交" class="btn"/>
                </div>
            </form>
        </div>
    </div>
    <div class="depart" id="salaryHistory" style="display: none;">
        <div class="main-top">
            <div class="main-title">历史工资查询</div>
        </div>
        <div class="search">
            <div class="form">
                <form action="searchSalary.do" method="post">
                    <div class="form-body">
                        <div><span class="form-name">职工编号:</span></div>
                        <input type="text" name="Pno"/>
                    </div>
                    <div class="form-body">
                        <div class="form-name"><span>日期:</span></div>
                        <input type="text" name="Date"/>
                    </div>
                    <div class="form-body">
                        <input type="submit" value="查询" class="btn"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
