package com.prueba.nextarte.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.nextarte.model.Familia;
import com.prueba.nextarte.repository.IFamiliaRepository;
import com.prueba.nextarte.service.IFamiliaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FamiliaServiceImpl implements IFamiliaService{
	
	private final IFamiliaRepository familiaRepository;

	@Override
	public List<Familia> list() {
		return familiaRepository.findAll();
	}

	@Override
	public Optional<Familia> findById(Integer id) {
		return familiaRepository.findById(id);
	}

	@Override
	public Familia save(Familia familiaEntity) {
		return familiaRepository.save(familiaEntity);
	}

	@Override
	public Boolean delete(Integer id) {
			try {			
				familiaRepository.deleteById(id);
				return true;
			}catch (Exception e) {
				return false;
			}
	}

}
