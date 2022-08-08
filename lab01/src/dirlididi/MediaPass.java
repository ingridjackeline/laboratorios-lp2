package dirlididi;


import java.util.Scanner;

/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Ingrid Jackeline dos Santos Castro - 120110707
 */
public class MediaPass {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double num1 = sc.nextFloat();
		double num2 = sc.nextFloat();
		double media = (num1 + num2) / 2;
		
		if (media >= 7.0) {
			System.out.println("pass: True!");
		} else {
			System.out.println("pass: False!");
		}
	}
	
}