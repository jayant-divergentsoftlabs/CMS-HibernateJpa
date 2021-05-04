package com.divergent.clinicmanagementsystem;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.divergent.clinicmanagementsystem.entity.Drug;
import com.divergent.clinicmanagementsystem.service.DrugService;
@Component
public class CRUDDrug {

	private static final Logger myLogger = LoggerFactory.getLogger(CRUDDrug.class);

	@Autowired
	private DrugService drugService;

	public void drugMenu() {
		System.out.println("\n--------------------Drug Menu--------------------");
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
				drugMenu();

			case 2:
				search();
				drugMenu();
			case 3:
				list();
				drugMenu();
			case 4:
				delete();
				drugMenu();
			case 5:
				update();
				drugMenu();
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
		System.out.println("\nEnter Drug Id :");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		if (this.drugService.remove(id)) {
			myLogger.info("----Deleted----");
		} else {
			myLogger.error("Not Found");
		}
	}

	private void list() {
		List<Drug> drugList = this.drugService.list();
		System.out.println("\n---------------------------------Doctor List--------------------------------------");
		for (Drug drug : drugList) {
			System.out.printf("| %5s | %10s | %20s | \n", drug.getId(), drug.getName(), drug.getPrice());
		}
		System.out.println("--------------------------------------------------------------------------------------");
	}

	private void search() {
		System.out.print("\nEnter Drug Id : ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();

		Drug drug = drugService.findById(id);

		if (drug != null) {
			System.out.println("\n------------------------------------Doctor Data-----------------------------------");

			System.out.printf("| %5s | %10s | %20s | \n", drug.getId(), drug.getName(), drug.getPrice());
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("\nRecord Found");
		} else {
			System.out.println("\nData Not Found!");
		}
	}

	private void add() {

		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter Drug Name : ");
		String name = sc.next();

		System.out.print("\nEnter Drug Price : ");
		int price = sc.nextInt();
		drugService.add(name, price);
		System.out.println("\n Insert Succesfully");
	}
}
