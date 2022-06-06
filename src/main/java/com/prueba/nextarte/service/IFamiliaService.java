package com.prueba.nextarte.service;

import java.util.List;
import java.util.Optional;

import com.prueba.nextarte.model.Familia;

public interface IFamiliaService {

	List<Familia> list();
	
	Optional<Familia> findById(Integer id);
	
	Familia save(Familia userEntity);
	
	Boolean delete(Integer id);
}
