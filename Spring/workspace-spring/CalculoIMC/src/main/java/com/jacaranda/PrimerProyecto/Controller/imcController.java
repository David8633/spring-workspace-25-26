package com.jacaranda.PrimerProyecto.Controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacaranda.PrimerProyecto.Service.CalculoService;

@Controller
public class imcController {

	private static CalculoService  calculoImc;
	
	@GetMapping("/")
	public static String showViewIndex() {
		return "index";
	}
	
	@PostMapping("/")
	public static String showResult(Optional<String> weight, Optional<String> age,Optional<String> sex, Optional<String> height,Model model) {
		try {
			String resultado = calculoImc.calcular(weight,age,sex,height);
			model.addAttribute("resultado", resultado);
		} catch (Exception e) {
			e.getMessage();
		}
		return "index";
	}
	
}
