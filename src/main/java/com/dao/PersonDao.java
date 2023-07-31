package com.dao;

import com.model.Person;

import java.util.ArrayList;

public interface PersonDao extends Dao {
    boolean addPerson(Person person) throws DaoException;

    boolean updatePerson(Person person) throws DaoException;

    void delPerson(int content) throws DaoException;

    Person findById(int id) throws DaoException;

    ArrayList<Person> findAllPerson() throws DaoException;
}
