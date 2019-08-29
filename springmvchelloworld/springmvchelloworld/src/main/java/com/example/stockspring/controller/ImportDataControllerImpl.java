package com.example.stockspring.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.Main;
import com.example.stockspring.model.FileModel;
import com.example.stockspring.model.ImportData;

@Controller
public class ImportDataControllerImpl implements ImportDataController{

	//------------------Opens Import Data -------------------------------- 
		@Autowired
		   ServletContext context; 
			public String fileName;
			Main main=new Main();

		   @RequestMapping(value = "/importData", method = RequestMethod.GET)
		   public ModelAndView fileUploadPage() {
		      FileModel file = new FileModel();
		      ModelAndView modelAndView = new ModelAndView("fileUpload", "command", file);
		      return modelAndView;
		   }

		   @RequestMapping(value="/uploadExcelFile", method = RequestMethod.POST)
		   public String fileUpload(@Validated FileModel file, BindingResult result, ModelMap model) throws IOException, ParseException {
		      if (result.hasErrors()) {
		         System.out.println("validation errors");
		         return "error";
		      } else {            
		         System.out.println("Fetching file");
		         MultipartFile multipartFile = file.getFile();
		         String uploadPath = context.getRealPath("") + File.separator + "temp" + File.separator;
		         //Now do something with file...
		         FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath+file.getFile().getOriginalFilename()));
		         fileName = multipartFile.getOriginalFilename();
		         model.addAttribute("fileName", fileName);
		         System.out.println("file name :::::::::::::::::::::::::::"+ fileName);
		         ImportData importData=new ImportData();
		         /*importData.setCompany_name(main.importData().getCompany_name());
		         importData.setStock_exchange_name(main.importData().getStock_exchange_name());
		         importData.setNo_of_records(main.importData().getNo_of_records());
		         importData.setFrom_date(main.importData().getFrom_date());
		         importData.setTo_date(main.importData().);    */
		         //importData=main.importData(fileName);
		         importData=main.importData(fileName);
		        System.out.println(importData);
		         model.addAttribute("importData", importData);
		         return "summary";
		      }
}
}
