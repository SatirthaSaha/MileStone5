package com.example.stockspring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sectors")
public class Sector {

	@Id
	private int id;
	private String sector_name;
	private String brief;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSector_name() {
		return sector_name;
	}
	public void setSector_name(String sector_name) {
		this.sector_name = sector_name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public Sector(int id, String sector_name, String brief) {
		super();
		this.id = id;
		this.sector_name = sector_name;
		this.brief = brief;
	}
	public Sector() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
