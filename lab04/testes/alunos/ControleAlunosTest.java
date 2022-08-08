package alunos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Testa todas as funcionalidades da classe ControleAlunos, bem como as possíveis exceções 
 * que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class ControleAlunosTest {
	
	/**
	 * O controle de alunos.
	 */
	private ControleAlunos controle;
	
	/**
	 * Prepara o controle de alunos que será utilizado em todos os testes de funcionalidade.
	 */
	@BeforeEach
	void setUp() {
		this.controle = new ControleAlunos();
	}

	/**
	 * Testa o método cadastraAluno de ControleAlunos, cadastrando um aluno com todos 
	 * os parâmetros válidos.
	 */
	@Test
	void testCadastraAlunoCasoBase() {
		this.controle.cadastraAluno("120", "Ingrid Jackeline", "Computação");
		assertTrue(this.controle.getAlunos().containsKey("120"));
	}
	
	/**
	 * Testa o método cadastraAluno de ControleAlunos, cadastrando um aluno com a 
	 * matrícula vazia.
	 */
	@Test
	void testCadastraAlunoComMatriculaVazia() {
		try {
			this.controle.cadastraAluno("", "Ingrid Jackeline", "Computação");
			fail("Não é permitido deixar a matrícula do aluno vazia.");
		} catch (IllegalArgumentException iae)	{
			
		}
	}
	
	/**
	 * Testa o método cadastraAluno de ControleAlunos, cadastrando um aluno com a 
	 * matrícula nula.
	 */
	@Test
	void testCadastraAlunoComMatriculaNula() {
		try {
			this.controle.cadastraAluno(null, "Ingrid Jackeline", "Computação");
			fail("Não é permitido deixar a matrícula do aluno nula.");
		} catch (NullPointerException npe)	{
			
		}
	}
	
	/**
	 * Testa o método cadastraAluno de ControleAlunos, cadastrando um aluno com o 
	 * nome vazio.
	 */
	@Test
	void testCadastraAlunoComNomeVazio() {
		try {
			this.controle.cadastraAluno("200", "", "Computação");
			fail("Não é permitido deixar o nome do aluno vazio.");
		} catch (IllegalArgumentException iae)	{
			
		}
	}
	
	/**
	 * Testa o método cadastraAluno de ControleAlunos, cadastrando um aluno com o 
	 * nome nulo.
	 */
	@Test
	void testCadastraAlunoComNomeNulo() {
		try {
			this.controle.cadastraAluno("200", null, "Computação");
			fail("Não é permitido deixar o nome do aluno nulo.");
		} catch (NullPointerException npe)	{
			
		}
	}
	
	/**
	 * Testa o método cadastraAluno de ControleAlunos, cadastrando um aluno com o 
	 * curso vazio.
	 */
	@Test
	void testCadastraAlunoComCursoVazio() {
		try {
			this.controle.cadastraAluno("200", "Ingrid Jackeline", "");
			fail("Não é permitido deixar o curso do aluno vazio.");
		} catch (IllegalArgumentException iae)	{
			
		}
	}
	
	/**
	 * Testa o método cadastraAluno de ControleAlunos, cadastrando um aluno com o 
	 * curso nulo.
	 */
	@Test
	void testCadastraAlunoComCursoNulo() {
		try {
			this.controle.cadastraAluno("200", "Ingrid Jackeline", null);
			fail("Não é permitido deixar o curso do aluno nulo.");
		} catch (NullPointerException npe)	{
			
		}
	}
	
	/**
	 * Testa o método cadastraAluno de ControleAlunos, cadastrando um aluno com uma 
	 * matrícula já cadastrada no controle.
	 */
	@Test
	void testCadastraAlunoComMatriculaJaCadastrada() {
		try {
			this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
			this.controle.cadastraAluno("250", "Mei-Ling Zhou", "Computação");
			fail("Não é permitido cadastrar uma matrícula já cadastrada.");
		} catch (IllegalArgumentException iae) {
			
		}
	}

	/**
	 * Testa o método verificaMatriculaExistente de ControleAlunos, verificando a 
	 * existência de uma matrícula vazia.
	 */
	@Test
	void testVerificaMatriculaVaziaExistente() {
		try {
			this.controle.verificaMatriculaExistente("");
			fail("Não é permitido verificar a existência de uma matrícula vazia.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método verificaMatriculaExistente de ControleAlunos, verificando a 
	 * existência de uma matrícula nula.
	 */
	@Test
	void testVerificaMatriculaNulaExistente() {
		try {
			this.controle.verificaMatriculaExistente(null);
			fail("Não é permitido verificar a existência de uma matrícula nula.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método verificaMatriculaExistente de ControleAlunos, verificando uma 
	 * matrícula existente no controle.
	 */
	@Test
	void testVerificaMatriculaExistente() {
		this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		assertTrue(this.controle.verificaMatriculaExistente("250"));
	}
	
	/**
	 * Testa o método verificaMatriculaExistente de ControleAlunos, verificando uma 
	 * matrícula inexistente no controle.
	 */
	@Test
	void testVerificaMatriculaInexistente() {
		assertFalse(this.controle.verificaMatriculaExistente("250"));
	}

	/**
	 * Testa o método consultaAluno de ControleAlunos, consultando um aluno com 
	 * matrícula vazia no controle.
	 */
	@Test
	void testConsultaAlunoComMatriculaVazia() {
		try {
			this.controle.consultaAluno("");
			fail("Não é permitido consultar um aluno com matrícula vazia.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método consultaAluno de ControleAlunos, consultando um aluno com 
	 * matrícula nula no controle.
	 */
	@Test
	void testConsultaAlunoComMatriculaNula() {
		try {
			this.controle.consultaAluno(null);
			fail("Não é permitido consultar um aluno com matrícula nula.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método consultaAluno de ControleAlunos, consultando um aluno não 
	 * cadastrado no controle.
	 */
	@Test
	void testConsultaAlunoNaoCadastrado() {
		try {
			this.controle.consultaAluno("400");
			fail("Não é permitido consultar um aluno que não está cadastrado.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método consultaAluno de ControleAlunos, consultando um aluno cadastrado 
	 * no controle.
	 */
	@Test
	void testConsultaAlunoCadastrado() {
		this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		assertEquals("250 - Gabriel Reyes - Computação", this.controle.consultaAluno("250"));
	}

	/**
	 * Testa o método cadastraGrupo de ControleAlunos, cadastrando um grupo válido 
	 * sem tamanho definido.
	 */
	@Test
	void testCadastraGrupoSemTamanhoDefinidoCasoBase() {
		this.controle.cadastraGrupo("Programação OO", "");
		assertTrue(this.controle.getGruposEstudo().containsKey("PROGRAMAÇÃO OO"));
	}
	
	/**
	 * Testa o método cadastraGrupo de ControleAlunos, cadastrando um grupo válido 
	 * com tamanho definido.
	 */
	@Test
	void testCadastraGrupoComTamanhoDefinidoCasoBase() {
		this.controle.cadastraGrupo("Listas", "10");
		assertTrue(this.controle.getGruposEstudo().containsKey("LISTAS"));
	}
	
	/**
	 * Testa o método cadastraGrupo de ControleAlunos, cadastrando um grupo com o 
	 * nome vazio.
	 */
	@Test
	void testCadastraGrupoComNomeVazio() {
		try {
			this.controle.cadastraGrupo("", "");
			fail("Não é permitido deixar o nome do grupo vazio.");
		} catch (IllegalArgumentException iae)	{
			
		}
	}
	
	/**
	 * Testa o método cadastraGrupo de ControleAlunos, cadastrando um grupo com o 
	 * nome nulo.
	 */
	@Test
	void testCadastraGrupoComNomeNulo() {
		try {
			this.controle.cadastraGrupo(null, "10");
			fail("Não é permitido deixar o nome do grupo nulo.");
		} catch (NullPointerException npe)	{
			
		}
	}
	
	/**
	 * Testa o método cadastraGrupo de ControleAlunos, cadastrando um grupo com o 
	 * tamanho nulo.
	 */
	@Test
	void testCadastraGrupoComTamanhoNulo() {
		try {
			this.controle.cadastraGrupo("Listas", null);
			fail("Não é permitido deixar o tamanho do grupo nulo.");
		} catch (NullPointerException npe)	{
			
		}
	}
	
	/**
	 * Testa o método cadastraGrupo de ControleAlunos, cadastrando um grupo com o 
	 * tamanho abaixo do limite inferior permitido.
	 */
	@Test
	void testCadastraGrupoComTamanhoAbaixoDoLimiteInferior() {
		try {
			this.controle.cadastraGrupo("Listas", "0");
			fail("O tamanho para o grupo não é permitido.");
		} catch (IllegalArgumentException iae)	{
			
		}
	}
	
	/**
	 * Testa o método cadastraGrupo de ControleAlunos, cadastrando um grupo com o 
	 * tamanho no limite inferior permitido.
	 */
	@Test
	void testCadastraGrupoComTamanhoNoLimiteInferior() {
		this.controle.cadastraGrupo("mapas", "1");
		assertTrue(this.controle.getGruposEstudo().containsKey("MAPAS"));
	}

	/**
	 * Testa o método cadastraGrupo de ControleAlunos, cadastrando um grupo com um 
	 * nome já existente no controle.
	 */
	@Test
	void testCadastraGrupoComNomeExistente() {
		try {
			this.controle.cadastraGrupo("Listas", "10");
			this.controle.cadastraGrupo("Listas", "");
			fail("Não é permitido cadastrar um grupo com nome já existente.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método verificaGrupoExistente de ControleAlunos, verificando a 
	 * existência de um grupo com nome vazio.
	 */
	@Test
	void testVerificaGrupoExistenteComNomeVazio() {
		try {
			this.controle.verificaGrupoExistente("");
			fail("Não é permitido verificar a existência de um grupo com nome vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método verificaGrupoExistente de ControleAlunos, verificando a 
	 * existência de um grupo com nome nulo.
	 */
	@Test
	void testVerificaGrupoExistenteComNomeNulo() {
		try {
			this.controle.verificaGrupoExistente(null);
			fail("Não é permitido verificar a existência de um grupo com nome nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método verificaGrupoExistente de ControleAlunos, verificando um grupo 
	 * existente no controle.
	 */
	@Test
	void testVerificaGrupoExistente() {
		this.controle.cadastraGrupo("Mapas", "");
		assertTrue(this.controle.verificaGrupoExistente("mapas"));
	}
	
	/**
	 * Testa o método verificaGrupoExistente de ControleAlunos, verificando um grupo 
	 * inexistente no controle.
	 */
	@Test
	void testVerificaGrupoInexistente() {
		assertFalse(this.controle.verificaGrupoExistente("Mapas"));
	}

	/**
	 * Testa o método alocaAlunoEmGrupo de ControleAlunos, alocando um aluno válido 
	 * em um grupo válido.
	 */
	@Test
	void testAlocaAlunoEmUmGrupoCasoBase() {
		this.controle.cadastraAluno("200", "Lili Camposh", "Computação");
		this.controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
		this.controle.cadastraGrupo("Programação OO", "");
		this.controle.alocaAlunoEmGrupo("200", "Programação OO");
		this.controle.alocaAlunoEmGrupo("202", "Programação OO");
		assertTrue(this.controle.verificaPertinenciaAoGrupo("Programação OO", "200"));
		assertTrue(this.controle.verificaPertinenciaAoGrupo("Programação OO", "202"));
	}
	
	/**
	 * Testa o método alocaAlunoEmGrupo de ControleAlunos, alocando um aluno já 
	 * alocado no grupo. O controle não lança exceção para esse cenário, apenas 
	 * não realiza a operação internamente.
	 */
	@Test
	void testAlocaAlunoJaAlocadoEmUmGrupo() {
		this.controle.cadastraAluno("200", "Lili Camposh", "Computação");
		this.controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
		this.controle.cadastraGrupo("Programação OO", "");
		assertTrue(this.controle.alocaAlunoEmGrupo("200", "Programação OO"));
		assertTrue(this.controle.alocaAlunoEmGrupo("202", "Programação OO"));
		assertFalse(this.controle.alocaAlunoEmGrupo("200", "Programação OO"));
	}
	
	/**
	 * Testa o método alocaAlunoEmGrupo de ControleAlunos, alocando um aluno com 
	 * matrícula vazia em um grupo.
	 */
	@Test
	void testAlocaAlunoComMatriculaVaziaEmGrupo() {
		try {
			this.controle.alocaAlunoEmGrupo("", "Conjuntos");
			fail("Não é permitido alocar um aluno com matrícula vazia no grupo.");
		} catch(IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método alocaAlunoEmGrupo de ControleAlunos, alocando um aluno com 
	 * matrícula nula em um grupo.
	 */
	@Test
	void testAlocaAlunoComMatriculaNulaEmGrupo() {
		try {
			this.controle.alocaAlunoEmGrupo(null, "Conjuntos");
			fail("Não é permitido alocar um aluno com matrícula nula no grupo.");
		} catch(NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método alocaAlunoEmGrupo de ControleAlunos, alocando um aluno não 
	 * cadastrado no controle em um grupo.
	 */
	@Test
	void testAlocaAlunoInexistenteEmUmGrupo() {
		try {
			this.controle.cadastraGrupo("Programação OO", "");
			this.controle.alocaAlunoEmGrupo("100", "Programação OO");
			fail("Não é permitido alocar um aluno não cadastrado no grupo.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método alocaAlunoEmGrupo de ControleAlunos, alocando um aluno em um 
	 * grupo com nome vazio.
	 */
	@Test
	void testAlocaAlunoEmGrupoVazio() {
		try {
			this.controle.cadastraAluno("200", "Lili Camposh", "Computação");
			this.controle.alocaAlunoEmGrupo("200", "");
			fail("Não é permitido alocar um aluno em um grupo vazio.");
		} catch(IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método alocaAlunoEmGrupo de ControleAlunos, alocando um aluno em um 
	 * grupo com nome nulo.
	 */
	@Test
	void testAlocaAlunoEmGrupoNulo() {
		try {
			this.controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
			this.controle.alocaAlunoEmGrupo("202", null);
			fail("Não é permitido alocar um aluno em um grupo nulo.");
		} catch(NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método alocaAlunoEmGrupo de ControleAlunos, alocando um aluno em um 
	 * grupo não cadastrado no controle.
	 */
	@Test
	void testAlocaAlunoEmUmGrupoInexistente() {
		try {
			this.controle.cadastraAluno("200", "Lili Camposh", "Computação");
			this.controle.alocaAlunoEmGrupo("200", "Anatomia");
			fail("Não é permitido alocar um aluno em um grupo não cadastrado.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método alocaAlunoEmGrupo de ControleAlunos, alocando um aluno em um 
	 * grupo que já está cheio.
	 */
	@Test
	void testAlocaAlunoEmUmGrupoCheio() {
		try {
			this.controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
			this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
			this.controle.cadastraGrupo("listas", "1");
			this.controle.alocaAlunoEmGrupo("250", "Listas");
			this.controle.alocaAlunoEmGrupo("202", "Listas");
			fail("Não é permitido alocar um aluno em um grupo cheio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método verificaGrupoCheio de ControleAlunos, verificando se um grupo 
	 * com nome vazio está cheio.
	 */
	@Test
	void testVerificaGrupoCheioComNomeVazio() {
		try {
			this.controle.verificaGrupoCheio("");
			fail("Não é permitido verificar se um grupo com nome vazio está cheio.");
		} catch(IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método verificaGrupoCheio de ControleAlunos, verificando se um grupo 
	 * com nome nulo está cheio.
	 */
	@Test
	void testVerificaGrupoCheioComNomeNulo() {
		try {
			this.controle.verificaGrupoCheio(null);
			fail("Não é permitido verificar se um grupo com nome nulo está cheio.");
		} catch(NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método verificaGrupoCheio de ControleAlunos, verificando que um grupo 
	 * com tamanho definido não está cheio.
	 */
	@Test
	void testVerificaGrupoComTamanhoDefinidoNaoEstaCheio() {
		this.controle.cadastraAluno("200", "Lili Camposh", "Computação");
		this.controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
		this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		this.controle.cadastraGrupo("Listas", "4");
		this.controle.alocaAlunoEmGrupo("250", "Listas");
		this.controle.alocaAlunoEmGrupo("202", "listas");
		this.controle.alocaAlunoEmGrupo("200", "LISTAS");
		assertFalse(this.controle.verificaGrupoCheio("Listas"));
	}
	
	/**
	 * Testa o método verificaGrupoCheio de ControleAlunos, verificando que um grupo 
	 * com tamanho definido está cheio.
	 */
	@Test
	void testVerificaGrupoComTamanhoDefinidoEstaCheio() {
		this.controle.cadastraAluno("200", "Lili Camposh", "Computação");
		this.controle.cadastraAluno("201", "Torbjorn Lindholm", "Engenharia Mecânica");
		this.controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
		this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		this.controle.cadastraGrupo("Listas", "4");
		this.controle.alocaAlunoEmGrupo("250", "Listas");
		this.controle.alocaAlunoEmGrupo("202", "listas");
		this.controle.alocaAlunoEmGrupo("200", "LISTAS");
		this.controle.alocaAlunoEmGrupo("201", "listas");
		assertTrue(this.controle.verificaGrupoCheio("Listas"));
	}

	/**
	 * Testa o método verificaPertinenciaAoGrupo de ControleAlunos, verificando a 
	 * pertinência de um aluno que está no grupo.
	 */
	@Test
	void testVerificaPertinenciaDoAlunoAoGrupo() {
		this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		this.controle.cadastraGrupo("listas", "");
		this.controle.alocaAlunoEmGrupo("250", "Listas");
		assertTrue(this.controle.verificaPertinenciaAoGrupo("Listas", "250"));
	}
	
	/**
	 * Testa o método verificaPertinenciaAoGrupo de ControleAlunos, verificando a 
	 * pertinência de um aluno que não está no grupo.
	 */
	@Test
	void testVerificaNaoPertinenciaDoAlunoAoGrupo() {
		this.controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
		this.controle.cadastraGrupo("listas", "");
		assertFalse(this.controle.verificaPertinenciaAoGrupo("Listas", "202"));
	}
	
	/**
	 * Testa o método verificaPertinenciaAoGrupo de ControleAlunos, verificando a 
	 * pertinência de um aluno com matrícula vazia a um grupo.
	 */
	@Test
	void testVerificaPertinenciaDoAlunoComMatriculaVaziaAoGrupo() {
		try {
			this.controle.cadastraGrupo("listas", "");
			this.controle.verificaPertinenciaAoGrupo("Listas", "");
			fail("Não é permitido verificar a pertinência de um aluno com matrícula vazia.");
		} catch(IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método verificaPertinenciaAoGrupo de ControleAlunos, verificando a 
	 * pertinência de um aluno com matrícula nula a um grupo.
	 */
	@Test
	void testVerificaPertinenciaDoAlunoComMatriculaNulaAoGrupo() {
		try {
			this.controle.cadastraGrupo("coleções", "");
			this.controle.verificaPertinenciaAoGrupo("Coleções", null);
			fail("Não é permitido verificar a pertinência de um aluno com matrícula nula.");
		} catch(NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método verificaPertinenciaAoGrupo de ControleAlunos, verificando a 
	 * pertinência de um aluno a um grupo com nome vazio.
	 */
	@Test
	void testVerificaPertinenciaDoAlunoAoGrupoComNomeVazio() {
		try {
			this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
			this.controle.verificaPertinenciaAoGrupo("", "250");
			fail("Não é permitido verificar a pertinência do aluno a um grupo com nome vazio.");
		} catch(IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método verificaPertinenciaAoGrupo de ControleAlunos, verificando a 
	 * pertinência de um aluno a um grupo com nome nulo.
	 */
	@Test
	void testVerificaPertinenciaDoAlunoAoGrupoComNomeNulo() {
		try {
			this.controle.cadastraAluno("201", "Torbjorn Lindholm", "Engenharia Mecânica");
			this.controle.verificaPertinenciaAoGrupo(null, "201");
			fail("Não é permitido verificar a pertinência do aluno a um grupo com nome nulo.");
		} catch(NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método verificaPertinenciaAoGrupo de ControleAlunos, verificando a 
	 * pertinência de um aluno a um grupo não cadastrado no controle.
	 */
	@Test
	void testVerificaPertinenciaDoAlunoAGrupoInexistente() {
		try {
			this.controle.cadastraAluno("200", "Lili Camposh", "Computação");
			this.controle.verificaPertinenciaAoGrupo("Anatomia", "200");
			fail("Não é permitido verificar a pertinência de um aluno a um grupo inexistente.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método verificaPertinenciaAoGrupo de ControleAlunos, verificando a 
	 * pertinência de um aluno não cadastrado no controle a um grupo.
	 */
	@Test
	void testVerificaPertinenciaDoAlunoInexistenteAoGrupo() {
		try {
			this.controle.cadastraGrupo("Programação OO", "");
			this.controle.verificaPertinenciaAoGrupo("Programação OO", "100");
			fail("Não é permitido verificar a pertinência de um aluno inexistente a um grupo.");
		} catch (IllegalArgumentException iae) {
			
		}
	}

	/**
	 * Testa o método registraAlunoQueRespondeQuestao de ControleAlunos, registrando 
	 * um aluno cadastrado que responde questão no quadro.
	 */
	@Test
	void testRegistraAlunoCadastradoQueRespondeQuestao() {
		this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		this.controle.registraAlunoQueRespondeQuestao("250");
		ArrayList<Aluno> alunosRespondemQuestoes = this.controle.getAlunosRespondemQuestoes();
		assertEquals("250", alunosRespondemQuestoes.get(0).getMatricula());
	}
	
	/**
	 * Testa o método registraAlunoQueRespondeQuestao de ControleAlunos, registrando 
	 * um aluno com matrícula vazia que responde questão no quadro.
	 */
	@Test
	void testRegistraAlunoComMatriculaVaziaQueRespondeQuestao() {
		try {
			this.controle.registraAlunoQueRespondeQuestao("");
			fail("Não é permitido registrar um aluno que responde questão com uma matrícula vazia.");
		} catch(IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método registraAlunoQueRespondeQuestao de ControleAlunos, registrando 
	 * um aluno com matrícula nula que responde questão no quadro.
	 */
	@Test
	void testRegistraAlunoComMatriculaNulaQueRespondeQuestao() {
		try {
			this.controle.registraAlunoQueRespondeQuestao(null);
			fail("Não é permitido registrar um aluno que responde questão com uma matrícula nula.");
		} catch(NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método registraAlunoQueRespondeQuestao de ControleAlunos, registrando 
	 * um aluno não cadastrado que responde questão no quadro.
	 */
	@Test
	void testRegistraAlunoNaoCadastradoQueRespondeQuestao() {
		try {
			this.controle.registraAlunoQueRespondeQuestao("250");
			fail("Não é permitido registrar um aluno não cadastrado.");
		} catch (IllegalArgumentException iae)	{
			
		}
	}
	
	/**
	 * Testa o método registraAlunoQueRespondeQuestao de ControleAlunos, registrando 
	 * um aluno cadastrado que responde questão no quadro mais de uma vez.
	 */
	@Test
	void testRegistraAlunoCadastradoQueRespondeQuestaoMaisDeUmaVez() {
		this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		this.controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
		this.controle.registraAlunoQueRespondeQuestao("250");
		this.controle.registraAlunoQueRespondeQuestao("202");
		this.controle.registraAlunoQueRespondeQuestao("250");
		ArrayList<Aluno> alunosRespondemQuestoes = this.controle.getAlunosRespondemQuestoes();
		assertEquals("250", alunosRespondemQuestoes.get(0).getMatricula());
		assertEquals("202", alunosRespondemQuestoes.get(1).getMatricula());
		assertEquals("250", alunosRespondemQuestoes.get(2).getMatricula());
	}

	/**
	 * Testa o método imprimeAlunosQueRespondemQuestoes de ControleAlunos, imprimindo 
	 * os alunos que respondem questões no quadro na ordem em que foram registrados 
	 * no controle.
	 */
	@Test
	void testImprimeAlunosQueRespondemQuestoes() {
		this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		this.controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
		this.controle.cadastraAluno("201", "Torbjorn Lindholm", "Engenharia Mecânica");
		this.controle.cadastraAluno("200", "Lili Camposh", "Computação");
		this.controle.registraAlunoQueRespondeQuestao("250");
		this.controle.registraAlunoQueRespondeQuestao("202");
		this.controle.registraAlunoQueRespondeQuestao("250");
		this.controle.registraAlunoQueRespondeQuestao("201");
		this.controle.registraAlunoQueRespondeQuestao("200");
		this.controle.registraAlunoQueRespondeQuestao("201");
		this.controle.registraAlunoQueRespondeQuestao("200");
		assertEquals("1. 250 - Gabriel Reyes - Computação\n2. 202 - Angela Ziegler - Medicina\n"
		+ "3. 250 - Gabriel Reyes - Computação\n4. 201 - Torbjorn Lindholm - Engenharia Mecânica\n"
		+ "5. 200 - Lili Camposh - Computação\n6. 201 - Torbjorn Lindholm - Engenharia Mecânica\n"
		+ "7. 200 - Lili Camposh - Computação", this.controle.imprimeAlunosQueRespondemQuestoes());
	}
	
	/**
	 * Testa o método imprimeGruposDoAluno de ControleAlunos, imprimindo os grupos 
	 * de um aluno com matrícula vazia.
	 */
	@Test
	void testImprimeGruposDoAlunoComMatriculaVazia() {
		try {
			this.controle.imprimeGruposDoAluno("");
			fail("Não é permitido imprimir os grupos de um aluno com matrícula vazia.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método imprimeGruposDoAluno de ControleAlunos, imprimindo os grupos 
	 * de um aluno com matrícula nula.
	 */
	@Test
	void testImprimeGruposDoAlunoComMatriculaNula() {
		try {
			this.controle.imprimeGruposDoAluno(null);
			fail("Não é permitido imprimir os grupos de um aluno com matrícula nula.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método imprimeGruposDoAluno de ControleAlunos, imprimindo os grupos 
	 * de um aluno não cadastrado no controle.
	 */
	@Test
	void testImprimeGruposDoAlunoNaoCadastrado() {
		try {
			this.controle.imprimeGruposDoAluno("202");
			fail("Não é permitido imprimir os grupos de um aluno não cadastrado.");
		} catch (IllegalArgumentException iae) {
			
		}
	}

	/**
	 * Testa o método imprimeGruposDoAluno de ControleAlunos, imprimindo os grupos 
	 * de um aluno cadastrado que não está alocado em nenhum grupo.
	 */
	@Test
	void testImprimeGruposDoAlunoSemGrupos() {
		this.controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
		assertEquals("", this.controle.imprimeGruposDoAluno("202"));
	}
	
	/**
	 * Testa o método imprimeGruposDoAluno de ControleAlunos, imprimindo os grupos 
	 * de um aluno cadastrado que está alocado em grupos.
	 */
	@Test
	void testImprimeGruposDoAlunoComGrupos() {
		this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		this.controle.cadastraGrupo("Programação OO", "");
		this.controle.cadastraGrupo("Listas", "");
		this.controle.alocaAlunoEmGrupo("250", "listas");
		this.controle.alocaAlunoEmGrupo("250", "programação OO");
		assertEquals("- Programação OO\n- Listas", this.controle.imprimeGruposDoAluno("250"));
	}

}