package com.example.stockspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockspring.model.Sector;

public interface SectorDao extends JpaRepository<Sector, Integer>{

}
