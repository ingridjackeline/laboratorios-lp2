package biblioteca;

/**
 * Representação da transformação textual Upper Case, que coloca todos 
 * os caracteres do texto a ser transformado em caixa alta. Essa classe 
 * implementa a interface AlgoritmoTransformacao, apresentando os seus 
 * métodos padrões transforma e getNome.
 * 
 * @author Ingrid Jackeline
 *
 */
public class UpperCase implements AlgoritmoTransformacao {
	
	/**
	 * O nome da transformação textual.
	 */
	private String nome;

	/**
	 * Constrói a transformação textual a partir de um nome já definido como 
	 * padrão.
	 */
	public UpperCase() {
		this.nome = "upperCase";
	}
	
	/**
	 * Transforma o texto original recebido, deixando todos os seu caracteres 
	 * em caixa alta.
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
		
		return textoOriginal.toUpperCase();
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