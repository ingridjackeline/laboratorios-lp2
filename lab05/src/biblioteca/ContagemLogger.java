package biblioteca;

import java.util.HashMap;
import java.util.Map;

/**
 * Representação do logger Contagem Logger, que registra todas as operações 
 * realizadas pelo sistema e a quantidade de vezes em que cada uma delas é 
 * executada. Essa classe implementa a interface Logger, apresentando o seu 
 * método padrão registraOperacao.
 * 
 * @author Ingrid Jackeline
 *
 */
public class ContagemLogger implements Logger {

	/**
	 * Armazena todos os métodos invocados durante a execução do sistema, 
	 * associando cada um deles à quantidade de vezes em que essa invocação 
	 * é feita.
	 */
	private Map<String, Integer> metodosInvocados;
	
	/**
	 * Constrói o logger que armazena todos os métodos invocados e a quantidade de 
	 * vezes em que estes são invocados durante a execução do sistema.
	 */
	public ContagemLogger() {
		this.metodosInvocados = new HashMap<String, Integer>();
	}
	
	/**
	 * Retorna uma associação entre cada método invocado e a quantidade de vezes em 
	 * que essa invocação ocorre.
	 * 
	 * @return Todos os métodos e a quantidade de vezes em que eles são invocados.
	 */
	public Map<String, Integer> getMetodosInvocados() {
		return this.metodosInvocados;
	}
	/**
	 * Registra a operação realizada pelo sistema, considerando o nome do método 
	 * executado e fazendo uma atualização da contagem a cada vez em que ele 
	 * é invocado novamente, se acontecer. 
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
		
		if (this.metodosInvocados.containsKey(nomeMetodo)) {
			int numInvocacao = this.metodosInvocados.get(nomeMetodo);
			this.metodosInvocados.put(nomeMetodo, numInvocacao + 1);
		} else {
			this.metodosInvocados.put(nomeMetodo, 1);
		}
	}
	
	/**
	 * Representa textualmente todos os métodos invocados durante a execução 
	 * do sistema, associando-os à quantidade de vezes em que são invocados.
	 * 
	 * @return A representação em String de todos os métodos e a quantidade de 
	 * vezes em que são invocados pelo sistema.
	 */
	public String toString() {
		String metodosInvocados = "";
		for (String metodo : this.metodosInvocados.keySet()) {
			int numInvocacao = this.metodosInvocados.get(metodo);
			metodosInvocados += metodo + " - " + numInvocacao + "\n";
		}
		return metodosInvocados.trim();
	}
	
}