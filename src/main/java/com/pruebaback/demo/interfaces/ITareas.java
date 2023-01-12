package com.pruebaback.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebaback.demo.modelo.Tareas;

@Repository
public interface ITareas extends CrudRepository<Tareas, Integer> {

}
