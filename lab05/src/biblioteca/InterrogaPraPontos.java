package biblioteca;

/**
 * Representação da transformação textual Interroga Pra Pontos, que transforma 
 * todas as interrogações existentes no texto a ser transformado em pontos finais. 
 * Essa classe implementa a interface AlgoritmoTransformacao, apresentando os seus 
 * métodos padrões transforma e getNome.
 * 
 * @author Ingrid Jackeline
 *
 */
public class InterrogaPraPontos implements AlgoritmoTransformacao {

	/**
	 * O nome da transformação textual.
	 */
	private String nome;
	
	/**
	 * Constrói a transformação textual a partir de um nome já definido como 
	 * padrão.
	 */
	public InterrogaPraPontos() {
		this.nome = "InterrogaPraPontos";
	}
	
	/**
	 * Transforma o texto original recebido, trocando cada ponto de interrogação 
	 * existente por um ponto final. 
	 * 
	 * @param textoOriginal O texto original recebido.
	 * @return O novo texto criado após a transformação do texto original.
	 */
	@Override
	public String transforma(String textoOriginal) {
		if (textoOriginal == null) {
			throw new NullPointerException("O texto a ser transformado não pode ser nulo.");
		} else if (textoOriginal.isBlank()) {
			throw new IllegalArgumentException("O texto a ser transformado não pode ser vazio.");
		}
		
		return textoOriginal.replace("?", ".");
	}

	/**
	 * Retorna o nome da transformação textual.
	 * 
	 * @return O nome da transformação textual.
	 */
	@Override
	public String getNome() {
		return this.nome;
	}

}