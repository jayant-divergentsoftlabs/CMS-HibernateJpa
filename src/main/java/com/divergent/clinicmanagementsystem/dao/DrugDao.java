package com.divergent.clinicmanagementsystem.dao;

import java.util.List;
import com.divergent.clinicmanagementsystem.entity.Drug;

public interface DrugDao {
	
	void add(Drug drug);

	List<Drug> listAll();

	void remove(Drug drug);

	void update(Drug drug);

	Drug findById(int id);



}
