package dirlididi;


import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Ingrid Jackeline dos Santos Castro - 120110707
 */
public class DobroTriplo {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = 2 * x;
		int z = 3 * x;
		
		System.out.println("dobro: " + y + ", triplo: " + z);
	}
	
}