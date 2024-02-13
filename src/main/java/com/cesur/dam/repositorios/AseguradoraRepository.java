package com.cesur.dam.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesur.dam.Entidades.Aseguradora;

/*
Esta interfaz está vacía debido a que al extender de JpaRepository, incluye una serie de métodos 
proporcionados por Spring Data, como findAll(). De esta manera, simplemente con parametizar con la entidad Aseguradora
y el tipo de su clave primaria, la interfaz hereda automáticamente todos esos métodos.
*/


public interface AseguradoraRepository extends JpaRepository<Aseguradora, Long> {
}
