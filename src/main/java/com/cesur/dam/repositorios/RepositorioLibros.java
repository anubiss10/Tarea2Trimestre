package com.cesur.dam.repositorios;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.cesur.dam.Entidades.*;


public interface RepositorioLibros extends MongoRepository<Libros, Integer>{
	
	@Query("{ 'int' : ?0, 'true' : ?1 }")
	public List<Libros>  findByTo(String numero, boolean correcto);
}
