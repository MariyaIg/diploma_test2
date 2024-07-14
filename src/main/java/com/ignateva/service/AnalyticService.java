package com.ignateva.service;

import com.ignateva.dao.CompanyDao;
import com.ignateva.entity.Company;
import com.ignateva.entity.CompanyResult;

import java.util.ArrayList;
import java.util.List;

public class AnalyticService {
    List<CompanyResult> companyList;

    public List<CompanyResult> getCompanyList() {
        CompanyDao companyDao= new CompanyDao();

        return companyList = companyDao.selectAll();
    }

    public CompanyResult getCompanyResult(String taxId){
        CompanyDao companyDao= new CompanyDao();
        return companyDao.selectCompanyResult(taxId);
    }
    public List<CompanyResult> getCompanyListOldRating(String date) {
        CompanyDao companyDao= new CompanyDao();

        return companyList = companyDao.selectAllByDate(date);
    }
    public List<CompanyResult> getCompanyListUsersRating(String login) {
        CompanyDao companyDao= new CompanyDao();

        return companyList = companyDao.selectByUsers(login);
    }
}
