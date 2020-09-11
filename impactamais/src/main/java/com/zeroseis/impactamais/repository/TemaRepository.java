package com.zeroseis.impactamais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeroseis.impactamais.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{
	//public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
