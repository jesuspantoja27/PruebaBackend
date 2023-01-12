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

import com.pruebaback.demo.interfaceService.ITareasService;
import com.pruebaback.demo.modelo.Tareas;


@Controller
@RequestMapping
public class ControladorTareas {

	
	@Autowired
	private ITareasService service;
	
	@GetMapping("/listarTareas")
	public String listar(Model model) {
		List<Tareas>tareas=service.listar();
		model.addAttribute("tareas",tareas);
		return "indextareas";
	}
	
	@GetMapping("/newTarea")
	public String agregar(Model model) {
		model.addAttribute("tarea",new Tareas());
		return"AgregarTarea";
		
	}
	@PostMapping("/saveTarea")
	public String save(@Validated Tareas T, Model model) {
		service.save(T);
		return"redirect:/listarTareas";
	}
	
	@GetMapping("/editarTarea/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Tareas>tarea=service.listarId(id);
		model.addAttribute("tarea", tarea);
		return"AgregarTarea";
	}
	
	@GetMapping("/eliminarTarea/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return"redirect:/listarTareas";
		
	}
	
	
}
