package com.zeroseis.impactamais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zeroseis.impactamais.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	//public List<Usuario> findAllbyNomeContainingIgnoreCase (String nome);
}
