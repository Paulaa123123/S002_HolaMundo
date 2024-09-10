package com.ipartek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Movil;
import com.ipartek.repository.MarcaRepository;
import com.ipartek.repository.MovilRepository;

@Controller
public class AdminController {

	@Autowired
	private MarcaRepository marcaRepo;

	@Autowired
	private MovilRepository movilRepo;

	@RequestMapping("/superuser")
	public String cargarAdmin(Model model) {
		model.addAttribute("atr_lista_marcas", marcaRepo.findAll());
		model.addAttribute("obj_movil", new Movil());
		return "admin";
	}

	@RequestMapping("/adminGuardarMovil")
	public String guardarMovil(Model model, @ModelAttribute("obj_movil") Movil movil) {
		movilRepo.save(movil);
		return "redirect:/superuser";
	}

}
