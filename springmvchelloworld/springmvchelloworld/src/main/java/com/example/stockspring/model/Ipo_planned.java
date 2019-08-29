package com.example.stockspring.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ipo_planned")
public class Ipo_planned {

	@Id
	private int id;
	private int Company_code;
	private int Stock_exchange;
	private BigDecimal price_per_share;
	private int total_no_of_shares;
	private Date open_date_time;
	private String remarks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompany_code() {
		return Company_code;
	}
	public void setCompany_code(int company_code) {
		Company_code = company_code;
	}
	public int getStock_exchange() {
		return Stock_exchange;
	}
	public void setStock_exchange(int stock_exchange) {
		Stock_exchange = stock_exchange;
	}
	public BigDecimal getPrice_per_share() {
		return price_per_share;
	}
	public void setPrice_per_share(BigDecimal price_per_share) {
		this.price_per_share = price_per_share;
	}
	public int getTotal_no_of_shares() {
		return total_no_of_shares;
	}
	public void setTotal_no_of_shares(int total_no_of_shares) {
		this.total_no_of_shares = total_no_of_shares;
	}
	public Date getOpen_date_time() {
		return open_date_time;
	}
	public void setOpen_date_time(Date open_date_time) {
		this.open_date_time = open_date_time;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Ipo_planned(int id, int company_code, int stock_exchange, BigDecimal price_per_share, int total_no_of_shares,
			Date open_date_time, String remarks) {
		super();
		this.id = id;
		Company_code = company_code;
		Stock_exchange = stock_exchange;
		this.price_per_share = price_per_share;
		this.total_no_of_shares = total_no_of_shares;
		this.open_date_time = open_date_time;
		this.remarks = remarks;
	}
	public Ipo_planned() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ipo_planned [id=" + id + ", Company_code=" + Company_code + ", Stock_exchange=" + Stock_exchange
				+ ", price_per_share=" + price_per_share + ", total_no_of_shares=" + total_no_of_shares
				+ ", open_date_time=" + open_date_time + ", remarks=" + remarks + "]";
	}
	
}
