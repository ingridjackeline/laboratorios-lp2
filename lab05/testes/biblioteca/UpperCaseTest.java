package biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testa todas as funcionalidades da classe UpperCase, bem como as possíveis exceções 
 * que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class UpperCaseTest {
	
	/**
	 * O algoritmo de transformação UpperCase.
	 */
	private UpperCase algoritmo;
	
	/**
	 * Prepara o algoritmo de transformação que será utilizado em todos os 
	 * testes de funcionalidade.
	 */
	@BeforeEach
	void setUp() {
		this.algoritmo = new UpperCase();
	}

	/**
	 * Testa o construtor de UpperCase, verificando se o objeto criado apresenta 
	 * o mesmo nome definido internamente.
	 */
	@Test
	void testUpperCase() {
		assertEquals(this.algoritmo.getNome(), "upperCase");
	}
	
	/**
	 * Testa o construtor de UpperCase, verificando se dois objetos distintos 
	 * apresentam o mesmo nome.
	 */
	@Test
	void testUpperCaseNomesObjetosDistintos() {
		UpperCase algoritmo2 = new UpperCase();
		assertEquals(this.algoritmo.getNome(), algoritmo2.getNome());
	}
	
	/**
	 * Testa o método transforma de UpperCase, utilizando um texto nulo como 
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
	 * Testa o método transforma de UpperCase, utilizando um texto vazio como 
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
	 * Testa o método transforma de UpperCase, utilizando um texto com letras minúsculas 
	 * e sinais de pontuação.
	 */
	@Test
	void testTransformaTextoComLetrasMinusculas() {
		assertEquals(this.algoritmo.transforma("oi, como vc vai?"), "OI, COMO VC VAI?");
	}

	/**
	 * Testa o método transforma de UpperCase, utilizando um texto com letras maiúsculas 
	 * e sinais de pontuação.
	 */
	@Test
	void testTransformaTextoComLetrasMaiusculas() {
		assertEquals(this.algoritmo.transforma("A LOJA ESTÁ EM PROMOÇÃO! VENHA CONFERIR AS OFERTAS!"), "A LOJA ESTÁ EM PROMOÇÃO! VENHA CONFERIR AS OFERTAS!");
	}
	
	/**
	 * Testa o método transforma de UpperCase, utilizando um texto com letras alternadas 
	 * entre maiúsculas e minúsculas, números e sinais de pontuação.
	 */
	@Test
	void testTransformaTextoComLetrasAlternadasENumeros() {
		assertEquals(this.algoritmo.transforma("A MaTrÍcUla dO AlUnO É 1456892932. ElA Já eStÁ CaDaStRaDa nO SiStEmA!!"), "A MATRÍCULA DO ALUNO É 1456892932. ELA JÁ ESTÁ CADASTRADA NO SISTEMA!!");
	}
	
	/**
	 * Testa o método transforma de UpperCase, utilizando um texto sem letras.
	 */
	@Test
	void testTransformaTextoSemLetras() {
		assertEquals(this.algoritmo.transforma("(130 + 356) * 2 / 45, 7 ** 4?!"), "(130 + 356) * 2 / 45, 7 ** 4?!");
	}

}