package com.divergentsl.cmsspringboot.dao;

import java.util.List;

import com.divergentsl.cmsspringboot.entity.Appoinment;



public interface AppoinmentDao {

	void add(Appoinment appoinment);
	
	public List<Appoinment> listAll();

	Appoinment searchById(int id);

	void remove(Appoinment appoinment);
}
