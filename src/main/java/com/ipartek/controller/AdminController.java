package com.ipartek.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("atr_lista_moviles", movilRepo.findAll());
		model.addAttribute("obj_movil", new Movil());
		model.addAttribute("obj_ordenador", new Ordenador());
		model.addAttribute("atr_lista_ordenadores", ordenadorRepo.findAll());
		return "admin";
	}

	@RequestMapping("/adminGuardarMovil")
	public String guardarMovil(Model model, @ModelAttribute("obj_movil") Movil movil) {
		movilRepo.save(movil);
		return "redirect:/superuser";
	}

	@RequestMapping("/adminBorrarMovil")
	public String borrarMovil(Model model, @RequestParam(value = "id", required = false) Integer id) {
		movilRepo.deleteById(id);
		return "redirect:/superuser";
	}

	@RequestMapping("/adminModificarMovil")
	public String modificarMovil(Model model, @RequestParam(value = "id", required = false) Integer id,
			@ModelAttribute("obj_movil") Movil movil) {
		model.addAttribute("atr_lista_marcas", marcaRepo.findAll());

		if (id != null) {
			movil = movilRepo.findById(id).orElse(movil = new Movil());
		}

		model.addAttribute("obj_movil", movil);

		return "/formModificarMovil";
	}
	
	@RequestMapping("/adminGuardarOrdenador")
	public String guardarOrdenador(Model model, @ModelAttribute("obj_ordenador") Ordenador ordenador) {
		ordenadorRepo.save(ordenador);
		return "redirect:/superuser";
	}

	@RequestMapping("/adminBorrarOrdenador")
	public String borrarOrdenador(Model model, @RequestParam(value = "id", required = false) Integer id) {
		ordenadorRepo.deleteById(id);
		return "redirect:/superuser";
	}

	@RequestMapping("/adminModificarOrdenador")
	public String modificarOrdenador(Model model, @RequestParam(value = "id", required = false) Integer id,
			@ModelAttribute("obj_ordenador") Ordenador ordenador) {
		model.addAttribute("atr_lista_marcas", marcaRepo.findAll());

		if (id != null) {
			ordenador = ordenadorRepo.findById(id).orElse(ordenador = new Ordenador());
		}

		model.addAttribute("obj_ordenador", ordenador);

		return "/formModificarOrdenador";
	}

}
