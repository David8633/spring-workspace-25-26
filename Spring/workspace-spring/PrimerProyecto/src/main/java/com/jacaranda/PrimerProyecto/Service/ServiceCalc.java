package com.jacaranda.PrimerProyecto.Service;
import org.springframework.stereotype.Service;


@Service
public class ServiceCalc {

	public int operations(int num1, int num2, String select) {
		
		if(select == "sumar") {
			return num1 +num2;
		}else if(select == "restar") {
			return num1  - num2;
		}else if(select == "multiplicar") {
			return num1 * num2;
		}else if(select == "dividir") {
			if((num1==0 || num2 == 0) && (num1!=0 || num2 != 0)) {
				String error = "no se puede dividir entre 0";
			}else {
				return num1/num2;
			}
		}
		return 0;
	}

}
