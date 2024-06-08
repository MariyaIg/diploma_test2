package com.ignateva.dao;

import com.ignateva.DBManager;
import com.ignateva.entity.Accounts;
import com.ignateva.entity.Accounts_template;
import com.ignateva.entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountsDao {


    public void save (Accounts accounts) {

        String query ="insert into accounts (date, company_id, sales, operating_profit," +
                " net_profit, current_assets, current_liabilities, equity, st_debt, " +
                "lt_debt, tbs) values (?,?,?,?,?,?,?,?,?,?,?)";

        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setString(1,accounts.getDate());
            preparedStatement.setInt(2,accounts.getCompany_id());
            preparedStatement.setLong(3,accounts.getSales());
            preparedStatement.setLong(4,accounts.getOperating_profit());
            preparedStatement.setLong(5,accounts.getNet_profit());
            preparedStatement.setLong(6,accounts.getCurrent_assets());
            preparedStatement.setLong(7,accounts.getCurrent_liabilities());
            preparedStatement.setLong(8,accounts.getEquity());
            preparedStatement.setLong(9,accounts.getSt_debt());
            preparedStatement.setLong(10,accounts.getLt_debt());
            preparedStatement.setLong(11,accounts.getTbs());
            preparedStatement.execute();
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void save_temp (Accounts_template accounts_template) {

        String query ="insert into accounts_template (date, company_id, sales, sales_2, operating_profit," +
                " net_profit, current_assets, current_liabilities, equity, st_debt, " +
                "lt_debt, tbs) values (?,?,?,?,?,?,?,?,?,?,?,?)";

        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setString(1,accounts_template.getDate());
            preparedStatement.setInt(2,accounts_template.getCompany_id());
            preparedStatement.setLong(3,accounts_template.getSales());
            preparedStatement.setLong(4,accounts_template.getSales_2());
            preparedStatement.setLong(5,accounts_template.getOperating_profit());
            preparedStatement.setLong(6,accounts_template.getNet_profit());
            preparedStatement.setLong(7,accounts_template.getCurrent_assets());
            preparedStatement.setLong(8,accounts_template.getCurrent_liabilities());
            preparedStatement.setLong(9,accounts_template.getEquity());
            preparedStatement.setLong(10,accounts_template.getSt_debt());
            preparedStatement.setLong(11,accounts_template.getLt_debt());
            preparedStatement.setLong(12,accounts_template.getTbs());
            preparedStatement.execute();
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Accounts_template selectTemplate(){
        Accounts_template accounts_template=new Accounts_template();
        String query = "select*from accounts_template";
        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                accounts_template.setId(resultSet.getInt(1));
                accounts_template.setDate(resultSet.getString(2));
                accounts_template.setCompany_id(resultSet.getInt(3));
                accounts_template.setSales(resultSet.getLong(4));
                accounts_template.setSales_2(resultSet.getLong(5));
                accounts_template.setOperating_profit(resultSet.getLong(6));
                accounts_template.setNet_profit(resultSet.getLong(7));
                accounts_template.setCurrent_assets(resultSet.getLong(8));
                accounts_template.setCurrent_liabilities(resultSet.getLong(9));
                accounts_template.setEquity(resultSet.getLong(10));
                accounts_template.setSt_debt(resultSet.getLong(11));
                accounts_template.setLt_debt(resultSet.getLong(12));
                accounts_template.setTbs(resultSet.getLong(13));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accounts_template;
    }
    public void save_2(){

    }

    public Accounts findByDate(String date, String taxId){
        Accounts accounts = null;
        String query = "select*from accounts join public.companies c on c.id = accounts.company_id where date= (?)" +
                "  and taxId =(?)";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, taxId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                accounts =new Accounts();
                accounts.setId(resultSet.getInt(1));
                accounts.setDate(resultSet.getString(2));
                accounts.setCompany_id(resultSet.getInt(3));
                accounts.setSales(resultSet.getLong(4));
                accounts.setOperating_profit(resultSet.getLong(5));
                accounts.setNet_profit(resultSet.getLong(6));
                accounts.setCurrent_assets(resultSet.getLong(7));
                accounts.setCurrent_liabilities(resultSet.getLong(8));
                accounts.setEquity(resultSet.getLong(9));
                accounts.setSt_debt(resultSet.getLong(10));
                accounts.setLt_debt(resultSet.getLong(11));
                accounts.setTbs(resultSet.getLong(12));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

    public void update1 (Accounts accounts) {
        String query = "update accounts set sales = (?) ,operating_profit =(?), " +
                "net_profit= (?), current_assets= (?), current_liabilities= (?), equity= (?), " +
                "st_debt= (?), lt_debt= (?), tbs= (?) where company_id = (?) and date = (?);";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setLong(1, accounts.getSales());
            preparedStatement.setLong(2, accounts.getOperating_profit());
            preparedStatement.setLong(3, accounts.getNet_profit());
            preparedStatement.setLong(4, accounts.getCurrent_assets());
            preparedStatement.setLong(5, accounts.getCurrent_liabilities());
            preparedStatement.setLong(6, accounts.getEquity());
            preparedStatement.setLong(7, accounts.getSt_debt());
            preparedStatement.setLong(8, accounts.getLt_debt());
            preparedStatement.setLong(9, accounts.getTbs());
            preparedStatement.setLong(10, accounts.getCompany_id());
            preparedStatement.setString(11, accounts.getDate());
            preparedStatement.execute();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update2(Accounts accounts2){
        String query = "update accounts set sales = (?) where company_id = (?) and date = (?)";

        try (Connection connection = DBManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setLong(1, accounts2.getSales());
            preparedStatement.setInt(2, accounts2.getCompany_id());
            preparedStatement.setString(3, accounts2.getDate());
            preparedStatement.execute();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public void delete (int id){
        String query ="delete from accounts where id = (?)";
        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void deleteTemplate (int company_id){
        String query ="delete from accounts_template where company_id = (?)";
        try(Connection connection = DBManager.createConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(query);){
            preparedStatement.setInt(1,company_id);
            preparedStatement.execute();
        }
        catch(
                SQLException e){
            throw new RuntimeException(e);
        }
    }


}


