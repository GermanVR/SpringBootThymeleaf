package com.german.springboot.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.german.springboot.entity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Serializable> {

}
