/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EntidadNueva;
import com.example.demo.repo.EntidadNuevaRepo;

/**
 * @author Emmanuel Neiza
 *
 */
@RestController
@RequestMapping("/entidad")
public class EntidadNuevaController {
	@Autowired
	EntidadNuevaRepo entidadRepo;
	
	@GetMapping("/entidades")
	public List<EntidadNueva> getAllNotes() {
	    return entidadRepo.findAll();
	}
	
	@GetMapping("/entidades/{id}")
	public ResponseEntity<EntidadNueva> getNoteById(@PathVariable(value = "id") Integer noteId) {
		EntidadNueva entidad = entidadRepo.findOne(noteId);
	    if(entidad == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(entidad);
	}
}
