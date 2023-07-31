package com.dao;

import com.model.Attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceDaoImpl implements AttendanceDao {
    @Override
    public boolean addAttendance(Attendance attendance) throws DaoException {
        String sql = "INSERT INTO attendance VALUE(?,?,?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, attendance.getPno());
            pstmt.setInt(2, attendance.getNeed());
            pstmt.setInt(3, attendance.getFact());
            pstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAttendance(Attendance attendance) throws DaoException {
        String sql = "UPDATE attendance SET Need=?,Fact=? WHERE Pno=?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(3, attendance.getPno());
            pstmt.setInt(1, attendance.getNeed());
            pstmt.setInt(2, attendance.getFact());
            pstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    @Override
    public void delAttendance(int content) throws DaoException {
        String sql = "DELETE FROM attendance WHERE Pno=?";
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
    public Attendance findById(int id) throws DaoException {
        String sql = "SELECT Pno,Need,Fact FROM attendance WHERE Pno=?";
        Attendance department = new Attendance();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {
                    department.setPno(rst.getInt("Pno"));
                    department.setNeed(rst.getInt("Need"));
                    department.setFact(rst.getInt("Fact"));
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
    public ArrayList<Attendance> findAllAttendance() throws DaoException {
        ArrayList<Attendance> addList = new ArrayList<Attendance>();
        try {
            String sql = "SELECT * FROM attendance";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                Attendance attendance = new Attendance();
                attendance.setPno(rst.getInt("Pno"));
                attendance.setNeed(rst.getInt("Need"));
                attendance.setFact(rst.getInt("Fact"));
                addList.add(attendance);
            }
            conn.close();
            return addList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
}
