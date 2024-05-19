package com.ignateva.dao;

import com.ignateva.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class IndustryDao {
private int id;
private int risk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndustryId(float code){
        String query = "select id from industries where code =(?)";

        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setFloat(1,code);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {

                id = resultSet.getInt(1);

            }
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }

        return id;
    }

    public int getIndustryRisk(float code){
        String query = "select risk from industries where code =(?)";

        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setFloat(1,code);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {

                risk = resultSet.getInt(1);

            }
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }

        return risk;
    }


}
