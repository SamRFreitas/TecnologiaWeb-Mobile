package com.iff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iff.model.Produto;
import com.iff.repository.Produtos;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private Produtos produtosRepository; 
	
	@GetMapping()
	public ModelAndView listaProdutos()
	{	
		ModelAndView mv = new ModelAndView("ListaProdutos.html");
		mv.addObject("produtos", produtosRepository.findAll());
		mv.addObject("produto", new Produto());
		return(mv);
		
	}
	
	@PostMapping 
	public String salvar(Produto p) 
	{
		produtosRepository.save(p);
		return "redirect:/produtos";
	}
	

	
}
