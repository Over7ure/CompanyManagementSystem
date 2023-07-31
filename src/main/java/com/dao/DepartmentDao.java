package com.dao;

import com.model.Department;

import java.util.ArrayList;

public interface DepartmentDao extends Dao {
    boolean addDepartment(Department department) throws DaoException;

    boolean updateDepartment(Department department) throws DaoException;

    void delDepartment(int content) throws DaoException;

    Department findById(int id) throws DaoException;

    ArrayList<Department> findAllDepartment() throws DaoException;
}
