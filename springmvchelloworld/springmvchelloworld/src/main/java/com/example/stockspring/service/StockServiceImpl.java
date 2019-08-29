package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockspring.dao.StockDao;
import com.example.stockspring.model.Stock;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockDao stockDao;

	
	public boolean insertStock(Stock stock) throws SQLException {
		// TODO Auto-generated method stub
		//return stockDao.insertStock(stock);
		if(stockDao.save(stock)!=null)
		{
			System.out.println("inside stock service"+stock);
			return true;
		}
		else
			return false;
	}

	

	
	public List<Stock> getAllStock() throws SQLException, Exception {
		// TODO Auto-generated method stub
		System.out.println();
		return stockDao.findAll();
	}

}
