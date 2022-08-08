package biblioteca;

/**
 * Interface que representa um logger e a sua funcionalidade básica de 
 * realizar registros do sistema. As classes que implementarem essa interface 
 * apresentarão o método padrão registraOperacao, podendo desenvolvê-lo de 
 * acordo com as suas especificidades.
 * 
 * @author Ingrid Jackeline
 *
 */
public interface Logger {

	/**
	 * Registra as operações feitas pelo sistema, apresentando os métodos 
	 * invocados durante a sua execução.
	 * 
	 * @param nomeMetodo O nome do método invocado.
	 * @param parametro O primeiro parâmetro recebido pelo método, se houver.
	 */
	public void registraOperacao(String nomeMetodo, String parametro);
	
}