package com.divergentsl.cmsspringboot.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.divergentsl.cmsspringboot.entity.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@PersistenceContext
	private EntityManager em;

	public void add(Patient patient) {
		em.persist(patient);
	}

	public void remove(Patient patient) {
		em.remove(patient);

	}

	public List<Patient> listAll() {
		TypedQuery<Patient> query = em.createQuery("Select e from Patient e", Patient.class);
		List<Patient> patients = query.getResultList();
		return patients;
	}

	public void update(Patient patient) {
		em.persist(patient);
	}

	public Patient searchById(int id) {
		return em.find(Patient.class, id);
	}

}
