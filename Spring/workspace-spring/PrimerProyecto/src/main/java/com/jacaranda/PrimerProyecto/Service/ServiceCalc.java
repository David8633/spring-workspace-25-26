package com.jacaranda.PrimerProyecto.Service;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public class ServiceCalc {

	public int operations(Optional<String> numeroA, Optional<String> numeroB, Optional<String> select,Model model) {
		String numero1Value = numeroA.get();
		String numero2Value = numeroB.get();
		String selectValue = select.get();
		
		int n1 = Integer.parseInt(numero1Value);
		int n2= Integer.parseInt(numero2Value);
		
		if("sumar".equals(selectValue)) {
			return n1 +n2;
		}else if("restar".equals(selectValue)) {
			return n1  - n2;
		}else if("multiplicar".equals(selectValue)) {
			return n1 * n2;
		}else if("dividir".equals(selectValue)) {
			if((n1==0 || n2 == 0) && (n1!=0 || n2 != 0)) {
				String error = "no se puede dividir entre 0";
				model.addAttribute("error", error);
			}else {
				return n1/n2;
			}
		}
		return 0;
	}

}
