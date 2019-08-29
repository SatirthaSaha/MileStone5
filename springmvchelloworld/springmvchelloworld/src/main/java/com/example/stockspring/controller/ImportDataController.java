package com.example.stockspring.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.FileModel;

public interface ImportDataController {
	public ModelAndView fileUploadPage();
	public String fileUpload(@Validated FileModel file, BindingResult result, ModelMap model) throws IOException, ParseException;
}
