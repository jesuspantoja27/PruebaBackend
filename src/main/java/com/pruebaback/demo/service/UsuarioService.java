package com.pruebaback.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaback.demo.interfaceService.IUsuarioService;
import com.pruebaback.demo.interfaces.IUsuario;
import com.pruebaback.demo.modelo.Usuario;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuario data;  
	
	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return (List<Usuario>)data.findAll();
	}

	@Override
	public Optional<Usuario> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Usuario U) {
		int res=0;
		Usuario usuario=data.save(U);
		if(usuario.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}
