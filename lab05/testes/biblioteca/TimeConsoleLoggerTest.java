package biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Testa as funcionalidades da classe TimeConsoleLogger, incluindo as possíveis 
 * exceções que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class TimeConsoleLoggerTest {

	/**
	 * Testa o método registraOperacao de TimeConsoleLogger, utilizando um nome 
	 * de método nulo como parâmetro.
	 */
	@Test
	void testRegistraOperacaoNomeMetodoNulo() {
		try {
			TimeConsoleLogger logger = new TimeConsoleLogger();
			logger.registraOperacao(null, "clean");
			fail("Não é permitido deixar o nome do método nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método registraOperacao de TimeConsoleLogger, utilizando um nome 
	 * de método vazio como parâmetro.
	 */
	@Test
	void testRegistraOperacaoNomeMetodoVazio() {
		try {
			TimeConsoleLogger logger = new TimeConsoleLogger();
			logger.registraOperacao("", "clean");
			fail("Não é permitido deixar o nome do método vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método registraOperacao de TimeConsoleLogger, utilizando um parâmetro nulo.
	 */
	@Test
	void testRegistraOperacaoParametroNulo() {
		try {
			TimeConsoleLogger logger = new TimeConsoleLogger();
			logger.registraOperacao("historico", null);
			fail("Não é permitido deixar o parâmetro nulo.");
		} catch (NullPointerException npe) {
			
		}
	}

}