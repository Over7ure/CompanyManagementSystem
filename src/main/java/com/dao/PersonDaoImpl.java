package com.dao;

import com.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDaoImpl implements PersonDao {
    @Override
    public boolean addPerson(Person person) throws DaoException {
        String sql = "INSERT INTO person VALUE(?,?,?,?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person.getPno());
            pstmt.setString(2, person.getPname());
            pstmt.setInt(3, person.getDno());
            pstmt.setString(4, person.getPtel());
            pstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatePerson(Person person) throws DaoException {
        String sql = "UPDATE department SET Pname=?,Dno=?,Ptel=? WHERE Pno=?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(4, person.getDno());
            pstmt.setString(1, person.getPname());
            pstmt.setInt(2, person.getDno());
            pstmt.setString(3, person.getPtel());
            pstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    @Override
    public void delPerson(int content) throws DaoException {
        String sql = "DELETE FROM person WHERE Pno=?";
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
    public Person findById(int id) throws DaoException {
        String sql = "SELECT Pno,Pname,Dno,Ptel FROM person WHERE Pno=?";
        Person person = new Person();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {
                    person.setPno(rst.getInt("Pno"));
                    person.setPname(rst.getString("Pname"));
                    person.setDno(rst.getInt("Dno"));
                    person.setPtel(rst.getString("Ptel"));
                } else {
                    return null;
                }
                conn.close();
            }
        } catch (SQLException se) {
            return null;
        }
        return person;
    }

    @Override
    public ArrayList<Person> findAllPerson() throws DaoException {
        ArrayList<Person> perList = new ArrayList<Person>();
        try {
            String sql = "SELECT * FROM person";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next()) {
                Person person = new Person();
                person.setPno(rst.getInt("Pno"));
                person.setPname(rst.getString("Pname"));
                person.setDno(rst.getInt("Dno"));
                person.setPtel(rst.getString("Ptel"));
                perList.add(person);
            }
            conn.close();
            return perList;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        }
    }
}
