package com.spring.ifpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ifpb.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

	Livro findById(Long id);
//	void deleteById(long id);
	
}
