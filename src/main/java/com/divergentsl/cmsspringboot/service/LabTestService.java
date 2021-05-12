package com.divergentsl.cmsspringboot.service;

import java.util.List;

import com.divergentsl.cmsspringboot.entity.LabTest;

public interface LabTestService {

	public void add(String name, int age, int weight);

	public boolean remove(int id);

	public LabTest searchById(int id);
	
	public List<LabTest> listAll();
}
