package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class GeralController{
        
                @GetMapping
                public String login() {
			return "redirect:/login";
		}
		   
		@GetMapping("/home")
		public ModelAndView home() {
			ModelAndView mv = new ModelAndView("MenuPrincipal");
			return(mv);
		}
		
		@GetMapping("sobre")
		public ModelAndView sobre() {
			ModelAndView mv = new ModelAndView("Sobre");
			return(mv);
		}
		@GetMapping("dicas")
		public ModelAndView dicas() {
			ModelAndView mv = new ModelAndView("Dicas");
			return(mv);
		}

}
