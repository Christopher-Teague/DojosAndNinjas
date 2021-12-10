package com.java.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dojosandninjas.models.Dojo;
import com.java.dojosandninjas.repositories.DojoRepository;
import com.java.dojosandninjas.repositories.NinjaRepository;

@Service
public class DojoService {

	
	@Autowired
	NinjaRepository ninjaRepo;
	
	@Autowired
	DojoRepository dojoRepo;
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo addDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo findOne(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}
