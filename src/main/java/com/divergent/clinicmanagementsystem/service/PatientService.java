package com.divergent.clinicmanagementsystem.service;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Patient;

public interface PatientService {

	public void add(String name, int age, String gender, int weight, String problem);

	public boolean remove(int id);

	public Patient findById(int id);
	
	public List<Patient> listAll();

	
}


