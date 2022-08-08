package dirlididi;


import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Ingrid Jackeline dos Santos Castro - 120110707
 */
public class FuncaoMonotona {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int valorAnterior = 0;
		int ehCrescente = 0;
		int ehDecrescente = 0;
		
		for (int i = 1; i < 5; i++) {
			int valor = sc.nextInt();
			
			if (i != 1 && valor > valorAnterior) {
				ehCrescente += 1;
			} else if (i != 1 && valor < valorAnterior) {
				ehDecrescente += 1;
			}
			
			valorAnterior = valor;
		}	
		
		if (ehCrescente == 3) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
		} else if (ehDecrescente == 3) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
		} else {
			System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
		}
	}

}