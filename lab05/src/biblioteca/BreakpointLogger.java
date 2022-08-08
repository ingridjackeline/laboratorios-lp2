package biblioteca;

/**
 * Representação do logger Breakpoint Logger, que registra uma operação 
 * específica do sistema sempre que esta é executada. Essa classe implementa 
 * a interface Logger, apresentando o seu método padrão registraOperacao.
 * 
 * @author Ingrid Jackeline
 *
 */
public class BreakpointLogger implements Logger {

	/**
	 * O nome do método a ser registrado sempre que for executado.
	 */
	private String nomeMetodo;
	
	/**
	 * Constrói o logger a partir do nome do método a ser registrado sempre 
	 * que o sistema executá-lo.
	 * 
	 * @param nomeMetodo O nome do método a ser registrado.
	 */
	public BreakpointLogger(String nomeMetodo) {
		if (nomeMetodo == null) {
			throw new NullPointerException("O nome do método não pode ser nulo.");
		} else if (nomeMetodo.isBlank()) {
			throw new IllegalArgumentException("O nome do método não pode ser vazio.");
		}
		
		this.nomeMetodo = nomeMetodo;
	}
	
	/**
	 * Retorna o nome do método a ser registrado.
	 * 
	 * @return O nome do método a ser registrado.
	 */
	public String getNomeMetodo() {
		return this.nomeMetodo;
	}
	
	/**
	 * Registra a operação realizada pelo sistema se esta for equivalente 
	 * àquela que foi escolhida durante a criação do objeto, imprimindo o 
	 * seu nome e o seu primeiro parâmetro (se houver) e informando que ela foi 
	 * invocada pelo sistema.
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
		
		if (nomeMetodo.equals(this.nomeMetodo)) {
			System.out.println("[INVOCADO - " + nomeMetodo + "] " + parametro);
		}
	}
	
}