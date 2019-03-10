package com.SJBProject.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SJBProject.SjbProjectApplication;
import com.SJBProject.model.Books;
import com.SJBProject.service.SJBService;

@Controller
public class MainController {
	
	private static final Logger log = LogManager.getLogger(SjbProjectApplication.class);
	
	@Autowired
	private SJBService sjbService;
	
	@GetMapping(value="/")
	public String init(HttpServletRequest request) {
		log.debug("MainController init");
		request.setAttribute("books", sjbService.findAllBooks());
		request.setAttribute("mode", "book_view");
		return "index";
	}
	
	@GetMapping(value="/updateBook")
	public String updateBook(@RequestParam long id,HttpServletRequest request) {
		log.debug("updateBook init");
		request.setAttribute("book", sjbService.findBook(id));
		request.setAttribute("mode", "book_update");
		return "index";
	}
	
	
	@PostMapping("/save")
	public void saveBook(@ModelAttribute Books books,BindingResult bindingResult
			,HttpServletRequest request,HttpServletResponse response) throws  IOException{
		
		log.debug(books.getPurchaseDate());
		sjbService.saveBooks(books);
		request.setAttribute("books", sjbService.findAllBooks());
		request.setAttribute("mode", "book_view");
		response.sendRedirect("/");
	}
	
}
