package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import com.example.stockspring.model.Company;
import com.example.stockspring.model.Sector;

public interface CompanyService {

	
	 public boolean insertCompany(Company company) throws SQLException;
	    public Company editCompany(int company_code) throws SQLException;
		
		public List<Sector> getSectorList() throws SQLException;
		
		public List<Company> getCompanyList() throws SQLException;
		public Company getCompanyDetails(int company_code);
		public void delete(int company_code);
		public void updateCompany(@Valid Company company);

}
