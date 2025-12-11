package com.jacaranda.PrimerProyecto.Service;

import org.springframework.stereotype.Service;

import com.jacaranda.PrimerProyecto.Model.Imc;

@Service
public class CalculoService {

	public String calcular(Imc imcData) throws Exception {
		
		
			try {
				
				
				double amountWeight= imcData.getWeight();
				int amountAge = imcData.getAge(); 
				double amountHeight = imcData.getHeight();
				String sexValue = imcData.getSex();
				
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
			
		return null;
	}

}
