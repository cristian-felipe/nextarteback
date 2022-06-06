package com.prueba.nextarte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.nextarte.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByUsuarioLogin(String usuarioLogin);

}
