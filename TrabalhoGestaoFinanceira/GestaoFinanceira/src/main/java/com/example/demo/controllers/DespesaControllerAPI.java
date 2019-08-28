
package com.example.demo.controllers;

import com.example.demo.models.Despesa;
import com.example.demo.repositories.Despesas;
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

@RestController
@RequestMapping("/api/despesas")
@Validated 
public class DespesaControllerAPI {
     @Autowired
	private Despesas dp;
	
	@RequestMapping(value ="", method = RequestMethod.GET)
	public Collection<Despesa> listaDespesas() {
		return dp.findAll();
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public Optional<Despesa> getDespesa(@PathVariable("id") Long id) {
		return this.dp.findById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeDespesa(@PathVariable("id") Long id) {
		Optional<Despesa> m =dp.findById(id);
		if (m == null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
                dp.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveDespesa(@RequestBody Despesa despesa) {
		return new ResponseEntity<Despesa> (dp.save(despesa), HttpStatus.OK);
	}
}
