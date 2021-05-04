package com.divergent.clinicmanagementsystem;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainMenu {
	private static Logger logger = LoggerFactory.getLogger(MainMenu.class);

	@Autowired
	private CRUDDoctor crudDoctor;
	@Autowired
	private CRUDPatient crudPatient;
	@Autowired
	private CRUDDrug crudDrug;
	@Autowired
	private CRUDLabtest labtest;
	@Autowired
	private AppointmentCreate create;

	public void startPanel() {
		Scanner sc = new Scanner(System.in);
		logger.info("\n----Admin Panel-----");
		System.out.println(
				" 1. Patient \n 2. Doctor \n 3. Drug \n 4. Lab Test \n 5. Book appointment for a patient by selecting Patient, Doctor and Data/time \n 6. Logout");
		System.out.println("Enter Your Choice: ");
		int input = sc.nextInt();

		switch (input) {
		case 1:
			crudPatient.patientMenu();
			break;
		case 2:
			crudDoctor.doctorMenu();
			break;
		case 3:
			crudDrug.drugMenu();
			break;
		case 4:
            labtest.labtestMenu();
			break;
		case 5:
          create.createAppointment();
			break;
		case 6:
			logger.info("Exit");
			System.exit(0);
			break;
		}
	}

}
