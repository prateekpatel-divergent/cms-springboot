package com.divergentsl.cmsspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.cmsspringboot.dao.DrugDao;
import com.divergentsl.cmsspringboot.entity.Drug;


@Service
public class DrugServiceImpl implements DrugService{
	
	@Autowired
	private DrugDao drugDao;

	@Transactional
	public void add(String name, int rate) {	
		
		Drug drug = new Drug();
		drug.setName(name);
		drug.setRate(rate);
		drugDao.add(drug);
		
	}

	@Transactional
	public boolean remove(int id) {
		Drug drug = this.searchById(id);
		if (drug != null) {
			this.drugDao.remove(drug);
			return true;
		}
		return false;
	}

	@Transactional
	public Drug searchById(int id) {
		return drugDao.searchById(id);
	}

	@Transactional
	public List<Drug> list() {
		return this.drugDao.listAll();
	}
}
