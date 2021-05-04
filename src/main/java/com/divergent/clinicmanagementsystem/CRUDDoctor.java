package com.divergent.clinicmanagementsystem;

import java.util.List;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagementsystem.entity.Doctor;
import com.divergent.clinicmanagementsystem.service.DoctorService;

@Component
public class CRUDDoctor {
	private static final Logger myLogger = LoggerFactory.getLogger(CRUDDoctor.class);

	@Autowired
	private DoctorService doctorService;

	public void doctorMenu() {
		System.out.println("\n--------------------Doctor Menu--------------------");
		System.out.println("1. Add ");
		System.out.println("2. Search Doctor");
		System.out.println("3. List of Doctor");
		System.out.println("4. Delete Doctor");
		System.out.println("5. Update Doctor");
		System.out.println("6. Exit");
	

	
		while (true) {
			
			Scanner sc = new Scanner(System.in);
		 
			int input = sc.nextInt();

			switch (input) {
			case 1:
				add();
				doctorMenu();
				
			case 2:
				search();
				doctorMenu();
			case 3:
				list();
				doctorMenu();
			case 4:
				delete();
				doctorMenu();
			case 5:
				update();
				doctorMenu();
			case 6:
               
				break;
			default:
				myLogger.error("Please Enter Valid input ");
				break;
			}
		}

	}

	private void update() {

	}

	private void delete() {
		System.out.println("\nEnter Doctor Id :");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		if (this.doctorService.remove(id)) {
			myLogger.info("----Deleted----");
		} else {
			myLogger.error("Not Found");
		}
	}

	private void list() {
		List<Doctor> doctorList = this.doctorService.listAll();
		System.out.println("\n---------------------------------Doctor List--------------------------------------");
		for (Doctor doctor : doctorList) {
			System.out.printf("| %5s | %10s | %20s | %10s |\n", doctor.getId(), doctor.getName(),
					doctor.getSpeciality(), doctor.getFee());
		}
		System.out.println("--------------------------------------------------------------------------------------");
	}

	private void search() {
		System.out.print("\nEnter Doctor Id : ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();

		Doctor doctor = doctorService.findById(id);

		if (doctor != null) {
			System.out.println("\n------------------------------------Doctor Data-----------------------------------");

			System.out.printf("| %5s | %10s | %20s | %10s |\n", doctor.getId(), doctor.getName(),
					doctor.getSpeciality(), doctor.getFee());
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("\nRecord Found");
		} else {
			System.out.println("\nDoctor Data Not Found!");
		}

	}

	private void add() {

		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter Doctor Name : ");
		String name = sc.next();

		System.out.print("\nEnter Doctor Speciality : ");
		String speciality = sc.next();

		System.out.print("\nEnter Doctor Fee : ");
		int fee = sc.nextInt();
		doctorService.add( name, speciality, fee);
		System.out.println("\n Insert Succesfully");
	}
}
