package com.prueba.nextarte.service.authConfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prueba.nextarte.model.Usuario;
import com.prueba.nextarte.repository.IUsuarioRepository;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usu= usuarioRepository.findByUsuarioLogin(username);
		
		List<GrantedAuthority> roles= new ArrayList<>();
		
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDetails= new User(usu.getUsuarioLogin(),usu.getContrasena(),roles);
		return userDetails;
	}

}
