package lab2;

/**
 * Representa a rotina de descanso de um estudante de Ci�ncia da Computa��o da UFCG. 
 * � importante verificar o tempo dedicado pelo estudante ao descanso para definir 
 * o seu estado f�sico e mental.
 * 
 * @author Ingrid Jackeline
 */
public class Descanso {
	
	/**
	 * Cont�m as horas que o aluno dedica para descansar.
	 */
	private int horasDescanso;
	
	/**
	 * Cont�m o n�mero de semanas definidas para a an�lise do descanso.
	 */
	private int numeroSemanas;

	/**
	 * Define as horas destinadas pelo estudante ao descanso.
	 * 
	 * @param valor o n�mero de horas
	 */
	public void defineHorasDescanso(int valor) {
		horasDescanso = valor;
	}
	
	/**
	 * Define as semanas que compreendem as horas de descanso do aluno.
	 * 
	 * @param valor o n�mero de semanas 
	 */
	public void defineNumeroSemanas(int valor) {
		numeroSemanas = valor;
	}
	
	/**
	 * Retorna o estado do aluno, definido como cansado ou descansado, a partir da m�dia 
	 * obtida pela divis�o entre as horas de descanso e o n�mero de semanas.
	 * 
	 * @return a representa��o em String do estado do aluno
	 */
	public String getStatusGeral() {
		String statusAluno = "cansado";
		if (numeroSemanas != 0) {
			int mediaDescanso = horasDescanso / numeroSemanas;
			if (mediaDescanso >= 26) {
				statusAluno = "descansado";
			}
		}
		return statusAluno;
	}
	
}