package com.dao;

import com.model.Salary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDaoImpl implements SalaryDao {
    @Override
    public boolean addSalary(Salary salary) throws DaoException {
        String sql = "INSERT INTO salary VALUE(?,?,?,?,?,?,?,?,?,?,?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, salary.getPno());
            pstmt.setDouble(2, salary.getBasesal());
            pstmt.setDouble(3, salary.getPostallow());
            pstmt.setDouble(4, salary.getLunchsub());
            pstmt.setDouble(5, salary.getOvertimepay());
            pstmt.setDouble(6, salary.getFullattend());
            pstmt.setDouble(7, salary.getSocialsec());
            pstmt.setDouble(8, salary.getAccufund());
            pstmt.setDouble(9, salary.getTax());
            pstmt.setDouble(10, salary.getPunish());
            pstmt.setString(11, salary.getDate());
            pstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSalary(Salary salary) throws DaoException {
        String sql = "UPDATE department SET BaseSal=?,PostAllow=?,LunchSub=?,OvertimePay=?,FullAttend=?,SocialSec=?,AccuFund=?,Tax=?,Punish=?,Date=? WHERE Pno=?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(11, salary.getPno());
            pstmt.setDouble(1, salary.getBasesal());
            pstmt.setDouble(2, salary.getPostallow());
            pstmt.setDouble(3, salary.getLunchsub());
            pstmt.setDouble(4, salary.getOvertimepay());
            pstmt.setDouble(5, salary.getFullattend());
            pstmt.setDouble(6, salary.getSocialsec());
            pstmt.setDouble(7, salary.getAccufund());
            pstmt.setDouble(8, salary.getTax());
            pstmt.setDouble(9, salary.getPunish());
            pstmt.setString(10, salary.getDate());
            pstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    @Override
    public void delSalary(int id, String date) throws DaoException {
        String sql = "DELETE FROM salary WHERE Pno=? AND Date=?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, date);
            pstmt.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public ArrayList<Salary> findById(int id) throws DaoException {
        String sql = "SELECT Pno,BaseSal,PostAllow,LunchSub,OvertimePay,FullAttend,SocialSec,AccuFund,Tax,Punish,Date FROM salary WHERE Pno=?";
        ArrayList<Salary> salList = new ArrayList<Salary>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Salary salary = new Salary();
                    salary.setPno(rst.getInt("Pno"));
                    salary.setBasesal(rst.getDouble("BaseSal"));
                    salary.setPostallow(rst.getDouble("PostAllow"));
                    salary.setLunchsub(rst.getDouble("LunchSub"));
                    salary.setOvertimepay(rst.getDouble("OvertimePay"));
                    salary.setFullattend(rst.getDouble("FullAttend"));
                    salary.setSocialsec(rst.getDouble("SocialSec"));
                    salary.setAccufund(rst.getDouble("AccuFund"));
                    salary.setTax(rst.getDouble("Tax"));
                    salary.setPunish(rst.getDouble("Punish"));
                    salary.setDate(rst.getString("Date"));
                    salList.add(salary);
                }
                conn.close();
                return salList;
            }
        } catch (SQLException se) {
            return null;
        }
    }

    @Override
    public ArrayList<Salary> findByDate(String date) throws DaoException {
        String sql = "SELECT Pno,BaseSal,PostAllow,LunchSub,OvertimePay,FullAttend,SocialSec,AccuFund,Tax,Punish,Date FROM salary WHERE Date=?";
        ArrayList<Salary> salList = new ArrayList<Salary>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, date);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Salary salary = new Salary();
                    salary.setPno(rst.getInt("Pno"));
                    salary.setBasesal(rst.getDouble("BaseSal"));
                    salary.setPostallow(rst.getDouble("PostAllow"));
                    salary.setLunchsub(rst.getDouble("LunchSub"));
                    salary.setOvertimepay(rst.getDouble("OvertimePay"));
                    salary.setFullattend(rst.getDouble("FullAttend"));
                    salary.setSocialsec(rst.getDouble("SocialSec"));
                    salary.setAccufund(rst.getDouble("AccuFund"));
                    salary.setTax(rst.getDouble("Tax"));
                    salary.setPunish(rst.getDouble("Punish"));
                    salary.setDate(rst.getString("Date"));
                    salList.add(salary);
                }
                conn.close();
                return salList;
            }
        } catch (SQLException se) {
            return null;
        }
    }

    @Override
    public Salary findByIdAndDate(int id, String date) throws DaoException {
        String sql = "SELECT Pno,BaseSal,PostAllow,LunchSub,OvertimePay,FullAttend,SocialSec,AccuFund,Tax,Punish,Date FROM salary WHERE Pno=? AND Date=?";
        Salary salary = new Salary();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, date);
            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {
                    salary.setPno(rst.getInt("Pno"));
                    salary.setBasesal(rst.getDouble("BaseSal"));
                    salary.setPostallow(rst.getDouble("PostAllow"));
                    salary.setLunchsub(rst.getDouble("LunchSub"));
                    salary.setOvertimepay(rst.getDouble("OvertimePay"));
                    salary.setFullattend(rst.getDouble("FullAttend"));
                    salary.setSocialsec(rst.getDouble("SocialSec"));
                    salary.setAccufund(rst.getDouble("AccuFund"));
                    salary.setTax(rst.getDouble("Tax"));
                    salary.setPunish(rst.getDouble("Punish"));
                    salary.setDate(rst.getString("Date"));
                } else {
                    return null;
                }
                conn.close();
            }
        } catch (SQLException se) {
            return null;
        }
        return salary;
    }
}
