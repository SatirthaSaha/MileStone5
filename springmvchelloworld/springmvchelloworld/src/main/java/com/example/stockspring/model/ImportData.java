package com.example.stockspring.model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportData {

	private String company_name;
	private String stock_exchange_name;
	private int no_of_records;
	private Date from_date;
	private Date to_date;
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getStock_exchange_name() {
		return stock_exchange_name;
	}
	public void setStock_exchange_name(String stock_exchange_name) {
		this.stock_exchange_name = stock_exchange_name;
	}
	public int getNo_of_records() {
		return no_of_records;
	}
	public void setNo_of_records(int no_of_records) {
		this.no_of_records = no_of_records;
	}
	public Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}
	public Date getTo_date() {
		return to_date;
	}
	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}
	public ImportData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImportData(String company_name, String stock_exchange_name, int no_of_records, Date from_date,
			Date to_date) {
		super();
		this.company_name = company_name;
		this.stock_exchange_name = stock_exchange_name;
		this.no_of_records = no_of_records;
		this.from_date = from_date;
		this.to_date = to_date;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return "ImportData [company_name=" + company_name + ", stock_exchange_name=" + stock_exchange_name
				+ ", no_of_records=" + no_of_records + ", from_date=" + sdf.format(from_date)+ ", to_date=" + sdf.format(to_date) + "]";
	}
	
	
}
