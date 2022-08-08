package lab2;

/**
 * Representa��o do registro de tempo online dedicado por um estudante a uma dada disciplina.
 * Cada disciplina possui uma carga hor�ria e cada estudante deve dedicar o dobro de tempo 
 * definido por essa carga aos seus estudos.
 * 
 * @author Ingrid Jackeline
 */
public class RegistroTempoOnline {
	
	/**
	 * Cont�m o nome da disciplina estudada pelo aluno.
	 */
	private String nomeDisciplina;
	
	/**
	 * Cont�m o tempo online que deve ser dedicado ao estudo da disciplina.
	 */
	private int tempoOnlineEsperado = 120;
	
	/**
	 * Cont�m o tempo online utilizado pelo aluno para o estudo da disciplina.
	 */
	private int tempoOnlineUtilizado;
	
	/**
	 * Constr�i o registro de tempo online com base apenas no nome da disciplina.
	 * 
	 * @param nomeDisciplina o nome da disciplina estudada
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	 * Constr�i o registro de tempo online com base no nome da disciplina e no tempo 
	 * online esperado de dedica��o a ela.
	 * 
	 * @param nomeDisciplina o nome da disciplina estudada
	 * @param tempoOnlineEsperado o tempo online esperado que o aluno dedique � disciplina
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	/**
	 * Adiciona horas ao tempo online utilizado pelo estudante para se dedicar � disciplina.
	 * 
	 * @param tempo o n�mero de horas utilizadas para a disciplina
	 */
	public void adicionaTempoOnline(int tempo) {
		tempoOnlineUtilizado += tempo;
	}
	
	/**
	 * Retorna um valor booleano referente ao tempo online utilizado para a disciplina, que evidencia se o aluno 
	 * atingiu o tempo online esperado ou n�o.
	 * 
	 * @return a representa��o booleana da meta atingida ou n�o pelo tempo online do estudante
	 */
	public boolean atingiuMetaTempoOnline() {
		if (tempoOnlineUtilizado >= tempoOnlineEsperado) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Retorna uma String que apresenta o nome da disciplina e a rela��o entre o tempo online dedicado 
	 * pelo aluno e o tempo online esperado para a disciplina. A representa��o segue o formato
	 * "NomedaDisciplina TempoOnlineUtilizado/TempoOnlineEsperado".
	 * 
	 * @return a representa��o em String do registro de tempo online do estudante na disciplina
	 */
	public String toString() {
		return nomeDisciplina + " " + tempoOnlineUtilizado + "/" + tempoOnlineEsperado;
	}
	
}