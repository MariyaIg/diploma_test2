package com.ignateva.dao;

import com.ignateva.DBManager;
import com.ignateva.entity.CompanyResult;
import com.ignateva.entity.User;
import com.ignateva.servlet.UserType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDao {
    public UserDao() {
    }

    public void save (User user) {

        String query ="insert into users (name, login, password) values (?,?,?)";
        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getLogin());
            preparedStatement.setString(3,user.getPass());
            preparedStatement.execute();
        }
        catch(
                    SQLException e){
                throw new RuntimeException(e);
            }
        }

    public void delete (String login){
        String query ="delete from users where login = (?)";
        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setString(1,login);
            preparedStatement.execute();
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }
    }
    public User findUserByLogin(String login){
        User user = new User();

        String query ="select* from users where login = (?)";
        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setString(1,login);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLogin(resultSet.getString(3));
                user.setPass(resultSet.getString(4));
            }
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }
        return user;
    }

    public void update(String login, String pass){
        String query ="update users set password = (?) where login = (?)";
        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setString(1,pass);
            preparedStatement.setString(2,login);
            preparedStatement.execute();
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }
    }
    public UserType check (String login,String pass){
        UserType userType = UserType.GUEST;

        String query_find = "select password from users where login =(?)";

        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query_find);){
            preparedStatement.setString(1,login);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {

                String pass1 = resultSet.getString(1);
                if (Objects.equals(pass, pass1)&& !Objects.equals(pass, "admin"))
                    userType = UserType.USER;
                else if (Objects.equals(pass, pass1)&& Objects.equals(pass, "admin")) {
                    userType = UserType.ADMIN;
                }
            }
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }
        return userType;
    }

    public List<User> selectAll(){
        List<User> users =new ArrayList<>();
        String query = "SELECT * from users";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

               User user=new User();
                user.setName(resultSet.getString(2));
                user.setLogin(resultSet.getString(3));

                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

}
