package com.divergent.clinicmanagementsystem.service;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Doctor;

public interface DoctorService {

	void add(String name, String speciality, int fee);

	boolean remove(int id);

	void update(int id, String name, String speciality, int fee);

	Doctor findById(int id);

	List<Doctor> listAll();

}
