package com.ignateva.dao;

import com.ignateva.DBManager;
import com.ignateva.entity.Company;
import com.ignateva.entity.CompanyResult;
import com.ignateva.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public Company findById(int id) {
        Company company= null;
        String query = "select * from companies where id = (?)";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                company=new Company();
                company.setId(resultSet.getInt(1));
                company.setTaxId(resultSet.getString(2));
                company.setTitle(resultSet.getString(3));
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
    public List<CompanyResult> selectAll(){
        List<CompanyResult> companyList =new ArrayList<>();
        String query = "SELECT * from companies join industries i on i.id = companies.industry_id join ratings r on companies.id = r.company_id";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                    CompanyResult companyResult=new CompanyResult();
                    companyResult.setTitle(resultSet.getString(3));
                    companyResult.setTaxId(resultSet.getString(2));
                    companyResult.setIndustry_risk(resultSet.getInt(8));
                    companyResult.setFinal_score(resultSet.getInt(13));
                    companyResult.setAccounts_date(resultSet.getString(10));
                    companyList.add(companyResult);
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return companyList;
    }


    public CompanyResult selectCompanyResult(String taxId) {
        CompanyResult companyResult = null;
        String query = "SELECT * from companies join industries i on i.id = companies.industry_id join ratings" +
                " r on companies.id = r.company_id where taxId = (?) order by date DESC limit 1";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, taxId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                companyResult=new CompanyResult();
                companyResult.setTitle(resultSet.getString(3));
                companyResult.setTaxId(resultSet.getString(2));
                companyResult.setIndustry_risk(resultSet.getInt(8));
                companyResult.setFinal_score(resultSet.getInt(13));
                companyResult.setAccounts_date(resultSet.getString(10));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return companyResult;
    }

    public List<CompanyResult> selectAllByDate(String date){
        List<CompanyResult> companyList =new ArrayList<>();
        String query = "SELECT * from companies join industries i on i.id = companies.industry_id " +
                "join ratings r on companies.id = r.company_id where date !=(?)";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                CompanyResult companyResult=new CompanyResult();
                companyResult.setTitle(resultSet.getString(3));
                companyResult.setTaxId(resultSet.getString(2));
                companyResult.setIndustry_risk(resultSet.getInt(8));
                companyResult.setFinal_score(resultSet.getInt(13));
                companyResult.setAccounts_date(resultSet.getString(10));
                companyList.add(companyResult);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return companyList;
    }

    public List<CompanyResult> selectByUsers(String login) {
        List<CompanyResult> companyList =new ArrayList<>();
        String query = "SELECT * from companies join industries i on i.id = companies.industry_id join ratings r on companies.id = r.company_id\n" +
                "    join users u on r.user_id = u.id where login =(?)";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                CompanyResult companyResult=new CompanyResult();
                companyResult.setTitle(resultSet.getString(3));
                companyResult.setTaxId(resultSet.getString(2));
                companyResult.setIndustry_risk(resultSet.getInt(8));
                companyResult.setFinal_score(resultSet.getInt(13));
                companyResult.setAccounts_date(resultSet.getString(10));
                companyList.add(companyResult);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return companyList;
    }
}




