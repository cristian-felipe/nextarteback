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

import com.prueba.nextarte.model.Familia;
import com.prueba.nextarte.service.IFamiliaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/nextarte")
@CrossOrigin("*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FamiliaController {
	
	
	private final IFamiliaService familiaService;
	
	@GetMapping("/Family/all")
    public ResponseEntity<List<Familia>> listAll() {
		 try {
			 List<Familia> usuarios=familiaService.list();
			 return ResponseEntity.ok(usuarios);
			 
		 }catch (Exception e) {
			return (ResponseEntity<List<Familia>>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}
    }
	
	@PostMapping("/Family/save")
	public ResponseEntity<Familia> save(@RequestBody Familia userEntity){
		try {
			Familia usuario= familiaService.save(userEntity);
			return ResponseEntity.ok(usuario);
		} catch (Exception e) {
			return (ResponseEntity<Familia>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/Family/find-by-id/{id}")
    public ResponseEntity<Optional<Familia>> findById(@PathVariable("id") Integer id) {
		 try {
			 Optional<Familia> usuarios=familiaService.findById(id);
			 
			 return ResponseEntity.ok(usuarios);
			 
		 }catch (Exception e) {
			return (ResponseEntity<Optional<Familia>>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}
    }
	
	
	@DeleteMapping("/Family/delete/{id}")
	public Boolean deleteById(@PathVariable("id") Integer id) {
		return familiaService.delete(id);
		
	}

}
