package com.prueba.nextarte.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.prueba.nextarte.model.Usuario;
import com.prueba.nextarte.repository.IUsuarioRepository;
import com.prueba.nextarte.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsusarioServiceImpl implements IUsuarioService{
	
	private final IUsuarioRepository usuarioRepository ;

	@Override
	public List<Usuario> list() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario save(Usuario userEntity) {
		
		
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		
		try {
		String encript=encoder.encode(userEntity.getContrasena());
		userEntity.setContrasena(encript);
		}catch (Exception e) {
		}
		return usuarioRepository.save(userEntity);
	}

	@Override
	public Boolean delete(Integer id) {
		try {			
			usuarioRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
