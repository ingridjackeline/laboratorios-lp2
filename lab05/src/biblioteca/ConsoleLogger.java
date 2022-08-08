package biblioteca;

/**
 * Representação do logger Console Logger, que registra cada operação 
 * realizada pelo sistema através do método executado e do seu primeiro 
 * parâmetro recebido (se houver). Essa classe implementa a interface Logger, 
 * apresentando o seu método padrão registraOperacao.
 * 
 * @author Ingrid Jackeline
 *
 */
public class ConsoleLogger implements Logger {

	/**
	 * Registra a operação realizada pelo sistema, imprimindo o nome do 
	 * método executado e o seu primeiro parâmetro (se houver).
	 * 
	 * @param nomeMetodo O nome do método invocado.
	 * @param parametro O primeiro parâmetro recebido pelo método, se houver.
	 */
	@Override
	public void registraOperacao(String nomeMetodo, String parametro) {
		if (nomeMetodo == null || parametro == null) {
			throw new NullPointerException("O parâmetro utilizado não pode ser nulo.");
		} else if (nomeMetodo.isBlank()) {
			throw new IllegalArgumentException("O nome do método não pode ser vazio.");
		}
		
		System.out.println("[" + nomeMetodo + "] " + parametro);
	}
	
}