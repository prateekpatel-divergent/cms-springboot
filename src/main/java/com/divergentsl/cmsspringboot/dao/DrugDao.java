package com.divergentsl.cmsspringboot.dao;

import java.util.List;

import com.divergentsl.cmsspringboot.entity.Drug;

public interface DrugDao {

	void add(Drug drug);

	public List<Drug> listAll();
	
	void remove(Drug drug);
	
	void update(Drug drug);

	Drug searchById(int id);
}
