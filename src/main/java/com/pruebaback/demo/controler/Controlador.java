package com.pruebaback.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pruebaback.demo.interfaceService.IUsuarioService;
import com.pruebaback.demo.modelo.Usuario;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Usuario>usuarios=service.listar();
		model.addAttribute("usuarios",usuarios);
		return "index";
	}
    
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("usuario",new Usuario());
		return"AgregarUsuario";
		
	}
	@PostMapping("/save")
	public String save(@Validated Usuario U, Model model) {
		service.save(U);
		return"redirect:/listar";
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Usuario>usuario=service.listarId(id);
		model.addAttribute("usuario", usuario);
		return"AgregarUsuario";
	}
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return"redirect:/listar";
		
	}
}
 