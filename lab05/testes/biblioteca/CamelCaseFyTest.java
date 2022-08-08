package biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testa todas as funcionalidades da classe CamelCaseFy, bem como as possíveis 
 * exceções que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class CamelCaseFyTest {

	/**
	 * O algoritmo de transformação CamelCaseFy.
	 */
	private CamelCaseFy algoritmo;
	
	/**
	 * Prepara o algoritmo de transformação que será utilizado em todos os 
	 * testes de funcionalidade.
	 */
	@BeforeEach
	void setUp() {
		this.algoritmo = new CamelCaseFy();
	}
	
	/**
	 * Testa o construtor de CamelCaseFy, verificando se o objeto criado 
	 * apresenta o mesmo nome definido internamente.
	 */
	@Test
	void testCamelCaseFy() {
		assertEquals(this.algoritmo.getNome(), "CaMeLcAsEfY");
	}

	/**
	 * Testa o construtor de CamelCaseFy, verificando se dois objetos distintos 
	 * apresentam o mesmo nome.
	 */
	@Test
	void testCamelCaseFyNomesObjetosDistintos() {
		CamelCaseFy algoritmo2 = new CamelCaseFy();
		assertEquals(this.algoritmo.getNome(), algoritmo2.getNome());
	}
	
	/**
	 * Testa o método transforma de CamelCaseFy, utilizando um texto nulo como 
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
	 * Testa o método transforma de CamelCaseFy, utilizando um texto vazio como 
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
	 * Testa o método transforma de CamelCaseFy, utilizando um texto com letras 
	 * minúsculas e sinais de pontuação.
	 */
	@Test
	void testTransformaTextoComLetrasMinusculasEPontuacao() {
		assertEquals(this.algoritmo.transforma("olá, como vc vai? tenho uma notícia: estou me mudando!"), "OlÁ, cOmO Vc vAi? TeNhO UmA NoTíCiA: eStOu mE MuDaNdO!");
	}
	
	/**
	 * Testa o método transforma de CamelCaseFy, utilizando um texto com letras 
	 * maiúsculas e sinais de pontuação.
	 */
	@Test
	void testTransformaTextoComLetrasMaiusculasEPontuacao() {
		assertEquals(this.algoritmo.transforma("#BOM DIA, AMIGOS DO GRUPO! #FELIZ."), "#bOm dIa, AmIgOs dO GrUpO! #FeLiZ.");
	}
	
	/**
	 * Testa o método transforma de CamelCaseFy, utilizando um texto com letras 
	 * alternadas entre maiúsculas e minúsculas e sinais de pontuação.
	 */
	@Test
	void testTransformaTextoComLetrasAlternadasENumeros() {
		assertEquals(this.algoritmo.transforma("o pEdIdO ApReSeNtA 120.768 ItEnS No cArRiNhO"), "O PeDiDo aPrEsEnTa 120.768 iTeNs nO CaRrInHo");
	}
	
	/**
	 * Testa o método transforma de CamelCaseFy, utilizando um texto com números e 
	 * sinais de pontuação.
	 */
	@Test
	void testTransformaTextoComPontuacaoENumeros() {                                    
		assertEquals(this.algoritmo.transforma("1637281924503, @#%&*!()!$'+,-./:;"), "1637281924503, @#%&*!()!$'+,-./:;");
	}
	
}