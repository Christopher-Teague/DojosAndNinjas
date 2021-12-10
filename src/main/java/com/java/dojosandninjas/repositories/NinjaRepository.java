package com.java.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.dojosandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
