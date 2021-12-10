package com.java.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dojosandninjas.models.Ninja;
import com.java.dojosandninjas.repositories.DojoRepository;
import com.java.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	NinjaRepository ninjaRepo;
	
	@Autowired
	DojoRepository dojoRepo;
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}

	public Ninja addNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
}
