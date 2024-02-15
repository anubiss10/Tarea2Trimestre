package com.cesur.dam.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cesur.dam.Entidades.*;

public interface RepositorioTemas extends MongoRepository<Temas,String>{

	@Query("{ 'numTema' : ?0 }")
    public List<Temas> findByNumTema(String numTema);
}
