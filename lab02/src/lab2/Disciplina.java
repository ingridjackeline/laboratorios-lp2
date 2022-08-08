package lab2;

import java.util.Arrays;

/**
 * Representação da disciplina estudada por um aluno. Toda disciplina apresenta notas e é 
 * importante calcular a sua média para verificar o estado de aprovação do estudante.
 * 
 * @author Ingrid Jackeline
 */
public class Disciplina {

	/**
	 * Contém o nome da disciplina estudada pelo aluno.
	 */
	private String nomeDisciplina;
	
	/**
	 * Contém as horas de estudo dedicadas à disciplina.
	 */
	private int horasEstudo;
	
	/**
	 * Contém todas as notas adquiridas pelo aluno na disciplina. Por padrão, toda disciplina
	 * possui 4 notas.
	 */
	private double[] notasDisciplina = new double[4];
	
	/**
	 * Contém a média do estudante na disciplina a partir das suas notas.
	 */
	private double mediaDisciplina;
	
	/**
	 * Constrói a disciplina estudada a partir do seu nome.
	 * 
	 * @param nomeDisciplina o nome da disciplina estudada
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	 * Cadastra as horas de estudo dedicadas pelo estudante à disciplina.
	 * 
	 * @param horas as horas de estudo do aluno
	 */
	public void cadastraHoras(int horas) {
		horasEstudo += horas;
	}
	
	/**
	 * Cadastra as notas adquiridas pelo estudante ao longo da disciplina no Array criado
	 * para contê-las.
	 *  
	 * @param nota o número correspondente à nota "1, 2, 3 ou 4"
	 * @param valorNota o valor da nota adquirida pelo estudante
	 */
	public void cadastraNota(int nota, double valorNota) {
		if (nota > 0 && nota < 5) {
			notasDisciplina[nota - 1] = valorNota;
		}
	}
	
	/**
	 * Retorna um valor booleano referente ao estado de aprovação do estudante a partir
	 * da sua média na disciplina.
	 * 
	 * @return a representação booleana da aprovação ou não do estudante na disciplina
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
	 * a média e as notas do aluno na disciplina. A representação segue o formato "Disciplina 
	 * HorasDeEstudo Média [NotasDaDisciplina]".
	 * 
	 * @return a representação em String do estado do estudante na disciplina
	 */
	public String toString() {
		String stringNotasDisciplina = Arrays.toString(notasDisciplina);
		return nomeDisciplina + " " + horasEstudo + " " + mediaDisciplina + " " + stringNotasDisciplina;
	}
	
}