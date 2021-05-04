package com.divergent.clinicmanagementsystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.divergent.clinicmanagementsystem.config.AppConfig;

public class MainApp {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MainMenu mainMenu = context.getBean(MainMenu.class);
		mainMenu.startPanel();
	}
}
