package com.example.stockspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockspring.model.Ipo_planned;

public interface IPODao extends JpaRepository<Ipo_planned, Integer>{

}
