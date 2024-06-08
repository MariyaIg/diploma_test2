package com.ignateva.dao;

import com.ignateva.DBManager;
import com.ignateva.entity.Industry;

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


    public void insertIndustry(Industry industry) {
        String query = "insert into industries (title, code, risk) values (?,?,?)";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, industry.getTitle());
            preparedStatement.setString(2, industry.getCode());
            preparedStatement.setInt(3, industry.getRisk());

            preparedStatement.execute();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAllIndustries() {
        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete*from industies");) {

            preparedStatement.execute();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public int getIndustryId(String code) {
        String query = "select id from industries where code like ?";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, "%"+code+"_");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                id = resultSet.getInt(1);

            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }

        return id;
    }

    public int getIndustryRisk(String code) {
        String query = "select risk from industries where code like ?)";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, "%"+code+"_");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                risk = resultSet.getInt(1);

            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }

        return risk;
    }

    public int getIndustryRiskById(int company_id) {
        String query = "select risk from industries join companies c on industries.id = c.industry_id where c.id =(?)";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, company_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                risk = resultSet.getInt(1);

            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }

        return risk;
    }

    public void updateIndustryRisk(Industry industry){
        String query = "update industries set risk =? where code = ?";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setInt(1, industry.getRisk());
            preparedStatement.setString(2, industry.getCode());

            preparedStatement.execute();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

}



