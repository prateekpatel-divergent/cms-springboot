package com.divergentsl.cmsspringboot.dao;

import java.util.List;

import com.divergentsl.cmsspringboot.entity.Patient;

public interface PatientDao {
	
	void add(Patient patient);

	public List<Patient> listAll();
	
	void remove(Patient patient);
	
	void update(Patient patient);

	Patient searchById(int id);
}
