package com.divergent.clinicmanagementsystem;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergent.clinicmanagementsystem.entity.Labtest;
import com.divergent.clinicmanagementsystem.service.LabtestService;

@Component
public class CRUDLabtest {

	private static final Logger myLogger = LoggerFactory.getLogger(CRUDLabtest.class);

	@Autowired
	private LabtestService labtestService;

	public void labtestMenu() {
		System.out.println("\n--------------------Labtest Menu--------------------");
		System.out.println("1. Add ");
		System.out.println("2. Search ");
		System.out.println("3. List ");
		System.out.println("4. Delete ");
		System.out.println("5. Update ");
		System.out.println("6. Exit");

		while (true) {

			Scanner sc = new Scanner(System.in);

			int input = sc.nextInt();

			switch (input) {
			case 1:
				add();
				labtestMenu();

			case 2:
				search();
				labtestMenu();
			case 3:
				list();
				labtestMenu();
			case 4:
				delete();
				labtestMenu();
			case 5:
				update();
				labtestMenu();
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
		System.out.println("\nEnter Test Id :");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		if (this.labtestService.remove(id)) {
			myLogger.info("----Deleted----");
		} else {
			myLogger.error("Not Found");
		}
	}

	private void list() {
		List<Labtest> testList = this.labtestService.list();
		System.out.println("\n---------------------------------Test List--------------------------------------");
		for (Labtest labtest : testList) {
			System.out.printf("| %5s | %10s | %20s | \n", labtest.getId(), labtest.getName(), labtest.getPrice());
		}
		System.out.println("--------------------------------------------------------------------------------------");
	}

	private void search() {
		System.out.print("\nEnter Test Id : ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();

		Labtest test = labtestService.findById(id);

		if (test != null) {
			System.out.println("\n------------------------------------Test Data-----------------------------------");

			System.out.printf("| %5s | %10s | %20s | \n", test.getId(), test.getName(), test.getPrice());
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("\nRecord Found");
		} else {
			System.out.println("\n Data Not Found!");
		}
	}

	private void add() {

		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter test Name : ");
		String name = sc.next();

		System.out.print("\nEnter test Price : ");
		int price = sc.nextInt();
		labtestService.add(name, price);
		System.out.println("\n Insert Succesfully");
	}
}