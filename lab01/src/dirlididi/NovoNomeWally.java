package dirlididi;


import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Ingrid Jackeline dos Santos Castro - 120110707
 */
public class NovoNomeWally {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String[] nomes = sc.nextLine().trim().split(" ");
			
			if (nomes[0].equals("wally")) {
				break;
			}
			
			String novoNome = "";
			
			for (String nome : nomes) {
				if (nome.length() == 5) {
					novoNome = nome;
				}
			}
			
			if (novoNome.equals("")) {
				System.out.println("?");
			} else {
				System.out.println(novoNome);
			}
		}
	}
	
}