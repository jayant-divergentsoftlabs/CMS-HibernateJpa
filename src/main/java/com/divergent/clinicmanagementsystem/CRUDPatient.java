package com.divergent.clinicmanagementsystem;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagementsystem.entity.Patient;
import com.divergent.clinicmanagementsystem.service.PatientService;
@Component
public class CRUDPatient {
	private static final Logger myLogger = LoggerFactory.getLogger(CRUDPatient.class);

	@Autowired
	private PatientService patientService;

	public void patientMenu() {

		System.out.println("\n--------------------Patient Menu--------------------");
		System.out.println("1. Add ");
		System.out.println("2. Search Patient");
		System.out.println("3. List of Patient");
		System.out.println("4. Delete Patient");
		System.out.println("5. Update Patient");
		System.out.println("6. Exit");

		while (true) {

			Scanner sc = new Scanner(System.in);

			int input = sc.nextInt();

			switch (input) {
			case 1:
				add();
				patientMenu();

			case 2:
				search();
				patientMenu();
			case 3:
				list();
				patientMenu();
			case 4:
				delete();
				patientMenu();
			case 5:
				update();
				patientMenu();
			case 6:

				break;
			default:
				myLogger.error("Please Enter Valid input ");
				break;
			}
		}

	}

	private void update() {
		// TODO Auto-generated method stub
		
	}

	private void delete() {
		System.out.println("\nEnter Patient Id :");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		if (this.patientService.remove(id)) {
			myLogger.info("----Deleted----");
		} else {
			myLogger.error("Not Found");
		}
	}

	private void list() {
		List<Patient> patientList = this.patientService.listAll();
		System.out.println("\n---------------------------------Doctor List--------------------------------------");
		for (Patient patient : patientList) {
			System.out.printf("| %5s | %10s | %20s | %10s |%10s |%10s |\n", patient.getId(), patient.getName(),
					patient.getAge(), patient.getGender(), patient.getWeight(), patient.getProblem());
		}
		System.out.println("--------------------------------------------------------------------------------------");
	}

	private void search() {
		System.out.print("\nEnter Patient Id : ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();

		Patient patient = patientService.findById(id);

		if (patient != null) {
			System.out.println("\n------------------------------------Patient Data-----------------------------------");
			System.out.printf("| %5s | %10s | %20s | %10s |%10s |%10s |\n", patient.getId(), patient.getName(),
					patient.getAge(), patient.getGender(), patient.getWeight(), patient.getProblem());

			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("\nRecord Found");
		} else {
			System.out.println("\nData Not Found!");
		}

	}

	private void add() {

		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter Patient Name : ");
		String name = sc.next();

		System.out.print("\nEnter Age: ");
		int age = sc.nextInt();

		System.out.print("\nEnter Gender: ");
		String gender = sc.next();

		System.out.print("\nEnter Weight: ");
		int weight = sc.nextInt();

		System.out.print("\nEnter Problem: ");
		String problem = sc.next();

		patientService.add(name, age, gender, weight, problem);

		System.out.println("\n Insert Succesfully");
	}
}