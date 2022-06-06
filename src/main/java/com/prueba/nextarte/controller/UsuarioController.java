package com.prueba.nextarte.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.nextarte.model.Usuario;
import com.prueba.nextarte.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/nextarte")
@CrossOrigin("*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {
	
	private final IUsuarioService usuarioService;
	
	@GetMapping("/user/all")
    public ResponseEntity<List<Usuario>> listAll() {
		 try {
			 List<Usuario> usuarios=usuarioService.list();
			 return ResponseEntity.ok(usuarios);
			 
		 }catch (Exception e) {
			return (ResponseEntity<List<Usuario>>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}
    }
	
	@PostMapping("/user/save")
	public ResponseEntity<Usuario> save(@RequestBody Usuario userEntity){
		try {
			Usuario usuario= usuarioService.save(userEntity);
			return ResponseEntity.ok(usuario);
		} catch (Exception e) {
			return (ResponseEntity<Usuario>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/user/find-by-id/{id}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable("id") Integer id) {
		 try {
			 Optional<Usuario> usuarios=usuarioService.findById(id);
			 
			 return ResponseEntity.ok(usuarios);
			 
		 }catch (Exception e) {
			return (ResponseEntity<Optional<Usuario>>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}
    }
	
	
	@DeleteMapping("/user/delete/{id}")
	public Boolean deleteById(@PathVariable("id") Integer id) {
		return usuarioService.delete(id);
		
	}
}
