package com.divergent.clinicmanagementsystem.dao;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Appointment;

public interface AppointmentDao {

public void add(Appointment appointment);
	
	public List<Appointment> get();
	
}


