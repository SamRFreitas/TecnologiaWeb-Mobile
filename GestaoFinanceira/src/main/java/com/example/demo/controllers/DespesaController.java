package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.models.Despesa;
import com.example.demo.repositories.Despesas;

@Controller
@RequestMapping("/despesas")
public class DespesaController 
{
	@Autowired
	private Despesas dp;
	
	@GetMapping
	public ModelAndView listar() 
	{
		ModelAndView mv = new ModelAndView("ListaDespesas");
		mv.addObject("despesas",dp.findAll());
		Despesa d = new Despesa();
		mv.addObject("despesa", d);
		return(mv);
	}

	@PostMapping 
	public String salvar(Despesa d)
	{
		dp.save(d);
		return "redirect:/despesas";
	}
	
	@RequestMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id)
	{
		dp.deleteById(id);
		return "redirect:/despesas";
	}
	
	@RequestMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id) 
	{
		ModelAndView mv = new ModelAndView("ListaDespesas");
		mv.addObject("despesas",dp.findAll());
		Despesa d = dp.getOne(id);
		mv.addObject( "despesa",d);
		return (mv);
	}
	
	
}
