package com.ignateva.service;

import com.ignateva.DBManager;
import com.ignateva.dao.UserDao;
import com.ignateva.entity.User;
import com.ignateva.servlet.UserType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {
UserDao userDao=new UserDao();

    public UserType checkUser(String login, String pass){
   return userDao.check(login,pass);

}

    public void createUser(User user){
        userDao.save(user);
    }

    public void deleteUser(String login){
        userDao.delete(login);
    }
    public void updateUser(String login, String pass){
        userDao.update(login,pass);
    }

    public User findUser(String login){

        return userDao.findUserByLogin(login);
    }

    public List<User> getAll() {

        return userDao.selectAll();

    }



}