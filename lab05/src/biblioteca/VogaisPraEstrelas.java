package biblioteca;

/**
 * Representação da transformação textual Vogais Pra Estrelas, que transforma 
 * todas as vogais do texto no símbolo de estrela. Essa classe implementa 
 * a interface AlgoritmoTransformacao, apresentando os seus métodos padrões 
 * transforma e getNome.
 * 
 * @author Ingrid Jackeline
 *
 */
public class VogaisPraEstrelas implements AlgoritmoTransformacao {

	/**
	 * O nome da transformação textual.
	 */
	private String nome;
	
	/**
	 * Constrói a transformação textual a partir de um nome já definido como 
	 * padrão.
	 */
	public VogaisPraEstrelas() {
		this.nome = "VogaisPraEstrelas";
	}
	
	/**
	 * Transforma o texto original recebido, trocando todas as vogais existentes 
	 * pelo símbolo de estrela.
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
		
		return textoOriginal.replaceAll("[AEIOUÁÉÍÓÚÂÊÔÃÕaeiouáéíóúâêôãõ]", "✰");	
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