package biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testa todas as funcionalidades da classe VogaisPraEstrelas, bem como as possíveis exceções 
 * que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class VogaisPraEstrelasTest {

	/**
	 * O algoritmo de transformação VogaisPraEstrelas.
	 */
	private VogaisPraEstrelas algoritmo;
	
	/**
	 * Prepara o algoritmo de transformação que será utilizado em todos os 
	 * testes de funcionalidade.
	 */
	@BeforeEach
	void setUp() {
		this.algoritmo = new VogaisPraEstrelas();
	}
	
	/**
	 * Testa o construtor de VogaisPraEstrelas, verificando se o objeto criado apresenta 
	 * o mesmo nome definido internamente.
	 */
	@Test
	void testVogaisPraEstrelas() {
		assertEquals(this.algoritmo.getNome(), "VogaisPraEstrelas");
	}
	
	/**
	 * Testa o construtor de VogaisPraEstrelas, verificando se dois objetos distintos 
	 * apresentam o mesmo nome.
	 */
	@Test
	void testVogaisPraEstrelasNomesObjetosDistintos() {
		VogaisPraEstrelas algoritmo2 = new VogaisPraEstrelas();
		assertEquals(this.algoritmo.getNome(), algoritmo2.getNome());
	}
	
	/**
	 * Testa o método transforma de VogaisPraEstrelas, utilizando um texto nulo como 
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
	 * Testa o método transforma de VogaisPraEstrelas, utilizando um texto vazio como 
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
	 * Testa o método transforma de VogaisPraEstrelas, utilizando um texto com vogais 
	 * minúsculas e sinais de pontuação.
	 */
	@Test
	void testTransformaTextoComVogaisMinusculas() {
		assertEquals(this.algoritmo.transforma("oi, está tudo bem com você?"), "✰✰, ✰st✰ t✰d✰ b✰m c✰m v✰c✰?");
	}
	
	/**
	 * Testa o método transforma de VogaisPraEstrelas, utilizando um texto com vogais 
	 * maiúsculas e sinais de pontuação.
	 */
	@Test
	void testTransformaTextoComVogaisMaiusculas() {
		assertEquals(this.algoritmo.transforma("A LÂMPADA DA CONVENIÊNCIA ESTÁ QUEBRADA!"), "✰ L✰MP✰D✰ D✰ C✰NV✰N✰✰NC✰✰ ✰ST✰ Q✰✰BR✰D✰!");
	}

	/**
	 * Testa o método transforma de VogaisPraEstrelas, utilizando um texto com vogais alternadas 
	 * entre maiúsculas e minúsculas, números e sinais de pontuação.
	 */
	@Test
	void testTransformaTextoComVogaisAlternadasENumeros() {
		assertEquals(this.algoritmo.transforma("oS númErOs 450 e 780 aPresenTAdOs sÃo rEsUltantes dAs tRansfORmAçõEs oCoRRIdAs nO TrânsItO."), "✰S n✰m✰r✰s 450 ✰ 780 ✰Pr✰s✰nT✰d✰s s✰✰ r✰s✰lt✰nt✰s d✰s tR✰nsf✰Rm✰ç✰✰s ✰C✰RR✰d✰s n✰ Tr✰ns✰t✰.");
	}
	
	/**
	 * Testa o método transforma de VogaisPraEstrelas, utilizando um texto sem vogais.
	 */
	@Test
	void testTransformaTextoSemVogais() {
		assertEquals(this.algoritmo.transforma("Blz, td crt cntg?"), "Blz, td crt cntg?");
	}

	/**
	 * Testa o método transforma de VogaisPraEstrelas, utilizando um texto com estrelas.
	 */
	@Test
	void testTransformaTextoComEstrelas() {
		assertEquals(this.algoritmo.transforma("C✰mpr✰✰ 10 l✰r✰nj✰s n✰ f✰✰r✰."), "C✰mpr✰✰ 10 l✰r✰nj✰s n✰ f✰✰r✰.");
	}
	
}