package com.divergent.clinicmanagementsystem.service;

import java.util.List;

import com.divergent.clinicmanagementsystem.entity.Drug;

public interface DrugService {

	public void add(String name, int price);

	public boolean remove(int id);

	public Drug findById(int id);
	
	public List<Drug> list();

}
