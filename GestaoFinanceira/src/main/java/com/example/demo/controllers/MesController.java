package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Mes;
import com.example.demo.repositories.Meses;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/meses")
public class MesController 
{
	@Autowired
	private Meses ms;
	
	@GetMapping
	public ModelAndView listar() 
	{
		ModelAndView mv = new ModelAndView("ListaMeses");
		mv.addObject("meses",ms.findAll());
		Mes m = new Mes();
		mv.addObject("mes", m);
		return(mv);
	}	
	
	@PostMapping 
	public String salvar(@ModelAttribute @Valid Mes m,
                              BindingResult bindingResult,
                              Model model) 
	{       
                if(bindingResult.hasErrors()){
                    model.addAttribute("produtos", ms.findAll());
                    return "ListaMeses";
                }
		ms.save(m);
		return "redirect:/meses";
	}
	
	@RequestMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id)
	{
		ms.deleteById(id);
		return "redirect:/meses";
	}
	
	@RequestMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id) 
	{
		ModelAndView mv = new ModelAndView("ListaMeses");
		mv.addObject("meses",ms.findAll());
		Mes m = ms.getOne(id);
		mv.addObject( "mes",m);
		return (mv);
	}	
}
