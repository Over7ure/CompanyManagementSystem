<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main">
    <div class="login">
        <form action="login.do" method="post">
            <fieldset>
                <table>
                    <tr>
                        <td>用户名：</td>
                        <td><input type="text" id="username" name="username" placeholder="Username"/></td>
                    </tr>
                    <tr>
                        <td>密 码：</td>
                        <td><input type="password" id="password" name="password" placeholder="Password"/></td>
                    </tr>
                    <tr>
                        <td>身 份：</td>
                        <td>
                            <select size="1" id="identity" name="identity">
                                <option value="1" selected="selected">员工</option>
                                <option value="2">管理员</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <input class="btn" type="submit" value="登录"/><input class="btn" type="reset" value="取消"/>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>