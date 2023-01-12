package com.pruebaback.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.pruebaback.demo.modelo.Usuario;

public interface IUsuarioService {
	public List<Usuario>listar();
	public Optional<Usuario>listarId(int id);
	public int save(Usuario  U);
	public void  delete(int id);
	
}
