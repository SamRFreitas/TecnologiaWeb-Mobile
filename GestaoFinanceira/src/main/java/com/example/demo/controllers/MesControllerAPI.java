package com.example.demo.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Mes;
import com.example.demo.repositories.Meses;

@Controller
@RequestMapping("/api/meses")
public class MesControllerAPI 
{
	@Autowired
	private Meses ms;
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	public Collection<Mes> listaMeses() {
		return ms.findAll();
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public Optional<Mes> getMes(@PathVariable("id") Long id) {
		return this.ms.findById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeMes(@PathVariable("id") Long id) {
		Optional<Mes> m = ms.findById(id);
		if (m == null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ms.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveMes(Mes mes) {
		return new ResponseEntity<Mes> (ms.save(mes), HttpStatus.OK);
	}
		
	
}
