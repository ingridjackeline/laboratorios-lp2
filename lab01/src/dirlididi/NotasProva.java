package dirlididi;


import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Ingrid Jackeline dos Santos Castro - 120110707
 */
public class NotasProva {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int maiorNota = 0;
		int menorNota = 1000;
		int totalNotas = 0;
		int acimaMedia = 0;
		int abaixoMedia = 0;
		
		while (true) {
			String[] alunoNota = sc.nextLine().trim().split(" ");
			
			if (alunoNota[0].equals("-")) {
				break;
			}
			
			int nota = Integer.parseInt(alunoNota[1]);
			totalNotas += nota; 
			
			if (nota > maiorNota) {
				maiorNota = nota;
			} 
			if (nota < menorNota) {
				menorNota = nota;
			}
			if (nota >= 700) {
				acimaMedia += 1;
			} else {
				abaixoMedia += 1;
			}
		}
		
		int quantNotas = acimaMedia + abaixoMedia;
		int media = totalNotas / quantNotas;
		
		System.out.println("maior: " + maiorNota);
		System.out.println("menor: " + menorNota);
		System.out.println("media: " + media);
		System.out.println("acima: " + acimaMedia);
		System.out.println("abaixo: " + abaixoMedia);
	}

}