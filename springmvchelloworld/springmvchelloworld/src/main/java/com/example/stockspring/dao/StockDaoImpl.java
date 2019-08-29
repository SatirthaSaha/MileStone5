package com.example.stockspring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.stockspring.model.Stock;
/*
@Repository
public class StockDaoImpl implements StockDao{

	@Override
	public boolean insertStock(Stock stock) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/satirtha","root","pass@word1");
		System.out.println("=============================");
		PreparedStatement ps=conn.prepareStatement("insert into stockexchange(stockExchange_name, brief, contactaddress, remarks) values(?,?,?,?)");
		//ps.setInt(1, stock.getStockexchange_id());
		ps.setString(1, stock.getStockExchange_name());
		ps.setString(2, stock.getBrief());
		ps.setString(3, stock.getContactaddress());
		ps.setString(4, stock.getRemarks());
		boolean rs=	ps.execute();
		flag=true;
		}catch(SQLException sql)
		{
			flag=false;
		}
		return flag;
	}
	

	@Override
	public List<Stock> getAllStock() throws SQLException, Exception {
		// TODO Auto-generated method stub
		List <Stock> stockList=new ArrayList<Stock>();
		try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/satirtha","root","pass@word1");
		PreparedStatement ps=conn.prepareStatement("select * from stockexchange");
		ResultSet rs=	ps.executeQuery();
		
		Stock stock=null;
		while(rs.next()){
			stock=new Stock();
			stock.setStockexchange_id(rs.getInt("stockexchange_id"));
			stock.setStockExchange_name(rs.getString("stockExchange_name"));
			stock.setBrief(rs.getString("brief"));
			stock.setContactaddress(rs.getString("contactaddress"));
			stock.setRemarks(rs.getString("remarks"));
			stockList.add(stock);
		}
		}catch(SQLException e)
		{
			System.out.println(e);
			throw e;
		}
		return stockList;
		
	}
	
	public static void main(String []args) throws Exception{
		StockDao dao=new StockDaoImpl();
		Stock stock=new Stock();
		stock.setStockExchange_name("TATA");
		stock.setBrief("def");
		stock.setContactaddress("Mumbai");
		stock.setRemarks("Good");
		//System.out.println(dao.insertStock(stock));
		if(dao.insertStock(stock))
		{
			System.out.println("Successfull insertion");
		}
		else
			System.out.println("Not inserted");
		System.out.println(dao.getAllStock());
	}

}
*/