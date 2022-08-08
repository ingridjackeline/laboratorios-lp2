package biblioteca;

/**
 * Representação da transformação textual Camel Case Fy, que alterna os 
 * caracteres do texto a ser transformado para caixa alta ou caixa baixa 
 * dependendo das suas posições na String. Essa classe implementa a interface 
 * AlgoritmoTransformacao, apresentando os seus métodos padrões transforma e 
 * getNome.
 * 
 * @author Ingrid Jackeline
 *
 */
public class CamelCaseFy implements AlgoritmoTransformacao {
	
	/**
	 * O nome da transformação textual.
	 */
	private String nome;

	/**
	 * Constrói a transformação textual a partir de um nome já definido como 
	 * padrão.
	 */
	public CamelCaseFy() {
		this.nome = "CaMeLcAsEfY";
	}
	
	/**
	 * Transforma o texto original recebido, colocando os caracteres que estão 
	 * nas posições pares em caixa alta e os caracteres que estão nas posições 
	 * ímpares em caixa baixa.
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
		
		String textoTransformado = "";
		for (int i = 0; i < textoOriginal.length(); i++) {
			char c = textoOriginal.charAt(i);
			String caractere = Character.toString(c);
			if (i % 2 == 0) {
				textoTransformado += caractere.toUpperCase();
			} else {
				textoTransformado += caractere.toLowerCase();
			}
		}
		return textoTransformado;
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