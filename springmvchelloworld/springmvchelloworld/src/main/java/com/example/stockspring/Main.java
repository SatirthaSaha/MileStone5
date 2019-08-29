package com.example.stockspring;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.stockspring.model.ImportData;  
public class Main  
{  
	public ImportData importData(String fileName)throws ParseException   
	{  
		System.out.println("inside MAin++++++++++++++++++++++++++");
		ImportData importDate=new ImportData();
		int i=0;
		try  
		{  
			String a="C:\\Users\\Admin\\eclipse-workspace\\Satirtha\\springmvchelloworld\\springmvchelloworld\\src\\main\\webapp\\temp\\"+fileName;
			File file = new File(a);   //creating a new file instance  
			FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			while (itr.hasNext())                 
			{  
				Row row = itr.next();  
				Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
				while (cellIterator.hasNext())   
				{  
					Cell cell = cellIterator.next();  
					switch (cell.getCellType())               
					{  
					case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
						System.out.print(cell.getStringCellValue() + "\t\t\t"); 
						if(i==0)
							importDate.setCompany_name(cell.getStringCellValue());
						if(i==1)
							importDate.setStock_exchange_name(cell.getStringCellValue());
						break;  
					case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
						if (DateUtil.isCellDateFormatted(cell)) {
				            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				            System.out.print(dateFormat.format(cell.getDateCellValue()) + "\t\t");
				            if(i==3)
				            	importDate.setFrom_date(cell.getDateCellValue());
				            if(i==4)
				            	importDate.setTo_date(cell.getDateCellValue());
				        } else {
				            System.out.print((int)cell.getNumericCellValue() + "\t\t");
				            if(i==2)
				            	importDate.setNo_of_records((int)cell.getNumericCellValue());
				        }  
						break;  
					default:  
					}  
					i++;
				}  
				System.out.println("");  
			}  
		}  
		catch(Exception e)  
		{  
			e.printStackTrace();  
		} 
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(sdf.format(importDate.getFrom_date()));
		System.out.println(importDate);
		return importDate;
	}
 
}  