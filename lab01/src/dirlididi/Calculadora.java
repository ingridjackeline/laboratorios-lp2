package dirlididi;


import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Ingrid Jackeline dos Santos Castro - 120110707
 */
public class Calculadora {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String operador = sc.next();
		
		if ("+-*/".contains(operador)) {
			double num1 = sc.nextFloat();
			double num2 = sc.nextFloat();
			double total = 0;
			
			if (operador.equals("/") && num2 == 0) {
				System.out.println("ERRO");
			} else {
				if (operador.equals("+")) {
					total = num1 + num2;
				} else if (operador.equals("-")) {
					total = num1 - num2;
				} else if (operador.equals("*")) {
					total = num1 * num2;
				} else {
					total = num1 / num2;
				}
				System.out.println("RESULTADO: " + total);	
			}	
		} else {
			System.out.println("ENTRADA INVALIDA");
		}
	}
	
}