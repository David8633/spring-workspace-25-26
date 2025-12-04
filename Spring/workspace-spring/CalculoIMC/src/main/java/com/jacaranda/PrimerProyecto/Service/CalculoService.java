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
				
				double imc = amountWeight / ((amountHeight/100) * (amountHeight/100));
				
				if(amountAge>25) {
					if(imc<18.5) {
						return "BAJO PESO";
					}else if(imc>18.5 && imc<24.9) {
						return "NORMAL PESO";
					}else if(imc>25.00 && imc<29.9) {
						return "SOBREPESO";
					}else if(imc>=30.00) {
						return "OBESIDAD";
					}
					
				}else {
					if(amountAge<17.5) {
						return "BAJO PESO";
					}else if(imc>18.5 && imc<26.9) {
						return "NORMAL PESO";
					}else if(imc>27.00 && imc<32.9) {
						return "SOBREPESO";
					}else if(imc>=33.00) {
						return "OBESIDAD";
					}
				}
			} catch (Exception e) {
				throw new Exception("Se ha producido un error por haber introducido mal los valores");
			}
			
		}else {
			throw new Exception("Los valores estan vacios.");
		}
		return null;
	}

}
