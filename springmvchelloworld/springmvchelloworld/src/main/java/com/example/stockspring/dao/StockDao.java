package com.example.stockspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockspring.model.Stock;


public interface StockDao extends JpaRepository<Stock, Integer>{

	/*public  boolean insertStock(Stock stock) throws SQLException;
	public List<Stock> getAllStock() throws SQLException, Exception;*/
	
}
