package com.divergent.clinicmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.divergent.clinicmanagementsystem.entity.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(Patient patient) {
		em.persist(patient);
	}

	@Override
	public void remove(Patient patient) {
		em.remove(patient);

	}

	@Override
	public Patient findById(int id) {
		return em.find(Patient.class, id);
	}

	@Override
	public void update(Patient patient) {
		em.persist(patient);
	}

	@Override
	public List<Patient> listAll() {
		CriteriaQuery<Patient> criteriaQuery = em.getCriteriaBuilder().createQuery(Patient.class);
		@SuppressWarnings("unused")
		Root<Patient> root = criteriaQuery.from(Patient.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

}
