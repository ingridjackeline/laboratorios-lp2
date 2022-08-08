package alunos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Testa todas as funcionalidades da classe Aluno, bem como as possíveis exceções 
 * que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class AlunoTest {
	
	/**
	 * Testa o construtor de Aluno com todos os parâmetros válidos.
	 */
	@Test
	void testAlunoCasoBase() {
		new Aluno("250", "Ingrid Jackeline", "Computação");
	}
	
	/**
	 * Testa o construtor de Aluno com a matrícula vazia.
	 */
	@Test
	void testAlunoComMatriculaVazia() {
		try {
			new Aluno("", "Ingrid Jackeline", "Computação");
			fail("Não é permitido deixar a matrícula vazia.");
		} catch (IllegalArgumentException iae)	{
			
		}
	}
	
	/**
	 * Testa o construtor de Aluno com a matrícula nula.
	 */
	@Test
	void testAlunoComMatriculaNula() {
		try {
			new Aluno(null, "Ingrid Jackeline", "Computação");
			fail("Não é permitido deixar a matrícula nula.");
		} catch (NullPointerException npe)	{
			
		}
	}
	
	/**
	 * Testa o construtor de Aluno com o nome vazio.
	 */
	@Test
	void testAlunoComNomeVazio() {
		try {
			new Aluno("300", "", "Computação");
			fail("Não é permitido deixar o nome vazio.");
		} catch (IllegalArgumentException iae)	{
			
		}
	}
	
	/**
	 * Testa o construtor de Aluno com o nome nulo.
	 */
	@Test
	void testAlunoComNomeNulo() {
		try {
			new Aluno("300", null, "Computação");
			fail("Não é permitido deixar o nome nulo.");
		} catch (NullPointerException npe)	{
			
		}
	}
	
	/**
	 * Testa o construtor de Aluno com o curso vazio.
	 */
	@Test
	void testAlunoComCursoVazio() {
		try {
			new Aluno("200", "Ingrid Jackeline", "");
			fail("Não é permitido deixar o curso vazio.");
		} catch (IllegalArgumentException iae)	{
			
		}
	}
	
	/**
	 * Testa o construtor de Aluno com o curso nulo.
	 */
	@Test
	void testAlunoComCursoNulo() {
		try {
			new Aluno("200", "Ingrid Jackeline", null);
			fail("Não é permitido deixar o curso nulo.");
		} catch (NullPointerException npe)	{
			
		}
	}
	
	/**
	 * Testa o método hashCode de Aluno, verificando se dois alunos que possuem 
	 * a mesma matrícula apresentam o mesmo hashCode.
	 */
	@Test
	void testHashCodeAlunosComMatriculasIguais() {
		Aluno aluno1 = new Aluno("250", "Ingrid Jackeline", "Computação");
		Aluno aluno2 = new Aluno("250", "Tânia Maria", "Farmácia");
		assertEquals(aluno1.hashCode(), aluno2.hashCode());
	}
	
	/**
	 * Testa o método equals de Aluno, utilizando matrículas iguais em ambos os 
	 * alunos.
	 */
	@Test
	void testEqualsObjectAlunosComMatriculasIguais() {
		Aluno aluno1 = new Aluno("400", "Jacksivam Ponciano", "Design");
		Aluno aluno2 = new Aluno("400", "Tânia Maria", "Farmácia");
		assertEquals(aluno1, aluno2);
	}
	
	/**
	 * Testa o método equals de Aluno, utilizando matrículas diferentes em ambos os 
	 * alunos.
	 */
	@Test
	void testEqualsObjectAlunosComMatriculasDiferentes() {
		Aluno aluno1 = new Aluno("170", "Ingrid Jackeline", "Computação");
		Aluno aluno2 = new Aluno("125", "Ingrid Jackeline", "Computação");
		assertNotEquals(aluno1, aluno2);
	}

	/**
	 * Testa o método toString de Aluno, verificando a exibição das informações 
	 * de um aluno.
	 */
	@Test
	void testToString() {
		Aluno aluno = new Aluno("250", "Ingrid Jackeline", "Computação");
		assertEquals("250 - Ingrid Jackeline - Computação", aluno.toString());
	}

}