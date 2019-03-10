package com.SJBProject.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SJBProject.model.Books;
import com.SJBProject.repository.SJBRepository;

@Service
public class SJBService {
	
	@Autowired
	private SJBRepository sjbRepository;
	
	public Collection<Books> findAllBooks(){
		List<Books> books = new ArrayList<Books>();
		for(Books book:sjbRepository.findAll()) {
			books.add(book);
		}
		return books;
	}
	
	public void deleteBook(long id) {
		sjbRepository.deleteById(id);
	}
	
	public Books findBook(long id) {
		return sjbRepository.findById(id).get();
	}
	
	public void saveBooks(Books books) {
		sjbRepository.save(books);
	}
}
