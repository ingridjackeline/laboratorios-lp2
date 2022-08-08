package agenda;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Testa todas as funcionalidades da classe Contato, bem como as possíveis exceções 
 * que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class ContatoTest {
	
	/**
	 * Testa o construtor de Contato com todos os parâmetros válidos.
	 */
	@Test
	void testContatoCasoBase() {
		new Contato("Ingrid", "Jackeline", "(81) 98765-4321");
	}
	
	/**
	 * Testa o construtor de Contato com o nome vazio.
	 */
	@Test
	void testContatoNomeVazio() {
		try {
			new Contato("", "Jackeline", "(81) 98765-4321");
			fail("Não é permitido deixar o nome vazio");
		} catch (IllegalArgumentException iae)	{
			
		}
	}
	
	/**
	 * Testa o construtor de Contato com o nome nulo.
	 */
	@Test
	void testContatoNomeNulo() {
		try {
			new Contato(null, "Jackeline", "(81) 98765-4321");
			fail("Não é permitido deixar o nome nulo");
		} catch (NullPointerException npe)	{
			
		}
	}
	
	/**
	 * Testa o construtor de Contato com o sobrenome nulo.
	 */
	@Test
	void testContatoSobrenomeNulo() {
		try {
			new Contato("Ingrid", null, "(81) 98765-4321");
			fail("Não é permitido deixar o sobrenome nulo");
		} catch (NullPointerException npe)	{
			
		}
	}
	
	/**
	 * Testa o construtor de Contato com o telefone vazio.
	 */
	@Test
	void testContatoTelefoneVazio() {
		try {
			new Contato("Ingrid", "Jackeline", "");
			fail("Não é permitido deixar o telefone vazio");
		} catch (IllegalArgumentException iae)	{
			
		}
	}
	
	/**
	 * Testa o construtor de Contato com o telefone nulo.
	 */
	@Test
	void testContatoTelefoneNulo() {
		try {
			new Contato("Ingrid", "Jackeline", null);
			fail("Não é permitido deixar o telefone nulo");
		} catch (NullPointerException npe)	{
			
		}
	}

	/**
	 * Testa o método setTags de Contato com uma posição de tag abaixo do limite 
	 * inferior.
	 */
	@Test
	void testSetTagsPosicaoAbaixoLimiteInferior() {
		Contato contato = new Contato("Loren", "Narrane", "(81) 92314-6532");
		try {
			contato.setTags(0, "aluna");
			fail("A posição para a tag não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método setTags de Contato com uma posição de tag acima do limite 
	 * superior.
	 */
	@Test
	void testSetTagsPosicaoAcimaLimiteSuperior() {
		Contato contato = new Contato("Loren", "Narrane", "(81) 92314-6532");
		try {
			contato.setTags(6, "aluna");
			fail("A posição para a tag não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}

	/**
	 * Testa o método setTags de Contato com uma posição de tag correspondente ao 
	 * limite inferior.
	 */
	@Test
	void testSetTagsPosicaoLimiteInferior() {
		Contato contato = new Contato("Loren", "Narrane", "(81) 92314-6532");
		contato.setTags(1, "aluna");
	}
	
	/**
	 * Testa o método setTags de Contato com uma posição de tag correspondente ao 
	 * limite superior.
	 */
	@Test
	void testSetTagsPosicaoLimiteSuperior() {
		Contato contato = new Contato("Loren", "Narrane", "(81) 92314-6532");
		contato.setTags(5, "aluna");
	}
	
	/**
	 * Testa o método setTags de Contato com uma tag vazia.
	 */
	@Test
	void testSetTagsTagVazia() {
		Contato contato = new Contato("Loren", "Narrane", "(81) 92314-6532");
		try {
			contato.setTags(2, "");
			fail("Não é permitido deixar a tag vazia");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método setTags de Contato com uma tag nula.
	 */
	@Test
	void testSetTagsTagNula() {
		Contato contato = new Contato("Loren", "Narrane", "(81) 92314-6532");
		try {
			contato.setTags(2, null);
			fail("Não é permitido deixar a tag nula");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método equals de Contato utilizando nomes e sobrenomes iguais em 
	 * ambos os contatos.
	 */
	@Test
	void testEqualsObjectNomesSobrenomesIguais() {
		Contato contato1 = new Contato("Loren", "Narrane", "(81) 92314-6532");
		Contato contato2 = new Contato("Loren", "Narrane", "(85) 95564-8888");
		assertEquals(contato1, contato2);
	}
	
	/**
	 * Testa o método equals de Contato utilizando nomes iguais em ambos os contatos.
	 */
	@Test
	void testEqualsObjectNomesIguais() {
		Contato contato1 = new Contato("Loren", "Narrane", "(82) 94444-6892");
		Contato contato2 = new Contato("Loren", "Julia", "(87) 91254-7435");
		assertNotEquals(contato1, contato2);
	}
	
	/**
	 * Testa o método equals de Contato utilizando sobrenomes iguais em ambos os 
	 * contatos.
	 */
	@Test
	void testEqualsObjectSobrenomesIguais() {
		Contato contato1 = new Contato("Laila", "Naomi", "(87) 94538-1213");
		Contato contato2 = new Contato("Ana", "Naomi", "(82) 95685-6889");
		assertNotEquals(contato1, contato2);
	}
	
	/**
	 * Testa o método equals de Contato utilizando nomes e sobrenomes diferentes em 
	 * ambos os contatos.
	 */
	@Test
	void testEqualsObjectNomesSobrenomesDiferentes() {
		Contato contato1 = new Contato("Loren", "Narrane", "(82) 94444-6892");
		Contato contato2 = new Contato("Laila", "Naomi", "(87) 94538-1213");
		assertNotEquals(contato1, contato2);
	}
	
	/**
	 * Testa o método hashCode de Contato verificando se dois contatos que possuem 
	 * o mesmo nome e sobrenome apresentam o mesmo hashCode.
	 */
	@Test
	void testHashCode() {
		Contato contato1 = new Contato("Loren", "Narrane", "(81) 92314-6532");
		Contato contato2 = new Contato("Loren", "Narrane", "(85) 95564-8888");
		assertEquals(contato1.hashCode(), contato2.hashCode());
	}
	
	/**
	 * Testa o método toString de Contato verificando a exibição de um contato que 
	 * não apresenta tags.
	 */
	@Test
	void testToStringContatoSemTags() {
		Contato contato = new Contato("Laila", "Naomi", "(87) 94538-1213");
		assertEquals("Laila Naomi\n(87) 94538-1213", contato.toString());
	}
	
	/**
	 * Testa o método toString de Contato verificando a exibição de um contato que 
	 * apresenta tags.
	 */
	@Test
	void testToStringContatoComTags() {
		Contato contato = new Contato("Laila", "Naomi", "(87) 94538-1213");
		contato.setTags(1, "aluna");
		contato.setTags(2, "UFCG");
		assertEquals("Laila Naomi\n(87) 94538-1213\naluna UFCG", contato.toString());
	}

}