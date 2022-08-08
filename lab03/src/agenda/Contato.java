package agenda;

/**
 * Representação de um contato. Todo contato possui nome, sobrenome e telefone 
 * e pode apresentar até 5 tags que lhe caracterizam.
 * 
 * @author Ingrid Jackeline
 *
 */
public class Contato {

	/**
	 * O nome do contato.
	 */
	private String nome;
	
	/**
	 * O sobrenome do contato.
	 */
	private String sobrenome;
	
	/**
	 * O telefone do contato.
	 */
	private String telefone;
	
	/**
	 * Contém as tags que caracterizam o contato. Todo contato pode apresentar 
	 * até 5 tags.
	 */
	private String[] tags;
	
	/**
	 * Contrói o contato a partir do seu nome, sobrenome e telefone. O contato 
	 * também é inicializado contendo espaço para 5 tags.
	 * 
	 * @param nome O nome do contato.
	 * @param sobrenome O sobrenome do contato.
	 * @param telefone O telefone do contato.
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		if (nome == null) {
			throw new NullPointerException("O nome não pode ser nulo");
		}
		if (nome.isBlank()) {
			throw new IllegalArgumentException("O nome não pode ser vazio");
		}
		if (sobrenome == null) {
			throw new NullPointerException("O sobrenome não pode ser nulo");
		}
		if (telefone == null) {
			throw new NullPointerException("O telefone não pode ser nulo");
		}
		if (telefone.isBlank()) {
			throw new IllegalArgumentException("O telefone não pode ser vazio");
		}
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.tags = new String[5];
	}
	
	/**
	 * Retorna o nome do contato.
	 * 
	 * @return A representação em String do nome do contato.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o sobrenome do contato.
	 * 
	 * @return A representação em String do sobrenome do contato.
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	/**
	 * Retorna o telefone do contato.
	 * 
	 * @return A representação em String do telefone do contato.
	 */
	public String getTelefone() {
		return this.telefone;
	}
	
	/**
	 * Retorna as tags que o contato possui.
	 * 
	 * @return O array de Strings que contém todas as tags do contato.
	 */
	public String[] getTags() {
		return this.tags;
	}
	
	/**
	 * Define as tags que o contato possui a partir da posição da tag e do seu 
	 * conteúdo.
	 * 
	 * @param posicao A posição da tag dentro do contato.
	 * @param tag A tag a ser adicionada no contato.
	 */
	public void setTags(int posicao, String tag) {
		if (posicao < 1 || posicao > 5) {
			throw new IndexOutOfBoundsException("A posição para a tag não existe");
		}
		if (tag == null) {
			throw new NullPointerException("A tag não pode ser nula");
		}
		if (tag.isBlank()) {
			throw new IllegalArgumentException("A tag não pode ser vazia");
		}
		
		this.tags[posicao - 1] = tag;
	}
	
	/**
	 * Retorna a exibição de todas as tags que o contato possui.
	 * 
	 * @return A representação em String de todas as tags do contato.
	 */
	private String exibeTags() {
		String tagsContato = "";
		for (String tag : tags) {
			if (tag != null) {
				tagsContato += tag + " ";
			}	
		}
		if (tagsContato.equals("")) {
			return tagsContato;
		} else {
			return "\n" + tagsContato.trim();
		}
	}
	
	/**
	 * Sobrescreve o método equals padrão, comparando dois objetos de acordo com 
	 * o seu conteúdo.
	 * 
	 * @return Um valor booleano que define o resultado da comparação feita entre 
	 * os dois objetos.
	 */
	public boolean equals(Object objeto) {
		if (objeto == null) {
			return false;
		}
		if (objeto.getClass() != this.getClass()) {
			return false;
		}
		Contato contato = (Contato) objeto;
		if (this.nome == null || this.sobrenome == null) {
			return false;
		}
		return this.nome.equals(contato.nome) && this.sobrenome.equals(contato.sobrenome);
	}
	
	/**
	 * Sobrescreve o método hashCode padrão, definindo um valor que representa o 
	 * contato de acordo com o seu nome e sobrenome.
	 * 
	 * @return O valor inteiro que representa o contato.
	 */
	public int hashCode() {
		return this.nome.hashCode() + this.sobrenome.hashCode();
	}
	
	/**
	 * Sobrescreve o método toString padrão, retornando a representação textual 
	 * que contém todas as informações do contato.
	 * 
	 * @return A representação em String de todos os detalhes do contato.
	 */
	public String toString() {
		return nome + " " + sobrenome + "\n" + telefone + exibeTags();
	}
	
}