package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Dao {
    default Connection getConnection() throws DaoException {
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String dburl = "jdbc:mysql://127.0.0.1:3306/webstore?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String username = "root";
        String password = "w170113522";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dburl, username, password);
        } catch (SQLException | ClassNotFoundException sqle) {
            System.out.println("异常: " + sqle);
        }
        return conn;
    }
}
