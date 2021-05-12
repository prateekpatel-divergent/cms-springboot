package com.divergentsl.cmsspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.cmsspringboot.dao.AppoinmentDao;
import com.divergentsl.cmsspringboot.entity.Appoinment;


@Service
public class AppoinmentServiceImpl implements AppoinmentService{

	@Autowired
	private AppoinmentDao appoinmentDao;
	
	@Autowired
	private AppoinmentService AppoinmentService;
	
	@Transactional
	public void add(String name, String problem, String appoinmentDate, String currentDate ,int AppoinmentId){	
	
		Appoinment appoinment = new Appoinment();
		
		appoinment.setPname(name);
		appoinment.setProblem(problem);
		appoinment.setAppoinmentDate(appoinmentDate);
		appoinment.setCurrentDate(currentDate);
//		appoinment.setAppoinment(AppoinmentService.searchById(AppoinmentId));
		appoinmentDao.add(appoinment);
	}

	@Transactional
	public List<Appoinment> list() {
		return this.appoinmentDao.listAll();
	}

	@Transactional
	public Appoinment searchById(int id) {
		return appoinmentDao.searchById(id);
	}

	public boolean remove(int id) {
		Appoinment appoinment = this.searchById(id);
		if (appoinment != null) {
			this.appoinmentDao.remove(appoinment);
			return true;
		}
		return false;
	}
}
