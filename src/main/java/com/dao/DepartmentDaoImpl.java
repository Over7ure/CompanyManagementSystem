package com.dao;

import com.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public boolean addDepartment(Department department) throws DaoException {
        String sql = "INSERT INTO department VALUE(?,?,?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, department.getDno());
            pstmt.setString(2, department.getName());
            pstmt.setString(3, department.getHead());
            pstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateDepartment(Department department) throws DaoException {
        String sql = "UPDATE department SET Dname=?,Dhead=? WHERE Dno=?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(3, department.getDno());
            pstmt.setString(1, department.getName());
            pstmt.setString(2, department.getHead());
            pstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    @Override
    public void delDepartment(int content) throws DaoException {
        String sql = "DELETE FROM department WHERE Dno=?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, content);
            pstmt.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public Department findById(int id) throws DaoException {
        String sql = "SELECT Dno,Dname,Dhead FROM department WHERE Dno=?";
        Department department = new Department();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {
                    department.setDno(rst.getInt("Dno"));
                    department.setName(rst.getString("Dname"));
                    department.setHead(rst.getString("Dhead"));
                } else {
                    return null;
                }
                conn.close();
            }
        } catch (SQLException se) {
            return null;
        }
        return department;
    }

    @Override
    public ArrayList<Department> findAllDepartment() throws DaoException {
        ArrayList<Department> stuList = new ArrayList<Department>();
        try {
            String sql = "SELECT * FROM department";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                Department department = new Department();
                department.setDno(rst.getInt("Dno"));
                department.setName(rst.getString("Dname"));
                department.setHead(rst.getString("Dhead"));
                stuList.add(department);
            }
            conn.close();
            return stuList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
}
