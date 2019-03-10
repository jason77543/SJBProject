package com.SJBProject.restController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SJBProject.model.Books;
import com.SJBProject.service.SJBService;

@RestController
public class MainRestController {
	
	@Autowired
	private SJBService sjbService;
	
	
	@GetMapping(value="/findAllBooks")
	public Collection<Books> getAllBooks(){
		return sjbService.findAllBooks();
	}
	
	@GetMapping(value="/deleteBook")
	public void deleteBook(@RequestParam long id) {
		sjbService.deleteBook(id);
	}
}
