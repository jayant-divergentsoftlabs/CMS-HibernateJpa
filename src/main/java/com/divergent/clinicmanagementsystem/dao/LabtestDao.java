package com.divergent.clinicmanagementsystem.dao;

import java.util.List;
import com.divergent.clinicmanagementsystem.entity.Labtest;

public interface LabtestDao {

	void add(Labtest labtest);

	List<Labtest> listAll();

	void remove(Labtest labtest);

	void update(Labtest labtest);

	Labtest findById(int id);
}
