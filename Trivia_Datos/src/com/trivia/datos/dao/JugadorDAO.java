package com.trivia.datos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.trivia.entidad.JugadorEntidad;

@Repository
@Component
public interface JugadorDAO extends CrudRepository<JugadorEntidad, Integer> 
{
	
}
