package agenda;

/**
 * Representa uma agenda de contatos. Sua capacidade pode armazenar até 100 contatos. 
 * 
 * @author Ingrid Jackeline
 *
 */
public class Agenda {
	
	/**
	 * Contém todos os contatos cadastrados na agenda.
	 */
	private Contato[] contatos;
	
	/**
	 * Contém todos os contatos favoritados na agenda.
	 */
	private Contato[] contatosFavoritos;
	
	/**
	 * Constrói a agenda de contatos, que é inicializada com espaço para armazenar 
	 * até 100 contatos e favoritar até 10 desses contatos.
	 */
	public Agenda() {
		this.contatos = new Contato[100];
		this.contatosFavoritos = new Contato[10];
	}
	
	/**
	 * Retorna todos os contatos que a agenda possui.
	 * 
	 * @return O array de contatos da agenda.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Retorna um contato específico que a agenda possui.
	 * 
	 * @param posicao A posição do contato a ser acessado.
	 * @return As informações de um contato específico da agenda. 
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao - 1];
	}
	
	/**
	 * Verifica se o cadastro a ser realizado já existe na agenda de contatos através 
	 * do nome e sobrenome especificados.
	 * 
	 * @param nome O nome do contato a ser cadastrado.
	 * @param sobrenome O sobrenome do contato a ser cadastrado.
	 * @return O valor booleano que representa se o cadastro já existe ou não na 
	 * agenda de contatos.
	 */
	public boolean verificaCadastroExistente(String nome, String sobrenome) {
		if (nome == null) {
			throw new NullPointerException("O nome não pode ser nulo");
		}
		if (nome.isBlank()) {
			throw new IllegalArgumentException("O nome não pode ser vazio");
		}
		if (sobrenome == null) {
			throw new NullPointerException("O sobrenome não pode ser nulo");
		}
		
		for (Contato contato : contatos) {
			if (contato != null) {
				if (contato.getNome().equals(nome) && contato.getSobrenome().equals(sobrenome)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Cadastra um contato com todas as suas informações na agenda de contatos. 
	 * Um cadastro em uma posição já ocupada sobrescreve o cadastro anterior. 
	 * 
	 * @param posicao A posição do contato a ser cadastrado.
	 * @param nome O nome do contato a ser cadastrado.
	 * @param sobrenome O sobrenome do contato a ser cadastrado.
	 * @param telefone O telefone do contato a ser cadastrado.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao < 1 || posicao > 100) {
			throw new IndexOutOfBoundsException("A posição para o contato não existe");
		}
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
		if (verificaCadastroExistente(nome, sobrenome)) {
			throw new IllegalArgumentException("O contato já está cadastrado");
		}
		
		this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
	}
	
	/**
	 * Adiciona tags a um contato da agenda de contatos. 
	 * 
	 * @param posicaoContato A posição do contato na agenda.
	 * @param posicaoTag A posição da tag a ser adicionada no contato.
	 * @param tag A tag a ser adicionada no contato.
	 */
	public void adicionaTags(int posicaoContato, int posicaoTag, String tag) {
		if (posicaoContato < 1 || posicaoContato > 100) {
			throw new IndexOutOfBoundsException("A posição para o contato não existe");
		}
		if (contatos[posicaoContato - 1] == null) {
			throw new NullPointerException("O contato não existe");
		}
		if (posicaoTag < 1 || posicaoTag > 5) {
			throw new IndexOutOfBoundsException("A posição para a tag não existe");
		}
		if (tag == null) {
			throw new NullPointerException("A tag não pode ser nula");
		}
		if (tag.isBlank()) {
			throw new IllegalArgumentException("A tag não pode ser vazia");
		}
		
		Contato contato = contatos[posicaoContato - 1];
		contato.setTags(posicaoTag, tag);
	}
	
	/**
	 * Exibe um contato existente através da sua posição na agenda. Esse contato 
	 * pode ou não ser favorito.
	 * 
	 * @param posicao A posição do contato na agenda.
	 * @return A representação em String do contato especificado.
	 */
	public String exibeContato(int posicao) {
		if (posicao < 1 || posicao > 100) {
			throw new IndexOutOfBoundsException("A posição para o contato não existe");
		}
		if (contatos[posicao - 1] == null) {
			throw new NullPointerException("O contato não existe");
		}
		
		Contato contato = contatos[posicao - 1];
		boolean isFavorito = false;
		for (Contato favorito : contatosFavoritos) {
			if (favorito != null && favorito.equals(contato)) {
				isFavorito = true;
				break;
			}
		}
		if (isFavorito == true) {
			return "\n" + "❤️ " + contato.toString();
		} else {
			return "\n" + contato.toString();
		}
	}
	
	/**
	 * Verifica se o contato especificado é favorito na agenda de contatos.
	 * 
	 * @param posicaoContato A posição do contato na agenda.
	 * @return O valor booleano que representa se o contato é favorito ou não na 
	 * agenda de contatos.
	 */
	public boolean verificaFavorito(int posicaoContato) {
		if (posicaoContato < 1 || posicaoContato > 100) {
			throw new IndexOutOfBoundsException("A posição para o contato não existe");
		}
		if (contatos[posicaoContato - 1] == null) {
			throw new NullPointerException("O contato não existe");
		}	
		
		Contato contato = contatos[posicaoContato - 1];
		for (Contato favorito : contatosFavoritos) {
			if (favorito != null && favorito.equals(contato)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adiciona um contato existente à posição de favorito na agenda de contatos.
	 * 
	 * @param posicaoContato A posição do contato a ser favoritado na agenda.
	 * @param posicaoFavorito A posição a ser ocupada pelo contato na lista de 
	 * favoritos.
	 */
	public void adicionaFavorito(int posicaoContato, int posicaoFavorito) {
		if (posicaoContato < 1 || posicaoContato > 100) {
			throw new IndexOutOfBoundsException("A posição para o contato não existe");
		}
		if (posicaoFavorito < 1 || posicaoFavorito > 10) {
			throw new IndexOutOfBoundsException("A posição para o contato favorito não existe");
		}
		if (contatos[posicaoContato - 1] == null) {
			throw new NullPointerException("O contato não existe");
		}
		if (verificaFavorito(posicaoContato)) {
			throw new IllegalArgumentException("O contato já está favoritado");
		}
		this.contatosFavoritos[posicaoFavorito - 1] = contatos[posicaoContato - 1];
	}
	
	/**
	 * Retorna a lista de favoritos existente na agenda de contatos, que contém a 
	 * posição na lista e o nome completo de cada um deles.
	 * 
	 * @return A representação em String de todos os contatos favoritos da agenda.
	 */
	public String listaFavoritos() {
		String listaFavoritos = "";
		for (int i = 0; i < contatosFavoritos.length; i++) {
			Contato favorito = contatosFavoritos[i];
			if (favorito != null) {
				listaFavoritos += "\n" + (i + 1) + " - " + favorito.getNome() + " " + favorito.getSobrenome();
			}
		}
		return listaFavoritos;
	}
	
	/**
	 * Retorna a lista de contatos existente na agenda, que contém a posição na 
	 * lista e o nome completo de cada um deles.
	 * 
	 * @return A representação em String de todos os contatos da agenda.
	 */
	public String toString() {
		String listaContatos = "";
		for (int i = 0; i < contatos.length; i++) {
			Contato contato = contatos[i];
			if (contato != null) {
				listaContatos += "\n" + (i + 1) + " - " + contato.getNome() + " " + contato.getSobrenome();
			}
		}
		return listaContatos;
	}

}