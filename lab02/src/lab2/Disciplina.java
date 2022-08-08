package lab2;

import java.util.Arrays;

/**
 * Representa��o da disciplina estudada por um aluno. Toda disciplina apresenta notas e � 
 * importante calcular a sua m�dia para verificar o estado de aprova��o do estudante.
 * 
 * @author Ingrid Jackeline
 */
public class Disciplina {

	/**
	 * Cont�m o nome da disciplina estudada pelo aluno.
	 */
	private String nomeDisciplina;
	
	/**
	 * Cont�m as horas de estudo dedicadas � disciplina.
	 */
	private int horasEstudo;
	
	/**
	 * Cont�m todas as notas adquiridas pelo aluno na disciplina. Por padr�o, toda disciplina
	 * possui 4 notas.
	 */
	private double[] notasDisciplina = new double[4];
	
	/**
	 * Cont�m a m�dia do estudante na disciplina a partir das suas notas.
	 */
	private double mediaDisciplina;
	
	/**
	 * Constr�i a disciplina estudada a partir do seu nome.
	 * 
	 * @param nomeDisciplina o nome da disciplina estudada
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	 * Cadastra as horas de estudo dedicadas pelo estudante � disciplina.
	 * 
	 * @param horas as horas de estudo do aluno
	 */
	public void cadastraHoras(int horas) {
		horasEstudo += horas;
	}
	
	/**
	 * Cadastra as notas adquiridas pelo estudante ao longo da disciplina no Array criado
	 * para cont�-las.
	 *  
	 * @param nota o n�mero correspondente � nota "1, 2, 3 ou 4"
	 * @param valorNota o valor da nota adquirida pelo estudante
	 */
	public void cadastraNota(int nota, double valorNota) {
		if (nota > 0 && nota < 5) {
			notasDisciplina[nota - 1] = valorNota;
		}
	}
	
	/**
	 * Retorna um valor booleano referente ao estado de aprova��o do estudante a partir
	 * da sua m�dia na disciplina.
	 * 
	 * @return a representa��o booleana da aprova��o ou n�o do estudante na disciplina
	 */
	public boolean aprovado() {
		double totalNotas = 0;
		for (double nota : notasDisciplina) {
			totalNotas += nota;
		}
		mediaDisciplina = totalNotas / 4;
		if (mediaDisciplina >= 7.0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Retorna uma String que apresenta o nome da disciplina, as horas de estudo dedicadas, 
	 * a m�dia e as notas do aluno na disciplina. A representa��o segue o formato "Disciplina 
	 * HorasDeEstudo M�dia [NotasDaDisciplina]".
	 * 
	 * @return a representa��o em String do estado do estudante na disciplina
	 */
	public String toString() {
		String stringNotasDisciplina = Arrays.toString(notasDisciplina);
		return nomeDisciplina + " " + horasEstudo + " " + mediaDisciplina + " " + stringNotasDisciplina;
	}
	
}