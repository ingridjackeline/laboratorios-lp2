package biblioteca;

/**
 * Representação do logger Time Console Logger, que registra cada operação 
 * realizada pelo sistema através do método executado e do seu primeiro parâmetro 
 * (se houver), considerando o tempo de execução em milissegundos (ms). Essa 
 * classe implementa a interface Logger, apresentando o seu método padrão 
 * registraOperacao.
 * 
 * @author Ingrid Jackeline
 *
 */
public class TimeConsoleLogger implements Logger {

	/**
	 * O momento em que o objeto da classe foi criado em milissegundos (ms).
	 */
	private long momentoCriacaoObjeto; 
	
	/**
	 * Constrói o logger a partir do momento em que ele é criado em milissegundos (ms).
	 */
	public TimeConsoleLogger() {
		this.momentoCriacaoObjeto = System.currentTimeMillis();
	}
	
	/**
	 * Registra a operação realizada pelo sistema, imprimindo o nome do método 
	 * executado, o seu primeiro parâmetro (se houver) e o momento em milissegundos 
	 * (ms) que essa operação foi realizada em relação ao momento de criação do objeto.
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
		
		long momentoExecucaoMetodo = System.currentTimeMillis() - this.momentoCriacaoObjeto;
		System.out.println("[" + nomeMetodo + " - " + momentoExecucaoMetodo + "ms] " + parametro);
	}
	
}