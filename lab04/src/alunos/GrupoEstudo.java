package alunos;

import java.util.HashSet;
import java.util.Objects;

/**
 * Representação de um grupo de estudo. Todo grupo de estudo possui um nome e um conjunto de 
 * alunos, cujo tamanho pode ou não estar definido. Um grupo é identificado unicamente 
 * pelo seu nome, ignorando a diferença entre letras maiúsculas e minúsculas.
 * 
 * @author Ingrid Jackeline
 *
 */
public class GrupoEstudo {

	/**
	 * O nome do grupo.
	 */
	private String nome;
	
	/**
	 * O tamanho do grupo, que pode ou não estar definido. Caso não esteja definido, não  
	 * há limite de alunos que podem ser alocados.
	 */
	private int tamanhoDefinido;
	
	/**
	 * O conjunto de alunos que estão alocados no grupo.
	 */
	private HashSet<Aluno> alunos;
	
	/**
	 * Constrói o grupo de estudo apenas a partir do seu nome. Não há limite de alunos que 
	 * podem ser alocados nele.
	 * 
	 * @param nome O nome do grupo.
	 */
	public GrupoEstudo(String nome) {
		if (nome == null) {
			throw new NullPointerException("O nome do grupo não pode ser nulo.");
		}
		if (nome.isBlank()) {
			throw new IllegalArgumentException("O nome do grupo não pode ser vazio.");
		}
		
		this.nome = nome;
		this.alunos = new HashSet<Aluno>();
	}
	
	/**
	 * Constrói o grupo de estudo a partir do seu nome e do seu tamanho, que restringe o limite 
	 * de alunos a serem alocados.
	 * 
	 * @param nome O nome do grupo.
	 * @param tamanho O tamanho do grupo.
	 */
	public GrupoEstudo(String nome, int tamanho) {
		if (nome == null) {
			throw new NullPointerException("O nome do grupo não pode ser nulo.");
		}
		if (nome.isBlank()) {
			throw new IllegalArgumentException("O nome do grupo não pode ser vazio.");
		}
		if (tamanho <= 0) {
			throw new IllegalArgumentException("O tamanho para o grupo não é permitido.");
		}
		
		this.nome = nome;
		this.tamanhoDefinido = tamanho;
		this.alunos = new HashSet<Aluno>(tamanho);
	}
	
	/**
	 * Retorna o nome do grupo.
	 * 
	 * @return A representação em String do nome do grupo.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o tamanho do grupo. Caso ele não esteja definido, retorna o valor 0.
	 * 
	 * @return A representação inteira do tamanho do grupo.
	 */
	public int getTamanhoDefinido() {
		return this.tamanhoDefinido;
	}
	
	/**
	 * Retorna o conjunto de alunos alocados no grupo.
	 * 
	 * @return O conjunto de alunos do grupo.
	 */
	public HashSet<Aluno> getAlunos() {
		return this.alunos;
	}
	
	/**
	 * Verifica se o grupo de estudo atingiu a capacidade de alunos que podem ser alocados, 
	 * caso o seu tamanho esteja definido.
	 * 
	 * @return Um valor booleano que define se o grupo está cheio ou não.
	 */
	public boolean estaCheio() {
		if (this.tamanhoDefinido != 0 && alunos.size() == this.tamanhoDefinido) {
			return true;
		} 
		return false;
	}
	
	/**
	 * Adiciona o aluno ao grupo de estudo, caso haja espaço livre para alocá-lo.
	 * 
	 * @param aluno O aluno a ser alocado no grupo.
	 * @return Um valor booleano que indica se o aluno foi ou não adicionado ao grupo. O aluno 
	 * não é adicionado se já fizer parte do grupo.
	 */
	public boolean adicionaAluno(Aluno aluno) {
		if (aluno == null) {
			throw new NullPointerException("O aluno a ser adicionado não pode ser nulo.");
		}
		if (estaCheio()) {
			throw new IllegalArgumentException("O grupo já está cheio.");
		}
		
		return this.alunos.add(aluno);
	}
	
	/**
	 * Verifica se um determinado aluno pertence ao grupo de estudo.
	 * 
	 * @param aluno O aluno a ser verificado no grupo.
	 * @return Um valor booleano que define se o aluno pertence ou não ao grupo.
	 */
	public boolean verificaPertinenciaDoAluno(Aluno aluno) {
		if (aluno == null) {
			throw new NullPointerException("O aluno a ser verificado não pode ser nulo.");
		}
		
		return this.alunos.contains(aluno);
	}
	
	/**
	 * Sobrescreve o método hashCode padrão, definindo um valor que representa o grupo 
	 * de estudo de acordo com o seu nome.
	 * 
	 * @return O valor inteiro que representa o grupo de estudo.
	 */
	public int hashCode() {
		return Objects.hash(nome.toUpperCase());
	}

	/**
	 * Sobrescreve o método equals padrão, comparando dois objetos de acordo com o seu 
	 * nome e ignorando a diferença entre letras maiúsculas e minúsculas.
	 * 
	 * @return Um valor booleano que define o resultado da comparação feita entre os 
	 * dois objetos.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoEstudo other = (GrupoEstudo) obj;
		return Objects.equals(nome.toUpperCase(), other.nome.toUpperCase());
	}
	
	/**
	 * Sobrescreve o método toString padrão, retornando a representação textual que 
	 * contém o nome do grupo de estudo.
	 * 
	 * @return A representação em String do nome do grupo.
	 */
	public String toString() {
		return "- " + this.nome;
	}
	
}