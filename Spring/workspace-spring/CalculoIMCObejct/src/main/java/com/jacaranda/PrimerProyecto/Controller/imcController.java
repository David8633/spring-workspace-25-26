package com.jacaranda.PrimerProyecto.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacaranda.PrimerProyecto.Model.Imc;
import com.jacaranda.PrimerProyecto.Service.CalculoService;

@Controller
public class imcController {
	
	private static CalculoService  calculoImc;
	
	public imcController(CalculoService calculoImc) {
		super();;
		this.calculoImc = calculoImc;
	}
	
	@GetMapping("/")
	public  String showViewIndex() {
		return "index";
	}
	
	@PostMapping("/")
	public String showResult(Model model,@Validated @ModelAttribute("imc") Imc modelimc, BindingResult bindingresult) {
		try {
			
			if(bindingresult.hasErrors()) {
				return "index";
			}
			
			String resultado = calculoImc.calcular(modelimc);
			model.addAttribute("resultado", resultado);
			model.addAttribute("imcResult", modelimc);
			model.addAttribute("imc", new Imc());
		} catch (Exception e) {
			e.getMessage();
		}
		return "index";
	}
	
}
