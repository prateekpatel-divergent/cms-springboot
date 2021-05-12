package com.divergentsl.cmsspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.divergentsl.cmsspringboot.entity.LabTest;

@Repository
public class LabTestDaoImpl implements LabTestDao {

	@PersistenceContext
	private EntityManager em;

	public void add(LabTest labTest) {
		em.persist(labTest);
	}

	public void remove(LabTest labTest) {
		em.remove(labTest);
	}

	public List<LabTest> listAll() {
		TypedQuery<LabTest> query = em.createQuery("Select e from LabTest e", LabTest.class);
		List<LabTest> labTests = query.getResultList();
		return labTests;
	}

	public void update(LabTest labTest) {
		em.persist(labTest);
	}

	public LabTest searchById(int id) {
		return em.find(LabTest.class, id);
	}
}
