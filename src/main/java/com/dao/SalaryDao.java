package com.dao;

import com.model.Salary;

import java.util.ArrayList;

public interface SalaryDao extends Dao {
    boolean addSalary(Salary department) throws DaoException;

    boolean updateSalary(Salary department) throws DaoException;

    void delSalary(int id, String date) throws DaoException;

    ArrayList<Salary> findById(int id) throws DaoException;

    ArrayList<Salary> findByDate(String date) throws DaoException;

    Salary findByIdAndDate(int id, String date) throws DaoException;
}
