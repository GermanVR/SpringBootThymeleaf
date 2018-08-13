package com.german.springboot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.german.springboot.entity.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Serializable> {

	// @Query("from Country c where lower(c.name) like lower(?1)")
	public List<Contacto> getByEstatusGreaterThan(String estatus);
}
