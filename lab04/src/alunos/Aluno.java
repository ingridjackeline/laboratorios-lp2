package alunos;

import java.util.Objects;

/**
 * Representação de um aluno. Todo aluno possui matrícula, nome e curso associados 
 * e é identificado unicamente pela sua matrícula.
 * 
 * @author Ingrid Jackeline
 *
 */
public class Aluno {

	/**
	 * A matrícula do aluno, responsável por identificá-lo unicamente.
	 */
	private String matricula;
	
	/**
	 * O nome do aluno.
	 */
	private String nome;
	
	/**
	 * O curso no qual o aluno está inserido.
	 */
	private String curso;
	
	/**
	 * Constrói o aluno a partir da sua matrícula, do seu nome e do seu curso. 
	 * 
	 * @param matricula A matrícula do aluno.
	 * @param nome O nome do aluno.
	 * @param curso O curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (matricula == null) {
			throw new NullPointerException("A matrícula do aluno não pode ser nula.");
		} 
		if (matricula.isBlank()) {
			throw new IllegalArgumentException("A matrícula do aluno não pode ser vazia.");
		}
		if (nome == null) {
			throw new NullPointerException("O nome do aluno não pode ser nulo.");
		}
		if (nome.isBlank()) {
			throw new IllegalArgumentException("O nome do aluno não pode ser vazio.");
		}
		if (curso == null) {
			throw new NullPointerException("O curso do aluno não pode ser nulo.");
		}
		if (curso.isBlank()) {
			throw new IllegalArgumentException("O curso do aluno não pode ser vazio.");
		}
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * Retorna a matrícula do aluno.
	 * 
	 * @return A representação em String da matrícula do aluno.
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * Retorna o nome do aluno.
	 * 
	 * @return A representação em String do nome do aluno.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o curso do aluno.
	 * 
	 * @return A representação em String do curso do aluno.
	 */
	public String getCurso() {
		return this.curso;
	}
	
	/**
	 * Sobrescreve o método hashCode padrão, definindo um valor que representa o aluno 
	 * de acordo com a sua matrícula.
	 * 
	 * @return O valor inteiro que representa o aluno.
	 */
	public int hashCode() {
		return Objects.hash(matricula);
	}

	/**
	 * Sobrescreve o método equals padrão, comparando dois objetos de acordo com as suas 
	 * respectivas matrículas.
	 * 
	 * @return Um valor booleano que define o resultado da comparação feita entre os dois 
	 * objetos.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	/**
	 * Sobrescreve o método toString padrão, retornando uma representação textual que contém 
	 * todas as informações do aluno.
	 * 
	 * @return A representação em String de todos os detalhes do aluno.
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
	
}