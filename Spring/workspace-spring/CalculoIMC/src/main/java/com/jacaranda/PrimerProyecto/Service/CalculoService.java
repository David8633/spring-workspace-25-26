package com.jacaranda.PrimerProyecto.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CalculoService {

	public String calcular(Optional<String> weight,Optional<String> age,Optional<String> sex,Optional<String> height) throws Exception {
		
		if(weight.isPresent() && age.isPresent() && sex.isPresent() && height.isPresent()) {
			try {
				double amountWeight= Double.parseDouble(weight.get());
				int amountAge = Integer.parseInt(age.get()); 
				double amountHeight = Double.parseDouble(height.get());
				String sexValue = sex.get();
				
				if(amountWeight<0&&amountHeight<0&&amountAge<0) {
					String error = "Los datos no pueden ser negativos";
					throw new Exception("...");
				}
				
				double imc = amountWeight / (Math.pow(amountHeight,2));
				
				if(amountAge>25) {
					if(amountWeight<18.5) {
						return "BAJO PESO";
					}else if(amountWeight>18.5 && amountWeight<24.9) {
						return "NORMAL PESO";
					}else if(amountWeight>25.00 && amountWeight<29.9) {
						return "SOBREPESO";
					}else if(amountWeight>=30.00) {
						return "OBESIDAD";
					}
					
				}else {
					if(amountWeight<17.5) {
						return "BAJO PESO";
					}else if(amountWeight>18.5 && amountWeight<26.9) {
						return "NORMAL PESO";
					}else if(amountWeight>27.00 && amountWeight<32.9) {
						return "SOBREPESO";
					}else if(amountWeight>=33.00) {
						return "OBESIDAD";
					}
				}
			} catch (Exception e) {
				throw new Exception("Se ha producido un error por haber introducido mal los valores");
			}
			
		}else {
			throw new Exception("Los valores estan vacios.");
		}
	}

}
