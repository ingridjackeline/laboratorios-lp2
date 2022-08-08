package biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testa todas as funcionalidades da classe InterrogaPraPontos, bem como as possíveis exceções 
 * que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class InterrogaPraPontosTest {
	
	/**
	 * O algoritmo de transformação InterrogaPraPontos.
	 */
	private InterrogaPraPontos algoritmo;
	
	/**
	 * Prepara o algoritmo de transformação que será utilizado em todos os 
	 * testes de funcionalidade.
	 */
	@BeforeEach
	void setUp() {
		this.algoritmo = new InterrogaPraPontos();
	}

	/**
	 * Testa o construtor de InterrogaPraPontos, verificando se o objeto criado apresenta 
	 * o mesmo nome definido internamente.
	 */
	@Test
	void testInterrogaPraPontos() {
		assertEquals(this.algoritmo.getNome(), "InterrogaPraPontos");
	}
	
	/**
	 * Testa o construtor de InterrogaPraPontos, verificando se dois objetos distintos 
	 * apresentam o mesmo nome.
	 */
	@Test
	void testInterrogaPraPontosNomesObjetosDistintos() {
		InterrogaPraPontos algoritmo2 = new InterrogaPraPontos();
		assertEquals(this.algoritmo.getNome(), algoritmo2.getNome());
	}
	
	/**
	 * Testa o método transforma de InterrogaPraPontos, utilizando um texto nulo como 
	 * parâmetro.
	 */
	@Test
	void testTransformaTextoNulo() {
		try {
			this.algoritmo.transforma(null);
			fail("Não é permitido transformar um texto nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método transforma de InterrogaPraPontos, utilizando um texto vazio como 
	 * parâmetro.
	 */
	@Test
	void testTransformaTextoVazio() {
		try {
			this.algoritmo.transforma("");
			fail("Não é permitido transformar um texto vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}

	/**
	 * Testa o método transforma de InterrogaPraPontos, utilizando um texto com interrogações.
	 */
	@Test
	void testTransformaTextoComInterrogacoes() {
		assertEquals(this.algoritmo.transforma("Oi? Tudo bem com você? Seu novo número é 4002-8922???"), "Oi. Tudo bem com você. Seu novo número é 4002-8922...");
	}

	/**
	 * Testa o método transforma de InterrogaPraPontos, utilizando um texto sem interrogações.
	 */
	@Test
	void testTransformaTextoSemInterrogacoes() {
		assertEquals(this.algoritmo.transforma("Oi, eu estou bem! Meu número não é esse. Acho que foi um engano."), "Oi, eu estou bem! Meu número não é esse. Acho que foi um engano.");
	}

}