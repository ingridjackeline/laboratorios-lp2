package biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testa todas as funcionalidades da classe Clean, bem como as possíveis exceções 
 * que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class CleanTest {
	
	/**
	 * O algoritmo de transformação Clean.
	 */
	private Clean algoritmo;
	
	/**
	 * Prepara o algoritmo de transformação que será utilizado em todos os 
	 * testes de funcionalidade.
	 */
	@BeforeEach
	void setUp() {
		this.algoritmo = new Clean();
	}

	/**
	 * Testa o construtor de Clean, verificando se o objeto criado apresenta 
	 * o mesmo nome definido internamente.
	 */
	@Test
	void testClean() {
		assertEquals(this.algoritmo.getNome(), "clean");
	}
	
	/**
	 * Testa o construtor de Clean, verificando se dois objetos distintos 
	 * apresentam o mesmo nome.
	 */
	@Test
	void testCleanNomesObjetosDistintos() {
		Clean algoritmo2 = new Clean();
		assertEquals(this.algoritmo.getNome(), algoritmo2.getNome());
	}
	
	/**
	 * Testa o método transforma de Clean, utilizando um texto nulo como 
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
	 * Testa o método transforma de Clean, utilizando um texto vazio como 
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
	 * Testa o método transforma de Clean, utilizando um texto com letras 
	 * maiúsculas e minúsculas e sinais de pontuação.
	 */
	@Test
	void testTransformaTextoComLetrasEPontuacao() {
		assertEquals(this.algoritmo.transforma("Olá, tudo bem? Tenho uma notícia: estou me mudando."), "Olá tudo bem Tenho uma notícia estou me mudando");
	}
	
	/**
	 * Testa o método transforma de Clean, utilizando um texto com números 
	 * e sinais de pontuação.
	 */
	@Test
	void testTransformaTextoComNumerosEPontuacao() {
		assertEquals(this.algoritmo.transforma("#120.000 - 400% * ($50 + $200) : 30/90#"), "120000  400  50  200  3090");
	}
	
	/**
	 * Testa o método transforma de Clean, utilizando um texto apenas com 
	 * sinais de pontuação.
	 */
	@Test
	void testTransformaTextoApenasComPontuacao() {
		assertEquals(this.algoritmo.transforma("'@#$%&*()_-/+={}[]<>,.;:!?|"), "");
	}
	
	/**
	 * Testa o método transforma de Clean, utilizando um texto que não apresenta 
	 * sinais de pontuação.
	 */
	@Test
	void testTransformaTextoSemPontuacao() {
		assertEquals(this.algoritmo.transforma("O jogo começará às 14h e terminará às 16h"), "O jogo começará às 14h e terminará às 16h");
	}

}