package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Receita;
import com.example.demo.repositories.Receitas;

@Controller
@RequestMapping("/receitas")
public class ReceitaController 
{
	@Autowired
	private Receitas rc;
	
	@GetMapping
	public ModelAndView listar() 
	{
		ModelAndView mv = new ModelAndView("ListaReceitas");
		mv.addObject("receitas",rc.findAll());
		Receita r = new Receita();
		mv.addObject("receita", r);
		return(mv);
	}
	
	
	@PostMapping 
	public String salvar(Receita r) 
	{
		rc.save(r);
		return "redirect:/receitas";
	}
	
	
	@RequestMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id)
	{
		rc.deleteById(id);
		return "redirect:/receitas";
	}
	
	
	@RequestMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id) 
	{
		ModelAndView mv = new ModelAndView("ListaReceitas");
		mv.addObject("receitas",rc.findAll());
		Receita r = rc.getOne(id);
		mv.addObject( "receita",r);
		return (mv);
	}
	

}
