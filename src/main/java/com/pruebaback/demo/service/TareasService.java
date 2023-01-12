package com.pruebaback.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaback.demo.interfaceService.ITareasService;
import com.pruebaback.demo.interfaces.ITareas;
import com.pruebaback.demo.modelo.Tareas;



@Service
public class TareasService implements ITareasService {
	
	@Autowired
	private ITareas data;

	@Override
	public List<Tareas> listar() {
		return (List<Tareas>) data.findAll();
	}

	@Override
	public Optional<Tareas> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Tareas T) {
		int res=0;
		Tareas tarea=data.save(T);
		if(tarea.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}


}
