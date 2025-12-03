package com.jacaranda.PrimerProyecto.Service;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class ServiceCalc {

	public int operations(Optional<String> numeroA, Optional<String> numeroB, Optional<String> select) {
		String numero1Value = numeroA.get();
		String numero2Value = numeroB.get();
		String selectValue = select.get();
		
		int n1 = Integer.parseInt(numero1Value);
		int n2= Integer.parseInt(numero2Value);
		
		if(selectValue == "sumar") {
			return n1 +n2;
		}else if(selectValue == "restar") {
			return n1  - n2;
		}else if(selectValue == "multiplicar") {
			return n1 * n2;
		}else if(selectValue == "dividir") {
			if((n1==0 || n2 == 0) && (n1!=0 || n2 != 0)) {
				String error = "no se puede dividir entre 0";
			}else {
				return n1/n2;
			}
		}
		return 0;
	}

}
