package com.cesur.dam.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cesur.dam.Entidades.*;

public interface RepositorioTest extends MongoRepository<Test, String>{

	@Query("{ 'numCorrectos' : ?0 }")
    public List<Test> findByNumCorrectos(String numCorrectos);
}
