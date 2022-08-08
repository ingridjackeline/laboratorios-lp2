package biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Testa as funcionalidades da classe BreakpointLogger, incluindo as possíveis 
 * exceções que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class BreakpointLoggerTest {

	/**
	 * Testa o construtor de BreakpointLogger, utilizando um nome de método nulo 
	 * como parâmetro.
	 */
	@Test
	void testBreakpointLoggerComNomeMetodoNulo() {
		try {
			new BreakpointLogger(null);
			fail("Não é permitido deixar o nome do método nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o construtor de BreakpointLogger, utilizando um nome de método vazio 
	 * como parâmetro.
	 */
	@Test
	void testBreakpointLoggerComNomeMetodoVazio() {
		try {
			new BreakpointLogger("");
			fail("Não é permitido deixar o nome do método vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o construtor de BreakpointLogger, utilizando um nome de método válido.
	 */
	@Test
	void testBreakpointLoggerValido() {
		BreakpointLogger logger = new BreakpointLogger("historico");
		assertEquals(logger.getNomeMetodo(), "historico");
	}

	/**
	 * Testa o método registraOperacao de BreakpointLogger, utilizando um nome 
	 * de método nulo como parâmetro.
	 */
	@Test
	void testRegistraOperacaoNomeMetodoNulo() {
		try {
			BreakpointLogger logger = new BreakpointLogger("historico");
			logger.registraOperacao(null, "0");
			fail("Não é permitido deixar o nome do método nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método registraOperacao de BreakpointLogger, utilizando um nome 
	 * de método vazio como parâmetro.
	 */
	@Test
	void testRegistraOperacaoNomeMetodoVazio() {
		try {
			BreakpointLogger logger = new BreakpointLogger("historico");
			logger.registraOperacao("", "0");
			fail("Não é permitido deixar o nome do método vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método registraOperacao de BreakpointLogger, utilizando um parâmetro nulo.
	 */
	@Test
	void testRegistraOperacaoParametroNulo() {
		try {
			BreakpointLogger logger = new BreakpointLogger("historico");
			logger.registraOperacao("historico", null);
			fail("Não é permitido deixar o parâmetro nulo.");
		} catch (NullPointerException npe) {
			
		}
	}

}