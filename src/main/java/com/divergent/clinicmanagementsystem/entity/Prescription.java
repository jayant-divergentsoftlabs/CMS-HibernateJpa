package com.divergent.clinicmanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`prescription`")
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "prescription")
	private String prescription;
	
	@Column(name = "note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "doctor_Id", nullable = false)
	private Doctor doctorId;

	@ManyToOne
	@JoinColumn(name = "patient_Id")
	private Patient patientid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Doctor getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Doctor doctorId) {
		this.doctorId = doctorId;
	}

	public Patient getPatientid() {
		return patientid;
	}

	public void setPatientid(Patient patientid) {
		this.patientid = patientid;
	}

	@Override
	public String toString() {
		return "Prescription [id=" + id + ", prescription=" + prescription + ", note=" + note + ", doctorId=" + doctorId
				+ ", patientid=" + patientid + "]";
	}

}
