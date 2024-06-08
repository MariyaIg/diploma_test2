package com.ignateva.dao;

import com.ignateva.DBManager;
import com.ignateva.entity.Rating;

import java.sql.*;

public class RatingDao {

    public void saveRating (Rating rating){
        String query ="insert into ratings (date, company_id, financial_score, total_score, user_id, calculation_date) values (?,?,?,?,?,?)";
        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setString(1,rating.getDate());
            preparedStatement.setInt(2,rating.getCompany_id());
            preparedStatement.setInt(3,rating.getFinancial_score());
            preparedStatement.setInt(4,rating.getTotal_score());
            preparedStatement.setInt(5,rating.getUser_id());
            preparedStatement.setDate(6,rating.getCalculation_date());
            preparedStatement.execute();
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void updateRating (Rating rating){
        String query ="update ratings set financial_score = (?), total_score = (?), user_id= (?), calculation_date =(?) where company_id= (?) and date =(?)";
        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setInt(1,rating.getFinancial_score());
            preparedStatement.setInt(2,rating.getTotal_score());
            preparedStatement.setInt(3,rating.getUser_id());
            preparedStatement.setDate(4,rating.getCalculation_date());
            preparedStatement.setInt(5,rating.getCompany_id());
            preparedStatement.setString(6,rating.getDate());
            preparedStatement.execute();
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Rating find (int company_id, String date) {
        Rating rating= null;
        String query = "select * from ratings where company_id = (?) and date =(?)";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, company_id);
            preparedStatement.setString(2, date);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                rating=new Rating();
                rating.setId(resultSet.getInt(1));
                rating.setDate(resultSet.getString(2));
                rating.setCompany_id(resultSet.getInt(3));
                rating.setFinancial_score(resultSet.getInt(4));
                rating.setTotal_score(resultSet.getInt(5));
                rating.setUser_id(resultSet.getInt(6));
               rating.setCalculation_date(resultSet.getDate(7));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rating;
    }

}
