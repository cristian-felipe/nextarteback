package com.prueba.nextarte;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prueba.nextarte.model.Usuario;
import com.prueba.nextarte.repository.IUsuarioRepository;

@SpringBootTest
class NextarteApplicationTests {
	
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {
		Usuario usuario=new Usuario();
		usuario.setId(4);
		usuario.setContrasena(encoder.encode("12345678"));
		usuario.setPrimerNombre("juan");
		usuario.setUsuarioLogin("Juan Camilo");
		Usuario resp= usuarioRepository.save(usuario);
		
		assertTrue(resp.getContrasena().equals(usuario.getContrasena()));
	}

}
