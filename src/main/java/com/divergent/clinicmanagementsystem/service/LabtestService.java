package com.divergent.clinicmanagementsystem.service;

import java.util.List;
import com.divergent.clinicmanagementsystem.entity.Labtest;

public interface LabtestService {
	public void add(String name, int price);

	public boolean remove(int id);

	public Labtest findById(int id);
	
	public List<Labtest> list();
}
