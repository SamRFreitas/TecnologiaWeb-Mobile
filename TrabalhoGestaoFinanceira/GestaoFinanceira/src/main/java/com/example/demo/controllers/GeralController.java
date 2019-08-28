package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class GeralController{
        	
                @PostMapping
		public String homePost() {
                    System.out.println("com.example.demo.controllers.GeralController.homePost()");
                    return "redirect:/";
		}
    
		@GetMapping
		public ModelAndView home() {
                    System.out.println("com.example.demo.controllers.GeralController.home()");
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
