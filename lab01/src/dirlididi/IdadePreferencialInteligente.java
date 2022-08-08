package dirlididi;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Ingrid Jackeline dos Santos Castro - 120110707
 */
public class IdadePreferencialInteligente {

	public static void main (String[] args) { 
		int idade = 2021 - 2002;
		String condicao = "crianca de colo";
		
		System.out.println("Numero: " + idade);
		
		if (idade >= 60) {
			System.out.println("Preferencial Idoso.");
		} else if (condicao == "gravida") {
			System.out.println("Preferencial Gestante.");
		} else if (condicao == "crianca de colo") {
			int criancas = 2;
			System.out.println("Preferencial pois esta com " + criancas + " criancas de colo.");
		}
	}
	
}