package com.divergent.clinicmanagementsystem.service;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Appointment;

public interface AppointmentService {
	
public void add(int appointmentId, String problem, int patientId, int doctorId);
	
	public List<Appointment> getList();
	
	/*
	 * public List<Appointment> getAppointedPatientList(int doctorId);
	 * 
	 * public List<Appointment> getPatientHistory(int patientId);
	 */
}
