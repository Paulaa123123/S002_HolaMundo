package com.ipartek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Movil;
import com.ipartek.model.Ordenador;
import com.ipartek.repository.MarcaRepository;
import com.ipartek.repository.MovilRepository;
import com.ipartek.repository.OrdenadorRepository;

@Controller
public class AdminController {

	@Autowired
	private MarcaRepository marcaRepo;

	@Autowired
	private MovilRepository movilRepo;

	@Autowired
	private OrdenadorRepository ordenadorRepo;

	@RequestMapping("/superuser")
	public String cargarAdmin(Model model) {
		model.addAttribute("atr_lista_marcas", marcaRepo.findAll());
		model.addAttribute("obj_movil", new Movil());
		model.addAttribute("obj_ordenador", new Ordenador());
		return "admin";
	}

	@RequestMapping("/adminGuardarMovil")
	public String guardarMovil(Model model, @ModelAttribute("obj_movil") Movil movil) {
		movilRepo.save(movil);
		return "redirect:/superuser";
	}

	@RequestMapping("/adminGuardarOrdenador")
	public String guardarOrdenador(Model model, @ModelAttribute("obj_ordenador") Ordenador ordenador) {
		ordenadorRepo.save(ordenador);
		return "redirect:/superuser";
	}
}
