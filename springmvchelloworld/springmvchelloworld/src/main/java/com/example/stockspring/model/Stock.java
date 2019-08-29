package com.example.stockspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="stockexchange")
public class Stock {

	@Id@NotNull
	private int stockexchange_id; 
	@Column(name="stockexchange_name")
	private String stockExchange_name; 
	private String brief;
	private String contactaddress;
	private String remarks;
	public int getStockexchange_id() {
		return stockexchange_id;
	}
	public void setStockexchange_id(int stockexchange_id) {
		this.stockexchange_id = stockexchange_id;
	}
	
	public String getStockExchange_name() {
		return stockExchange_name;
	}
	public void setStockExchange_name(String stockExchange_name) {
		this.stockExchange_name = stockExchange_name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContactaddress() {
		return contactaddress;
	}
	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Stock(@NotNull int stockexchange_id, String stockExchange_name, String brief, String contactaddress,
			String remarks) {
		super();
		this.stockexchange_id = stockexchange_id;
		this.stockExchange_name = stockExchange_name;
		this.brief = brief;
		this.contactaddress = contactaddress;
		this.remarks = remarks;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString()
	{
		return "id:" + this.getStockexchange_id()+" stockExchange name:"+this.getStockExchange_name()+ "brief: "+this.getBrief()+"Contact Address: "+this.getContactaddress()+"Remarks: "+this.getRemarks();
	}
}
