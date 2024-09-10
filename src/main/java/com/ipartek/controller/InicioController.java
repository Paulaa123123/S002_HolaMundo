package com.ipartek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.repository.MarcaRepository;

@Controller
public class InicioController {
	
	@RequestMapping("/")
	public String index(Model model) {
		return "home";
	}

}
