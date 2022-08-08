package biblioteca;

/**
 * Interface que representa um algoritmo de transformação textual e suas 
 * funcionalidades básicas. As classes que implementarem essa interface 
 * apresentarão os métodos padrões transforma e getNome, podendo desenvolvê-los 
 * de acordo com as suas especificidades.
 * 
 * @author Ingrid Jackeline
 *
 */
public interface AlgoritmoTransformacao {

	/**
	 * Transforma o texto original recebido como parâmetro em um novo texto.
	 * 
	 * @param textoOriginal O texto original recebido.
	 * @return O novo texto criado após a transformação do texto original.
	 */
	public String transforma(String textoOriginal);
	
	/**
	 * Retorna o nome do algoritmo de transformação textual.
	 * 
	 * @return O nome do algoritmo.
	 */
	public String getNome();
	
}