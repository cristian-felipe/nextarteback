package com.prueba.nextarte.service;

import java.util.List;
import java.util.Optional;

import com.prueba.nextarte.model.Usuario;

public interface IUsuarioService {
	
	List<Usuario> list();
	
	Optional<Usuario> findById(Integer id);
	
	Usuario save(Usuario userEntity);
	
	Boolean delete(Integer id);

}
