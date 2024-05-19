package com.ignateva.dao;

import com.ignateva.DBManager;
import com.ignateva.entity.Company;
import com.ignateva.entity.User;

import java.sql.*;

public class CompanyDao {


    public void save (Company company) {


        String query ="insert into companies (title, taxId, industry_id) values (?,?,?)";
        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setString(1,company.getTitle());
            preparedStatement.setString(2,company.getTaxId());
            preparedStatement.setInt(3,company.getIndustry_id());
            preparedStatement.execute();
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Company findByTaxId(String tax) {
        Company company= null;
        String query = "select * from companies where taxId = (?)";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, tax);
            ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    company=new Company();
                    company.setId(resultSet.getInt(1));
                    company.setTitle(resultSet.getString(2));
                    company.setTaxId(resultSet.getString(3));
                    company.setIndustry_id(resultSet.getInt(4));

                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return company;
    }
    public void DeleteCompany(String taxId){
        String query ="delete from companies where taxId = (?)";
        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setString(1,taxId);
            preparedStatement.execute();
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }
    }


}




