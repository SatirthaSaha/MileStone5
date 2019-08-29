package com.example.stockspring;
import java.io.*;

import javax.servlet.ServletContext;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.stockspring.model.Company;

import org.jfree.chart.ChartUtilities;

public class BarChart {
	
	@Autowired
	ServletContext context;
   
   public void getBar(Company c1, Company c2 )throws Exception {
      final String c1name = c1.getCompany_Name();
      final String c2name = c2.getCompany_Name();
      final String turnover = "Turnover";
      final String stock = "Stock";
      
      System.out.println("Inse Bar Chart+++++++++++++++++++++++++++++++++++");
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      dataset.addValue( c1.getTurnover() , c1name , turnover );
      dataset.addValue( c1.getStock_Code() , c1name , stock );
      

      dataset.addValue( c2.getTurnover() , c2name , turnover );
      dataset.addValue( c2.getStock_Code() , c2name , stock );
      

      

      JFreeChart barChart = ChartFactory.createBarChart(
         "COMPARE COMPANIES", 
         "Category", "Score", 
         dataset,PlotOrientation.VERTICAL, 
         true, true, false);
         
      int width = 640;    /* Width of the image */
      int height = 480;   /* Height of the image */ 
      File BarChart = new File("src/main/webapp/images/BarChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
   }
}