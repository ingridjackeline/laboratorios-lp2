package biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testa todas as funcionalidades da classe CleanSpaces, bem como as possíveis exceções 
 * que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class CleanSpacesTest {

	/**
	 * O algoritmo de transformação CleanSpaces.
	 */
	private CleanSpaces algoritmo;
	
	/**
	 * Prepara o algoritmo de transformação que será utilizado em todos os 
	 * testes de funcionalidade.
	 */
	@BeforeEach
	void setUp() {
		this.algoritmo = new CleanSpaces();
	}
	
	/**
	 * Testa o construtor de CleanSpaces, verificando se o objeto criado apresenta 
	 * o mesmo nome definido internamente.
	 */
	@Test
	void testCleanSpaces() {
		assertEquals(this.algoritmo.getNome(), "cleanSpaces");
	}
	
	/**
	 * Testa o construtor de CleanSpaces, verificando se dois objetos distintos 
	 * apresentam o mesmo nome.
	 */
	@Test
	void testCleanSpacesNomesObjetosDistintos() {
		CleanSpaces algoritmo2 = new CleanSpaces();
		assertEquals(this.algoritmo.getNome(), algoritmo2.getNome());
	}
	
	/**
	 * Testa o método transforma de CleanSpaces, utilizando um texto nulo como 
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
	 * Testa o método transforma de CleanSpaces, utilizando um texto vazio como 
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
	 * Testa o método transforma de CleanSpaces, utilizando um texto com letras 
	 * maiúsculas e minúsculas, sinais de pontuação e espaços.
	 */
	@Test
	void testTransformaTextoComLetrasPontuacaoEEspacos() {
		assertEquals(this.algoritmo.transforma("O pedido apresenta estes itens: Cartolina, Borracha e Lâmpada. Ele já está pronto?"), "Opedidoapresentaestesitens:Cartolina,BorrachaeLâmpada.Elejáestápronto?");
	}

	/**
	 * Testa o método transforma de CleanSpaces, utilizando um texto com números, 
	 * sinais de pontuação e espaços.
	 */
	@Test
	void testTransformaTextoComNumerosPontuacaoEEspacos() {
		assertEquals(this.algoritmo.transforma("(120 + 400 - 90) * 5 / 4"), "(120+400-90)*5/4");
	}

	/**
	 * Testa o método transforma de CleanSpaces, utilizando um texto sem espaços.
	 */
	@Test
	void testTransformaTextoSemEspacos() {
		assertEquals(this.algoritmo.transforma("3Laranjas,2Maçãs,7Morangos,6Uvas."), "3Laranjas,2Maçãs,7Morangos,6Uvas.");
	}
	
}