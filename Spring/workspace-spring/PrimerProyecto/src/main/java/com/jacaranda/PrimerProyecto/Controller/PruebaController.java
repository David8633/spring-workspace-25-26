package com.jacaranda.PrimerProyecto.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.PrimerProyecto.Service.ServiceCalc;

@Controller
public class PruebaController {

	@Autowired
	public ServiceCalc service;
	
	@GetMapping("/")
    public String showOperationsForm() {
        return "suma";
    }
	
	@PostMapping("/")
	public String resultOperations(@RequestParam Optional<String> numeroA, @RequestParam Optional<String> numeroB, @RequestParam Optional<String> select, Model model) {
		try {		
			if(numeroA.isPresent()&&numeroB.isPresent()&&select.isPresent()) {
				int result = service.operations(numeroA, numeroB, select);
				model.addAttribute("numeroA", numeroA);	
				model.addAttribute("numeroB", numeroB);	
				model.addAttribute("result", result);	
			}

		} catch (Exception e) {
			String error = "No son numeros o estan vacios.";
			model.addAttribute("error", error);
		}
		
		return "suma";
	}
	
	
}


//	@GetMapping("/result")
// 	Esto es si te redirige a otra pagina.
//	public static String result(@RequestParam Integer numeroA, @RequestParam Integer numeroB, Model model) {
//		Integer result = numeroA + numeroB;
//		model.addAttribute("num1",numeroA);//Lo que hace es que lo guarda como una memoria,es decir, localStorage
//		model.addAttribute("num2",numeroB);
//		model.addAttribute("result",result);
//		return "result";{
//	}

//	@PostMapping("/suma")
//	public static String result(@RequestParam Optional<Integer> numeroA, @RequestParam Optional<Integer> numeroB, Model model) {
//		if(numeroA.isPresent() && numeroB.isPresent()) {//Si no es vacío.
//			Integer result = numeroA.get() + numeroB.get();
//			model.addAttribute("numeroA", numeroA.get());
//			model.addAttribute("numeroB", numeroB.get());
//			model.addAttribute("result", result);
//		}
//		return "suma";
//	}