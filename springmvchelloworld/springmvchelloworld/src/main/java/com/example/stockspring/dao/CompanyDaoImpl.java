package com.example.stockspring.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.stockspring.model.Company;
import com.example.stockspring.model.Sector;
/*
@Repository
public class CompanyDaoImpl implements CompanyDao{

	public boolean insertCompany(Company company) throws SQLException  {
		System.out.println("inside dao");
		boolean flag=false;
		try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/satirtha","root","pass@word1");
		PreparedStatement ps=conn.prepareStatement("insert into company (company_Code,company_Name, turnover, ceo, boardofdirectors, sector_id, breifwriteup, stock_Code) values(?,?,?,?,?,?,?,?)");
		ps.setInt(1, company.getCompany_code());
		ps.setString(2, company.getCompany_Name());
		ps.setDouble(3, company.getTurnover());
		ps.setString(4, company.getCeo());
		ps.setString(5, company.getBoardOfDirectors());
		System.out.println(company.getSector_id());
		ps.setInt(6, company.getSector_id());
		ps.setString(7, company.getBreifwriteup());
		ps.setInt(8, company.getStock_Code());
		int rs=	ps.executeUpdate();
		System.out.println(rs);
		flag=true;
		}catch(SQLException sql)
		{
			flag=false;
		}
		return flag;
		
	}

	
	public List<Company> getCompanyList() throws SQLException{
		System.out.println("inside list dao");
		List <Company> companyList=new ArrayList<Company>();
		try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/satirtha","root","pass@word1");
		PreparedStatement ps=conn.prepareStatement("select * from company");
		ResultSet rs=	ps.executeQuery();
		
		Company company=null;
		while(rs.next()){
			 company=new Company();
			company.setCompany_code(rs.getInt("company_code"));
			company.setCompany_Name(rs.getString("company_Name"));
			company.setTurnover(rs.getDouble("turnover"));
			company.setCeo(rs.getString("ceo"));
			company.setBoardOfDirectors(rs.getString("boardOfDirectors"));
			company.setSector_id(rs.getInt("sector_id"));
			company.setBreifwriteup(rs.getString("breifwriteup"));
			company.setStock_Code(rs.getInt("stock_Code"));
			
			companyList.add(company);
		}
		}catch(SQLException e)
		{
			System.out.println(e);
			throw e;
		}
		return companyList;
	}

	
	
	
	
	
	
	@Override
	public boolean updateCompany(Company company) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag=true;
		try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/satirtha","root","pass@word1");
		PreparedStatement ps=conn.prepareStatement("update company set turnover=?, ceo=?, boardofdirectors=?, sector_id=?, breifwriteup=?, stock_Code=? where company_Code=?");
		ps.setDouble(1, company.getTurnover());
		ps.setString(2, company.getCeo());
		ps.setString(3, company.getBoardOfDirectors());
		ps.setInt(4, company.getSector_id());
		ps.setString(5, company.getBreifwriteup());
		ps.setInt(6, company.getStock_Code());
		ps.setInt(7, company.getCompany_code());
		boolean rs=ps.execute();
		flag=true;
		}
		catch(SQLException sql)
		{
			sql.printStackTrace();
			flag=false;
		}
		return flag;
		
	}
	
	public static void main(String []args) throws Exception{
		CompanyDaoImpl dao=new CompanyDaoImpl();
		//Company compnay=new Company();
		//compnay.setCompanyId(1001);
		//dao.insertCompany(compnay);
		
		System.out.println(dao.getCompanyList());
	}


	
	public List<Sector> getSectorList() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("inside list dao =========================for sector");
		List <Sector> sectorList=new ArrayList<Sector>();
		try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/satirtha","root","pass@word1");
		PreparedStatement ps=conn.prepareStatement("select * from sectors");
		ResultSet rs=	ps.executeQuery();
		
		Sector sector=null;
		while(rs.next()){
			sector=new Sector();
			sector.setId(rs.getInt("id"));
			sector.setSector_name(rs.getString("sector_name"));
			sector.setBrief(rs.getString("brief"));			
			sectorList.add(sector);
		}
		}catch(SQLException e)
		{
			System.out.println("cannot fetch sector");
			System.out.println(e);
			throw e;
		}
		return sectorList;
	}

}
*/