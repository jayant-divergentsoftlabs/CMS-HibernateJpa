package com.divergent.clinicmanagementsystem.dao;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Doctor;

public interface DoctorDao {

	void add(Doctor doctor);

	List<Doctor> listAll();

	void remove(Doctor doctor);

	void update(Doctor doctor);

	Doctor findById(int id);

}
