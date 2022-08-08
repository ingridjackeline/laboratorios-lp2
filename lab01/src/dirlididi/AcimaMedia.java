package dirlididi;


import java.util.Scanner;


/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Ingrid Jackeline dos Santos Castro - 120110707
 */
public class AcimaMedia {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] valores = sc.nextLine().split(" ");
		int soma = 0;
		
		for (int i = 0; i < valores.length; i++) {
			soma += Integer.parseInt(valores[i]);
		}
		
		int media = soma / valores.length;
		String valoresAcimaMedia = "";
		
		for (int i = 0; i < valores.length; i++) {
			int valorInteiro = Integer.parseInt(valores[i]);
			if (valorInteiro > media) {
				valoresAcimaMedia += valores[i] + " ";
			}
		}
		
		System.out.println(valoresAcimaMedia);
	}

}