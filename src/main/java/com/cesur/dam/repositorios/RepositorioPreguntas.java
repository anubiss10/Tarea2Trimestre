package com.cesur.dam.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cesur.dam.Entidades.*;

public interface RepositorioPreguntas extends MongoRepository<Preguntas, String> {

	@Query("{ 'pregunta' : ?0 }")
    public List<Preguntas> findByPreguntas(String preguntas);
	
}
