package com.cesur.dam.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cesur.dam.Entidades.*;

public interface RepositorioRespuestas extends MongoRepository<Respuestas, String>{

	@Query("{ 'respuestas' : ?0 }")
    public List<Respuestas> findByRespuestas(String respuestas);
}
