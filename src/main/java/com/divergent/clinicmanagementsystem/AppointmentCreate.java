package com.divergent.clinicmanagementsystem;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagementsystem.service.AppointmentService;

@Component
public class AppointmentCreate {

	@Autowired
	private AppointmentService appointmentService;

	public void createAppointment() {

		Scanner sc = new Scanner(System.in);

		System.out.println("--------------------Create Appointment--------------------");

		System.out.print("Enter Appointment Id : ");
		int appointmentId = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter Patient Problem : ");
		String problem = sc.nextLine();

		System.out.print("\nEnter Patient Id : ");
		int patientId = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter Doctor Id : ");
		int doctorId = Integer.parseInt(sc.nextLine());

		appointmentService.add(appointmentId, problem, patientId, doctorId);

	}
}
