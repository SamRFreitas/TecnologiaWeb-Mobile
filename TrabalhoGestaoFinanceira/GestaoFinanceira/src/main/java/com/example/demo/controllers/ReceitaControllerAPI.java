/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.Receita;
import com.example.demo.repositories.Receitas;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sam
 */
@RestController
@RequestMapping("/api/receitas")
@Validated 
public class ReceitaControllerAPI {
    @Autowired
	private Receitas rc;
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	public Collection<Receita> listaReceitas() {
		return rc.findAll();
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public Optional<Receita> getReceita(@PathVariable("id") Long id) {
		return this.rc.findById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeReceita(@PathVariable("id") Long id) {
		Optional<Receita> m =rc.findById(id);
		if (m == null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
                rc.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveReceita(@RequestBody Receita receita) {
		return new ResponseEntity<Receita> (rc.save(receita), HttpStatus.OK);
	}
    
}
