package com.divergent.clinicmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergent.clinicmanagementsystem.entity.Drug;
@Repository
public class DrugDaoImpl implements DrugDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(Drug drug) {
		em.persist(drug);		
	}

	@Override
	public List<Drug> listAll() {
		CriteriaQuery<Drug> criteriaQuery = em.getCriteriaBuilder().createQuery(Drug.class);
		@SuppressWarnings("unused")
		Root<Drug> root = criteriaQuery.from(Drug.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void remove(Drug drug) {
		em.remove(drug);
		
	}

	@Override
	public void update(Drug drug) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Drug findById(int id) {
		return em.find(Drug.class, id);
	}

	

}
