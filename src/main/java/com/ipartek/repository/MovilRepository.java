package com.ipartek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.model.Movil;

@Repository
public interface MovilRepository extends JpaRepository<Movil, Integer>{

}
