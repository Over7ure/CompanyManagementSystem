package com.dao;

import com.model.Attendance;

import java.util.ArrayList;

public interface AttendanceDao extends Dao {
    boolean addAttendance(Attendance department) throws DaoException;

    boolean updateAttendance(Attendance department) throws DaoException;

    void delAttendance(int content) throws DaoException;

    Attendance findById(int id) throws DaoException;

    ArrayList<Attendance> findAllAttendance() throws DaoException;
}
