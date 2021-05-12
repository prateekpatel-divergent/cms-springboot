package com.divergentsl.cmsspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.divergentsl.cmsspringboot.entity.Drug;

@Repository
public class DrugDaoImpl implements DrugDao{

	@PersistenceContext
	private EntityManager em;

	public void add(Drug drug) {
		em.persist(drug);
	}

	public void remove(Drug drug) {
		em.remove(drug);
	}

	public List<Drug> listAll() {
		TypedQuery<Drug> query = em.createQuery("Select e from Drug e", Drug.class);
		List<Drug> drugs = query.getResultList();
		return drugs;
	}

	public void update(Drug drug) {
		em.persist(drug);
	}

	public Drug searchById(int id) {
		return em.find(Drug.class, id);
	}
}
