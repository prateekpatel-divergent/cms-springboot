package com.divergentsl.cmsspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.cmsspringboot.dao.DoctorDao;
import com.divergentsl.cmsspringboot.entity.Doctor;


@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorDao doctorDao;
	
	@Transactional
	public void add(String name, String speciality, String contactno, int fee, String degree) {
		Doctor doctor = new Doctor();

		doctor.setName(name);
		doctor.setSpeciality(speciality);
		doctor.setContactno(contactno);
		doctor.setFee(fee);
		doctor.setDegree(degree);
		
		doctorDao.add(doctor);
	}

	@Transactional
	public boolean remove(int id) {
		Doctor doctor = this.searchById(id);
		if (doctor != null) {
			this.doctorDao.remove(doctor);
			return true;
		}
		return false;
	}

	@Transactional
	public Doctor searchById(int id) {
		return doctorDao.searchById(id);
	}

	@Transactional
	public List<Doctor> listAll() {
		return this.doctorDao.listAll();
	}

	public void update(String name, String speciality, String contactno, int fee, String degree) {
		Doctor doctor = new Doctor();

		doctor.setName(name);
		doctor.setSpeciality(speciality);
		doctor.setContactno(contactno);
		doctor.setFee(fee);
		doctor.setDegree(degree);
		
		doctorDao.update(doctor);
	}

}
