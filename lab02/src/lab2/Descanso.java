package lab2;

/**
 * Representa a rotina de descanso de um estudante de Ciência da Computação da UFCG. 
 * É importante verificar o tempo dedicado pelo estudante ao descanso para definir 
 * o seu estado físico e mental.
 * 
 * @author Ingrid Jackeline
 */
public class Descanso {
	
	/**
	 * Contém as horas que o aluno dedica para descansar.
	 */
	private int horasDescanso;
	
	/**
	 * Contém o número de semanas definidas para a análise do descanso.
	 */
	private int numeroSemanas;

	/**
	 * Define as horas destinadas pelo estudante ao descanso.
	 * 
	 * @param valor o número de horas
	 */
	public void defineHorasDescanso(int valor) {
		horasDescanso = valor;
	}
	
	/**
	 * Define as semanas que compreendem as horas de descanso do aluno.
	 * 
	 * @param valor o número de semanas 
	 */
	public void defineNumeroSemanas(int valor) {
		numeroSemanas = valor;
	}
	
	/**
	 * Retorna o estado do aluno, definido como cansado ou descansado, a partir da média 
	 * obtida pela divisão entre as horas de descanso e o número de semanas.
	 * 
	 * @return a representação em String do estado do aluno
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