package com.pruebaback.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.pruebaback.demo.modelo.Tareas;

public interface ITareasService {
	
	public List<Tareas>listar();
	public Optional<Tareas>listarId(int id);
	public int save(Tareas  T);
	public void  delete(int id);

}
