package alunos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Testa todas as funcionalidades da classe GrupoEstudo, bem como as possíveis exceções 
 * que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class GrupoEstudoTest {

	/**
	 * Testa o construtor de GrupoEstudo, que apenas recebe o nome, com um nome válido.
	 */
	@Test
	void testGrupoEstudoConstrutorNomeCasoBase() {
		new GrupoEstudo("Coleções");
	}
	
	/**
	 * Testa o construtor de GrupoEstudo, que apenas recebe o nome, com um nome vazio.
	 */
	@Test
	void testGrupoEstudoConstrutorNomeComNomeVazio() {
		try {
			new GrupoEstudo("");
			fail("Não é permitido deixar o nome do grupo vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o construtor de GrupoEstudo, que apenas recebe o nome, com um nome nulo.
	 */
	@Test
	void testGrupoEstudoConstrutorNomeComNomeNulo() {
		try {
			new GrupoEstudo(null);
			fail("Não é permitido deixar o nome do grupo nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o construtor de GrupoEstudo, que recebe nome e tamanho, com todos os 
	 * parâmetros válidos.
	 */
	@Test
	void testGrupoEstudoConstrutorNomeETamanhoCasoBase() {
		new GrupoEstudo("Coleções", 10);
	}
	
	/**
	 * Testa o construtor de GrupoEstudo, que recebe nome e tamanho, com o nome vazio.
	 */
	@Test
	void testGrupoEstudoConstrutorNomeETamanhoComNomeVazio() {
		try {
			new GrupoEstudo("", 10);
			fail("Não é permitido deixar o nome do grupo vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o construtor de GrupoEstudo, que recebe nome e tamanho, com o nome nulo.
	 */
	@Test
	void testGrupoEstudoConstrutorNomeETamanhoComNomeNulo() {
		try {
			new GrupoEstudo(null, 10);
			fail("Não é permitido deixar o nome do grupo nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o construtor de GrupoEstudo, que recebe nome e tamanho, com o tamanho 
	 * abaixo do limite inferior permitido.
	 */
	@Test
	void testGrupoEstudoConstrutorNomeETamanhoComTamanhoAbaixoDoLimiteInferior() {
		try {
			new GrupoEstudo("Listas", 0);
			fail("O tamanho para o grupo não é permitido.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o construtor de GrupoEstudo, que recebe nome e tamanho, com o tamanho no 
	 * limite inferior permitido.
	 */
	@Test
	void testGrupoEstudoConstrutorNomeETamanhoComTamanhoNoLimiteInferior() {
		new GrupoEstudo("Listas", 1);
	}
	
	/**
	 * Testa o método estaCheio de GrupoEstudo, verificando se um grupo que não possui 
	 * tamanho definido está cheio.
	 */
	@Test
	void testGrupoSemTamanhoDefinidoEstaCheio() {
		GrupoEstudo grupoEstudo = new GrupoEstudo("Listas");
		Aluno aluno1 = new Aluno("250", "Ingrid Jackeline", "Computação");
		Aluno aluno2 = new Aluno("260", "Jacksivam Ponciano", "Design");
		Aluno aluno3 = new Aluno("270", "Tânia Maria", "Farmácia");
		grupoEstudo.adicionaAluno(aluno1);
		grupoEstudo.adicionaAluno(aluno2);
		grupoEstudo.adicionaAluno(aluno3);
		assertFalse(grupoEstudo.estaCheio());
	}
	
	/**
	 * Testa o método estaCheio de GrupoEstudo, verificando que um grupo com tamanho 
	 * definido ainda não está cheio.
	 */
	@Test
	void testGrupoComTamanhoDefinidoNaoEstaCheio() {
		GrupoEstudo grupoEstudo = new GrupoEstudo("Listas", 4);
		Aluno aluno1 = new Aluno("250", "Ingrid Jackeline", "Computação");
		Aluno aluno2 = new Aluno("260", "Jacksivam Ponciano", "Design");
		Aluno aluno3 = new Aluno("270", "Tânia Maria", "Farmácia");
		grupoEstudo.adicionaAluno(aluno1);
		grupoEstudo.adicionaAluno(aluno2);
		grupoEstudo.adicionaAluno(aluno3);
		assertFalse(grupoEstudo.estaCheio());
	}
	
	/**
	 * Testa o método estaCheio de GrupoEstudo, verificando que um grupo com tamanho 
	 * definido está cheio.
	 */
	@Test
	void testGrupoComTamanhoDefinidoEstaCheio() {
		GrupoEstudo grupoEstudo = new GrupoEstudo("Listas", 4);
		Aluno aluno1 = new Aluno("250", "Ingrid Jackeline", "Computação");
		Aluno aluno2 = new Aluno("260", "Jacksivam Ponciano", "Design");
		Aluno aluno3 = new Aluno("270", "Tânia Maria", "Farmácia");
		Aluno aluno4 = new Aluno("280", "Angélica Moura", "Comunicação Social");
		grupoEstudo.adicionaAluno(aluno1);
		grupoEstudo.adicionaAluno(aluno2);
		grupoEstudo.adicionaAluno(aluno3);
		grupoEstudo.adicionaAluno(aluno4);
		assertTrue(grupoEstudo.estaCheio());
	}

	/**
	 * Testa o método adicionaAluno de GrupoEstudo, adicionando um aluno nulo a um 
	 * grupo.
	 */
	@Test
	void adicionaAlunoNuloAoGrupo() {
		try {
			GrupoEstudo grupoEstudo = new GrupoEstudo("Listas", 4);
			grupoEstudo.adicionaAluno(null);
			fail("Não é permitido adicionar um aluno nulo ao grupo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método adicionaAluno de GrupoEstudo, adicionando um aluno válido a um 
	 * grupo.
	 */
	@Test
	void testAdicionaAlunoAoGrupoVazio() {
		GrupoEstudo grupoEstudo = new GrupoEstudo("Listas");
		Aluno aluno = new Aluno("250", "Ingrid Jackeline", "Computação");
		grupoEstudo.adicionaAluno(aluno);
		assertTrue(grupoEstudo.getAlunos().contains(aluno));
	}
	
	/**
	 * Testa o método adicionaAluno de GrupoEstudo, adicionando um aluno a um grupo que 
	 * já está cheio.
	 */
	@Test
	void testAdicionaAlunoAoGrupoCheio() {
		try {
			GrupoEstudo grupoEstudo = new GrupoEstudo("Listas", 2);
			Aluno aluno1 = new Aluno("250", "Ingrid Jackeline", "Computação");
			Aluno aluno2 = new Aluno("280", "Angélica Moura", "Comunicação Social");
			Aluno aluno3 = new Aluno("270", "Tânia Maria", "Farmácia");
			grupoEstudo.adicionaAluno(aluno1);
			grupoEstudo.adicionaAluno(aluno2);
			grupoEstudo.adicionaAluno(aluno3);
			fail("O grupo já está cheio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método adicionaAluno de GrupoEstudo, adicionando um aluno a um grupo 
	 * mais de uma vez. O grupo de estudo não lança exceção para esse cenário, apenas 
	 * não realiza a operação internamente.
	 */
	@Test
	void testAdicionaAlunoAoGrupoMaisDeUmaVez() {
		GrupoEstudo grupoEstudo = new GrupoEstudo("Listas");
		Aluno aluno = new Aluno("250", "Ingrid Jackeline", "Computação");
		assertTrue(grupoEstudo.adicionaAluno(aluno));
		assertFalse(grupoEstudo.adicionaAluno(aluno));
	}

	/**
	 * Testa o método verificaPertinenciaDoAluno de GrupoEstudo, verificando se um aluno 
	 * nulo pertence ao grupo.
	 */
	@Test
	void verificaPertinenciaDeAlunoNuloAoGrupo() {
		try {
			GrupoEstudo grupoEstudo = new GrupoEstudo("Listas", 4);
			grupoEstudo.verificaPertinenciaDoAluno(null);
			fail("Não é permitido verificar se um aluno nulo pertence ao grupo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método verificaPertinenciaDoAluno de GrupoEstudo, verificando um aluno que 
	 * não pertence ao grupo.
	 */
	@Test
	void testVerificaAlunoNaoPertenceAoGrupo() {
		GrupoEstudo grupoEstudo = new GrupoEstudo("Mapas");
		Aluno aluno = new Aluno("260", "Jacksivam Ponciano", "Design");
		assertFalse(grupoEstudo.verificaPertinenciaDoAluno(aluno));
	}
	
	/**
	 * Testa o método verificaPertinenciaDoAluno de GrupoEstudo, verificando um aluno que 
	 * pertence ao grupo.
	 */
	@Test
	void testVerificaAlunoPertenceAoGrupo() {
		GrupoEstudo grupoEstudo = new GrupoEstudo("Mapas");
		Aluno aluno = new Aluno("270", "Tânia Maria", "Farmácia");
		grupoEstudo.adicionaAluno(aluno);
		assertTrue(grupoEstudo.verificaPertinenciaDoAluno(aluno));
	}
	
	/**
	 * Testa o método hashCode de GrupoEstudo, verificando se dois grupos que possuem 
	 * o mesmo nome, com a mesma case, apresentam o mesmo hashCode.
	 */
	@Test
	void testHashCodeGruposComNomesIguaisECaseIgual() {
		GrupoEstudo grupoEstudo1 = new GrupoEstudo("Mapas");
		GrupoEstudo grupoEstudo2 = new GrupoEstudo("Mapas", 7);
		assertEquals(grupoEstudo1.hashCode(), grupoEstudo2.hashCode());
	}
	
	/**
	 * Testa o método hashCode de GrupoEstudo, verificando se dois grupos que possuem 
	 * o mesmo nome, mas com cases diferentes, apresentam o mesmo hashCode.
	 */
	@Test
	void testHashCodeGruposComNomesIguaisECaseDiferente() {
		GrupoEstudo grupoEstudo1 = new GrupoEstudo("Mapas", 4);
		GrupoEstudo grupoEstudo2 = new GrupoEstudo("MAPAS");
		assertEquals(grupoEstudo1.hashCode(), grupoEstudo2.hashCode());
	}
	
	/**
	 * Testa o método equals de GrupoEstudo, utilizando nomes iguais e com a mesma case 
	 * em ambos os grupos.
	 */
	@Test
	void testEqualsObjectGruposComNomesIguaisECaseIgual() {
		GrupoEstudo grupoEstudo1 = new GrupoEstudo("conjuntos");
		GrupoEstudo grupoEstudo2 = new GrupoEstudo("conjuntos", 7);
		assertEquals(grupoEstudo1, grupoEstudo2);
	}
	
	/**
	 * Testa o método equals de GrupoEstudo, utilizando nomes iguais e cases diferentes 
	 * em ambos os grupos.
	 */
	@Test
	void testEqualsObjectGruposComNomesIguaisECaseDiferente() {
		GrupoEstudo grupoEstudo1 = new GrupoEstudo("Conjuntos", 4);
		GrupoEstudo grupoEstudo2 = new GrupoEstudo("conjuntos");
		assertEquals(grupoEstudo1, grupoEstudo2);
	}
	
	/**
	 * Testa o método equals de GrupoEstudo, utilizando nomes diferentes em ambos 
	 * os grupos.
	 */
	@Test
	void testEqualsObjectGruposComNomesDiferentes() {
		GrupoEstudo grupoEstudo1 = new GrupoEstudo("conjuntos", 4);
		GrupoEstudo grupoEstudo2 = new GrupoEstudo("mapas", 10);
		assertNotEquals(grupoEstudo1, grupoEstudo2);
	}

	/**
	 * Testa o método toString de GrupoEstudo, verificando a exibição de um grupo.
	 */
	@Test
	void testToString() {
		GrupoEstudo grupoEstudo = new GrupoEstudo("Conjuntos", 4);
		assertEquals("- Conjuntos", grupoEstudo.toString());
	}

}