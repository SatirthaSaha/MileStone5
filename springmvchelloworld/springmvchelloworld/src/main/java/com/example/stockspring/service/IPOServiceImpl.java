package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockspring.dao.IPODao;
import com.example.stockspring.model.Ipo_planned;

@Service
public class IPOServiceImpl implements IPOService{

	@Autowired
	private IPODao ipoDao;
	
	@Override
	public boolean registerIPO(Ipo_planned ipo_planned) throws SQLException {
		// TODO Auto-generated method stub
		if(ipoDao.save(ipo_planned)!=null)
			return true;
		else
			return false;
	}

	@Override
	public List<Ipo_planned> getIPOList() {
		// TODO Auto-generated method stub
		return ipoDao.findAll();
	}

}
