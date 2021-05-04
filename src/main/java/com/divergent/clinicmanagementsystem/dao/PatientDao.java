package com.divergent.clinicmanagementsystem.dao;

import java.util.List;
import com.divergent.clinicmanagementsystem.entity.Patient;

public interface PatientDao {

	public void add(Patient patient);

	public void remove(Patient patient);

	Patient findById(int id);

	void update(Patient patient);

	public List<Patient> listAll();
}
