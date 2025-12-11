package com.jacaranda.PrimerProyecto.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacaranda.PrimerProyecto.Service.CalculoService;

@Controller
public class imcController {
	
	private static CalculoService  calculoImc;
	
	public imcController(CalculoService calculoImc) {
		super();;
		this.calculoImc = calculoImc;
	}
	
	@GetMapping("/")
	public static String showViewIndex() {
		return "index";
	}
	
	@PostMapping("/")
	public static String showResult(Model model, @Validated @ModelAttribute Imc imc, BindingResult bindingresult throws Exception {
		try {
			if(bindingresult.getErrorCount() >0) {
				return "index";
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return "index";
	}
	
}
