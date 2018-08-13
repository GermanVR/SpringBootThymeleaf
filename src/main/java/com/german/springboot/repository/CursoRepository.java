package com.german.springboot.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.german.springboot.entity.Curso;

@Repository
public interface CursoRepository  extends JpaRepository<Curso,Serializable>{

}
