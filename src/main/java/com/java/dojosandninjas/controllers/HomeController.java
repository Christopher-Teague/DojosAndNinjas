package com.java.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dojosandninjas.models.Dojo;
import com.java.dojosandninjas.models.Ninja;
import com.java.dojosandninjas.services.DojoService;
import com.java.dojosandninjas.services.NinjaService;

@Controller
public class HomeController {

	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;

	@GetMapping("/")
	public String dashboard(Model model, @ModelAttribute("newDojo")Dojo newDojo) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
	return "index.jsp";
	}
	
	@PostMapping("/dojo/create")
	public String addNewDojo(@Valid @ModelAttribute("newDojo")Dojo newDojo, BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "index.jsp";
		} else {
			dojoService.addDojo(newDojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojo/{id}/show")
	public String showDojo(@PathVariable("id")Long id, Model model) {
		Dojo dojo = dojoService.findOne(id);
		model.addAttribute("dojo",dojo);
		return "showDojo.jsp";
	}
	
	@GetMapping("/ninja/new")
	public String newNinja(@ModelAttribute("newNinja")Ninja newNinja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
		
	@PostMapping("/ninja/new")
	public String addNinja(@Valid @ModelAttribute("newNinja")Ninja newNinja,BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "newNinja.jsp";	
		} else {
			ninjaService.addNinja(newNinja);
			return "redirect:/";
		}
	}
	
}

