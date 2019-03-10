package com.SJBProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SJBProject.model.Books;

@Repository
public interface SJBRepository extends CrudRepository<Books, Long>{

}
