package biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Testa as funcionalidades da classe ContagemLogger, incluindo as possíveis 
 * exceções que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class ContagemLoggerTest {

	/**
	 * Testa o método registraOperacao de ContagemLogger, utilizando um nome 
	 * de método nulo como parâmetro.
	 */
	@Test
	void testRegistraOperacaoNomeMetodoNulo() {
		try {
			ContagemLogger logger = new ContagemLogger();
			logger.registraOperacao(null, "clean");
			fail("Não é permitido deixar o nome do método nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método registraOperacao de ContagemLogger, utilizando um nome 
	 * de método vazio como parâmetro.
	 */
	@Test
	void testRegistraOperacaoNomeMetodoVazio() {
		try {
			ContagemLogger logger = new ContagemLogger();
			logger.registraOperacao("", "clean");
			fail("Não é permitido deixar o nome do método vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método registraOperacao de ContagemLogger, utilizando um parâmetro nulo.
	 */
	@Test
	void testRegistraOperacaoParametroNulo() {
		try {
			ContagemLogger logger = new ContagemLogger();
			logger.registraOperacao("historico", null);
			fail("Não é permitido deixar o parâmetro nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método registraOperacao de ContagemLogger, verificando se as operações 
	 * registradas foram armazenadas corretamente.
	 */
	@Test
	void testRegistraOperacoesValidas() {
		ContagemLogger logger = new ContagemLogger();
		logger.registraOperacao("cadastraTransformacao", "lowerCase");
		logger.registraOperacao("transforma", "CaMeLcAsEfY");
		logger.registraOperacao("cadastraTransformacao", "upperCase");
		logger.registraOperacao("transforma", "upperCase");
		logger.registraOperacao("transforma", "InterrogaPraPontos");
		logger.registraOperacao("contaTransformacao", "");
		logger.registraOperacao("historico", "0");
		logger.registraOperacao("historico", "1");
		logger.registraOperacao("listaOriginais", "");
		logger.registraOperacao("listaTransformacoes", "");
		logger.registraOperacao("listaOriginais", "");
		logger.registraOperacao("contaTransformacao", "");
		
		assertEquals(logger.getMetodosInvocados().get("cadastraTransformacao"), 2);
		assertEquals(logger.getMetodosInvocados().get("transforma"), 3);
		assertEquals(logger.getMetodosInvocados().get("contaTransformacao"), 2);
		assertEquals(logger.getMetodosInvocados().get("historico"), 2);
		assertEquals(logger.getMetodosInvocados().get("listaOriginais"), 2);
		assertEquals(logger.getMetodosInvocados().get("listaTransformacoes"), 1);
	}

	/**
	 * Testa o método toString de ContagemLogger, verificando a sua exibição sem operações 
	 * registradas.
	 */
	@Test
	void testToStringSemOperacoesRegistradas() {
		ContagemLogger logger = new ContagemLogger();
		assertEquals(logger.toString(), "");
	}
	
	/**
	 * Testa o método toString de ContagemLogger, verificando a sua exibição com operações 
	 * registradas.
	 */
	@Test
	void testToStringComOperacoesRegistradas() {
		ContagemLogger logger = new ContagemLogger();
		logger.registraOperacao("cadastraTransformacao", "lowerCase");
		logger.registraOperacao("transforma", "CaMeLcAsEfY");
		logger.registraOperacao("cadastraTransformacao", "upperCase");
		logger.registraOperacao("transforma", "upperCase");
		logger.registraOperacao("transforma", "InterrogaPraPontos");
		logger.registraOperacao("contaTransformacao", "");
		logger.registraOperacao("historico", "0");
		logger.registraOperacao("historico", "1");
		logger.registraOperacao("listaOriginais", "");
		logger.registraOperacao("listaTransformacoes", "");
		logger.registraOperacao("listaOriginais", "");
		logger.registraOperacao("contaTransformacao", "");
		assertEquals(logger.toString(), "cadastraTransformacao - 2\nlistaOriginais - 2\nlistaTransformacoes - 1\nhistorico - 2\ncontaTransformacao - 2\ntransforma - 3");
	}

}