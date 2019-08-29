package com.example.stockspring.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {

	@Id
	private int company_code;
	private String boardofdirectors;
	private String company_Name;
	private BigDecimal turnover;
	private String ceo;
	private int sector_id;
	private String breifwriteup;
	private int stock_Code;
	
	public int getCompany_code() {
		return company_code;
	}
	public void setCompany_code(int company_code) {
		this.company_code = company_code;
	}
	public String getCompany_Name() {
		return company_Name;
	}
	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}
	public BigDecimal getTurnover() {
		return turnover;
	}
	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getBoardOfDirectors() {
		return boardofdirectors;
	}
	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardofdirectors = boardOfDirectors;
	}
	
	
	public int getSector_id() {
		return sector_id;
	}
	public void setSector_id(int sector_id) {
		this.sector_id = sector_id;
	}
	public String getBreifwriteup() {
		return breifwriteup;
	}
	public void setBreifwriteup(String breifwriteup) {
		this.breifwriteup = breifwriteup;
	}
	public int getStock_Code() {
		return stock_Code;
	}
	public void setStock_Code(int stock_Code) {
		this.stock_Code = stock_Code;
	}
	
	public Company(int company_code, String boardOfDirectors, String company_Name, BigDecimal turnover, String ceo,
			int sector_id, String breifwriteup, int stock_Code) {
		super();
		this.company_code = company_code;
		this.boardofdirectors = boardOfDirectors;
		this.company_Name = company_Name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.sector_id = sector_id;
		this.breifwriteup = breifwriteup;
		this.stock_Code = stock_Code;
	}
	
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Company [company_code=" + company_code + ", boardOfDirectors=" + boardofdirectors + ", company_Name="
				+ company_Name + ", turnover=" + turnover + ", ceo=" + ceo + ", sector_id=" + sector_id
				+ ", breifwriteup=" + breifwriteup + ", stock_Code=" + stock_Code + "]";
	}
	
	
	
	
}
