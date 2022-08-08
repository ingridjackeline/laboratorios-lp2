package agenda;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testa todas as funcionalidades da classe Agenda, bem como as possíveis exceções 
 * que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class AgendaTest {
	
	/**
	 * A agenda de contatos.
	 */
	private Agenda agenda;

	/**
	 *  Prepara a agenda que será utilizada em todos os testes de funcionalidade.
	 */
	@BeforeEach
	void preparaAgenda() {
		this.agenda = new Agenda();
	}
	
	/**
	 * Testa o método verificaCadastroExistente de Agenda para um contato existente 
	 * na agenda.
	 */
	@Test
	void testVerificaCadastroExistente() {
		this.agenda.cadastraContato(1, "Ingrid", "Jackeline", "(81) 90384-0982");
		assertTrue(this.agenda.verificaCadastroExistente("Ingrid", "Jackeline"));
	}		
	
	/**
	 * Testa o método verificaCadastroExistente de Agenda para um contato inexistente 
	 * na agenda.
	 */
	@Test
	void testVerificaCadastroInexistente() {
		assertFalse(this.agenda.verificaCadastroExistente("Ingrid", "Jackeline"));
	}
	
	/**
	 * Testa o método verificaCadastroExistente de Agenda para um contato com o 
	 * nome vazio.
	 */
	@Test
	void testVerificaCadastroNomeVazio() {
		try {
			this.agenda.verificaCadastroExistente("", "Jackeline");
			fail("Não é permitido deixar o nome vazio");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método verificaCadastroExistente de Agenda para um contato com o 
	 * nome nulo.
	 */
	@Test
	void testVerificaCadastroNomeNulo() {
		try {
			this.agenda.verificaCadastroExistente(null, "Jackeline");
			fail("Não é permitido deixar o nome nulo");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método verificaCadastroExistente de Agenda para um contato com o 
	 * sobrenome nulo.
	 */
	@Test
	void testVerificaCadastroSobrenomeNulo() {
		try {
			this.agenda.verificaCadastroExistente("Ingrid", null);
			fail("Não é permitido deixar o sobrenome nulo");
		} catch (NullPointerException npe) {
			
		}
	}

	/**
	 * Testa o cadastro de um contato para uma posição vazia na agenda.
	 */
	@Test
	void testCadastraContatoPosicaoVazia() {
		this.agenda.cadastraContato(10, "Ingrid", "Jackeline", "(81) 90384-0982");
	}
	
	/**
	 * Testa o cadastro de um contato para uma posição ocupada na agenda.
	 */
	@Test
	void testCadastraContatoPosicaoOcupada() {
		this.agenda.cadastraContato(3, "Ingrid", "Jackeline", "(81) 90384-0982");
		this.agenda.cadastraContato(3, "Aline", "Assis", "(81) 23782-7978");
	}

	/**
	 * Testa o cadastro de um contato para a posição correspondente ao limite inferior 
	 * da agenda.
	 */
	@Test
	void testCadastraContatoPosicaoLimiteInferior() {
		this.agenda.cadastraContato(1, "Ingrid", "Jackeline", "(81) 90384-0982");
	}
	
	/**
	 * Testa o cadastro de um contato para a posição correspondente ao limite superior 
	 * da agenda.
	 */
	@Test
	void testCadastraContatoPosicaoLimiteSuperior() {
		this.agenda.cadastraContato(100, "Ingrid", "Jackeline", "(81) 90384-0982");
	}
	
	/**
	 * Testa o cadastro de um contato para uma posição abaixo do limite inferior 
	 * da agenda.
	 */
	@Test
	void testCadastraContatoPosicaoAbaixoLimiteInferior() {
		try {
			this.agenda.cadastraContato(0, "Ingrid", "Jackeline", "(81) 90384-0982");
			fail("A posição para o contato não existe");
		} catch (IndexOutOfBoundsException ioobe) {	
			
		}
	}
	
	/**
	 * Testa o cadastro de um contato para uma posição acima do limite superior 
	 * da agenda.
	 */
	@Test
	void testCadastraContatoPosicaoAcimaLimiteSuperior() {
		try {
			this.agenda.cadastraContato(101, "Ingrid", "Jackeline", "(81) 90384-0982");
			fail("A posição para o contato não existe");
		} catch (IndexOutOfBoundsException ioobe) {	
			
		}
	}
	
	/**
	 * Testa o cadastro de um contato com o nome vazio.
	 */
	@Test
	void testCadastraContatoNomeVazio() {
		try {
			this.agenda.cadastraContato(12, "", "Jackeline", "(81) 90384-0982");
			fail("Não é permitido deixar o nome vazio");
		} catch (IllegalArgumentException iae) {	
			
		}
	}
	
	/**
	 * Testa o cadastro de um contato com o nome nulo.
	 */
	@Test
	void testCadastraContatoNomeNulo() {
		try {
			this.agenda.cadastraContato(12, null, "Jackeline", "(81) 90384-0982");
			fail("Não é permitido deixar o nome nulo");
		} catch (NullPointerException npe) {	
			
		}
	}
	
	/**
	 * Testa o cadastro de um contato com o sobrenome nulo.
	 */
	@Test
	void testCadastraContatoSobrenomeNulo() {
		try {
			this.agenda.cadastraContato(12, "Ingrid", null, "(81) 90384-0982");
			fail("Não é permitido deixar o sobrenome nulo");
		} catch (NullPointerException npe) {	
			
		}
	}
	
	/**
	 * Testa o cadastro de um contato com o telefone vazio.
	 */
	@Test
	void testCadastraContatoTelefoneVazio() {
		try {
			this.agenda.cadastraContato(12, "Ingrid", "Jackeline", "");
			fail("Não é permitido deixar o telefone vazio");
		} catch (IllegalArgumentException iae) {	
			
		}
	}
	
	/**
	 * Testa o cadastro de um contato com o telefone nulo.
	 */
	@Test
	void testCadastraContatoTelefoneNulo() {
		try {
			this.agenda.cadastraContato(12, "Ingrid", "Jackeline", null);
			fail("Não é permitido deixar o telefone nulo");
		} catch (NullPointerException npe) {	
			
		}
	}
	
	/**
	 * Testa o cadastro de um contato já existente na agenda de contatos.
	 */
	@Test
	void testCadastraContatoExistente() {
		try {
			this.agenda.cadastraContato(10, "Ingrid", "Jackeline", "(81) 90384-0982");
			this.agenda.cadastraContato(17, "Ingrid", "Jackeline", "(81) 23123-9876");
			fail("Não é permitido cadastrar um contato já existente");
		} catch (IllegalArgumentException iae) {	
			
		}
	}
	
	/**
	 * Testa o método adicionaTags de Agenda com todos os parâmetros válidos.
	 */
	@Test
	void testAdicionaTagsCasoBase() {
		this.agenda.cadastraContato(10, "Ingrid", "Jackeline", "(81) 90384-0982");
		this.agenda.adicionaTags(10, 4, "aluna");
	}
	
	/**
	 * Testa o método adicionaTags de Agenda com a posição de contato no limite 
	 * inferior.
	 */
	@Test
	void testAdicionaTagsPosicaoContatoLimiteInferior() {
		this.agenda.cadastraContato(1, "Ingrid", "Jackeline", "(81) 90384-0982");
		this.agenda.adicionaTags(1, 3, "aluna");
	}
	
	/**
	 * Testa o método adicionaTags de Agenda com a posição de contato no limite 
	 * superior.
	 */
	@Test
	void testAdicionaTagsPosicaoContatoLimiteSuperior() {
		this.agenda.cadastraContato(100, "Ingrid", "Jackeline", "(81) 90384-0982");
		this.agenda.adicionaTags(100, 3, "aluna");
	}
	
	/**
	 * Testa o método adicionaTags de Agenda com uma posição de contato abaixo do 
	 * limite inferior.
	 */
	@Test
	void testAdicionaTagsPosicaoContatoAbaixoLimiteInferior() {
		try {
			this.agenda.adicionaTags(0, 1, "aluna");
			fail("A posição para o contato não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método adicionaTags de Agenda com uma posição de contato acima do 
	 * limite superior.
	 */
	@Test
	void testAdicionaTagsPosicaoContatoAcimaLimiteSuperior() {
		try {
			this.agenda.adicionaTags(101, 1, "aluna");
			fail("A posição para o contato não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}

	/**
	 * Testa o método adicionaTags de Agenda com um contato nulo.
	 */
	@Test
	void testAdicionaTagsContatoNulo() {
		try {
			this.agenda.adicionaTags(20, 1, "aluna");
			fail("Não é permitido adicionar tags a um contato que não existe");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método adicionaTags de Agenda com a posição de tag no limite inferior. 
	 */
	@Test
	void testAdicionaTagsPosicaoTagLimiteInferior() {
		this.agenda.cadastraContato(50, "Ingrid", "Jackeline", "(81) 90384-0982");
		this.agenda.adicionaTags(50, 1, "aluna");
	}
	
	/**
	 * Testa o método adicionaTags de Agenda com a posição de tag no limite superior. 
	 */
	@Test
	void testAdicionaTagsPosicaoTagLimiteSuperior() {
		this.agenda.cadastraContato(50, "Ingrid", "Jackeline", "(81) 90384-0982");
		this.agenda.adicionaTags(50, 5, "aluna");
	}
	
	/**
	 * Testa o método adicionaTags de Agenda com uma posição de tag abaixo do 
	 * limite inferior. 
	 */
	@Test
	void testAdicionaTagsPosicaoTagAbaixoLimiteInferior() {
		try {
			this.agenda.cadastraContato(50, "Ingrid", "Jackeline", "(81) 90384-0982");
			this.agenda.adicionaTags(50, 0, "aluna");
			fail("A posição para a tag não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método adicionaTags de Agenda com uma posição de tag acima do 
	 * limite superior. 
	 */
	@Test
	void testAdicionaTagsPosicaoTagAcimaLimiteSuperior() {
		try {
			this.agenda.cadastraContato(50, "Ingrid", "Jackeline", "(81) 90384-0982");
			this.agenda.adicionaTags(50, 6, "aluna");
			fail("A posição para a tag não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método adicionaTags de Agenda com uma tag vazia.
	 */
	@Test
	void testAdicionaTagsTagVazia() {
		try {
			this.agenda.cadastraContato(50, "Ingrid", "Jackeline", "(81) 90384-0982");
			this.agenda.adicionaTags(50, 2, "");
			fail("Não é permitido deixar a tag vazia");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método adicionaTags de Agenda com uma tag nula.
	 */
	@Test
	void testAdicionaTagsTagNula() {
		try {
			this.agenda.cadastraContato(50, "Ingrid", "Jackeline", "(81) 90384-0982");
			this.agenda.adicionaTags(50, 2, null);
			fail("Não é permitido deixar a tag nula");
		} catch (NullPointerException npe) {
			
		}
	}

	/**
	 * Testa o método exibeContato de Agenda com a posição de contato no limite 
	 * inferior.
	 */
	@Test
	void testExibeContatoPosicaoLimiteInferior() {
		this.agenda.cadastraContato(1, "Ingrid", "Jackeline", "(81) 90384-0982");
		assertEquals("\nIngrid Jackeline\n(81) 90384-0982", this.agenda.exibeContato(1));
	}
	
	/**
	 * Testa o método exibeContato de Agenda com a posição de contato no limite 
	 * superior.
	 */
	@Test
	void testExibeContatoPosicaoLimiteSuperior() {
		this.agenda.cadastraContato(100, "Ingrid", "Jackeline", "(81) 90384-0982");
		assertEquals("\nIngrid Jackeline\n(81) 90384-0982", this.agenda.exibeContato(100));
	}
	
	/**
	 * Testa o método exibeContato de Agenda com uma posição de contato abaixo do 
	 * limite inferior.
	 */
	@Test
	void testExibeContatoPosicaoAbaixoLimiteInferior() {
		try {
			this.agenda.exibeContato(0);
			fail("A posição para o contato não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método exibeContato de Agenda com uma posição de contato acima do 
	 * limite superior.
	 */
	@Test
	void testExibeContatoPosicaoAcimaLimiteSuperior() {
		try {
			this.agenda.exibeContato(101);
			fail("A posição para o contato não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método exibeContato de Agenda com um contato nulo.
	 */
	@Test
	void testExibeContatoNulo() {
		try {
			this.agenda.exibeContato(20);
			fail("O contato não existe");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método exibeContato de Agenda com um contato sem tags.
	 */
	@Test
	void testExibeContatoSemTags() {
		this.agenda.cadastraContato(5, "Ingrid", "Jackeline", "(81) 89920-0987");
		assertEquals("\nIngrid Jackeline\n(81) 89920-0987", this.agenda.exibeContato(5));
	}
	
	/**
	 * Testa o método exibeContato de Agenda com um contato com tags.
	 */
	@Test
	void testExibeContatoComTags() {
		this.agenda.cadastraContato(5, "Ingrid", "Jackeline", "(81) 89920-0987");
		this.agenda.adicionaTags(5, 1, "aluna");
		this.agenda.adicionaTags(5, 2, "ufcg");
		assertEquals("\nIngrid Jackeline\n(81) 89920-0987\naluna ufcg", this.agenda.exibeContato(5));
	}
	
	/**
	 * Testa o método exibeContato de Agenda com um contato favorito sem tags.
	 */
	@Test
	void testExibeContatoFavoritoSemTags() {
		this.agenda.cadastraContato(5, "Ingrid", "Jackeline", "(81) 89920-0987");
		this.agenda.adicionaFavorito(5, 1);
		assertEquals("\n❤️ Ingrid Jackeline\n(81) 89920-0987", this.agenda.exibeContato(5));
	}
	
	/**
	 * Testa o método exibeContato de Agenda com um contato favorito com tags.
	 */
	@Test
	void testExibeContatoFavoritoComTags() {
		this.agenda.cadastraContato(5, "Ingrid", "Jackeline", "(81) 89920-0987");
		this.agenda.adicionaTags(5, 1, "aluna");
		this.agenda.adicionaTags(5, 2, "ufcg");
		this.agenda.adicionaFavorito(5, 1);
		assertEquals("\n❤️ Ingrid Jackeline\n(81) 89920-0987\naluna ufcg", this.agenda.exibeContato(5));
	}
	
	/**
	 * Testa o método exibeContato de Agenda com um contato que deixou de ser favorito.
	 */
	@Test
	void testExibeContatoExFavorito() {
		this.agenda.cadastraContato(5, "Ingrid", "Jackeline", "(81) 89920-0987");
		this.agenda.adicionaFavorito(5, 1);
		this.agenda.cadastraContato(6, "Loren", "Narrane", "(81) 32187-9384");
		this.agenda.adicionaFavorito(6, 1);
		assertEquals("\nIngrid Jackeline\n(81) 89920-0987", this.agenda.exibeContato(5));
	}

	/**
	 * Testa o método verificaFavorito de Agenda com a posição de contato no limite 
	 * inferior.
	 */
	@Test
	void testVerificaFavoritoPosicaoLimiteInferior() {
		this.agenda.cadastraContato(1, "Ingrid", "Jackeline", "(81) 89920-0987");
		this.agenda.verificaFavorito(1);
	}
	
	/**
	 * Testa o método verificaFavorito de Agenda com a posição de contato no limite 
	 * superior.
	 */
	@Test
	void testVerificaFavoritoPosicaoLimiteSuperior() {
		this.agenda.cadastraContato(100, "Ingrid", "Jackeline", "(81) 89920-0987");
		this.agenda.verificaFavorito(100);
	}

	/**
	 * Testa o método verificaFavorito de Agenda com uma posição de contato abaixo 
	 * do limite inferior.
	 */
	@Test
	void testVerificaFavoritoPosicaoAbaixoLimiteInferior() {
		try {
			this.agenda.verificaFavorito(0);
			fail("A posição para o contato não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método verificaFavorito de Agenda com uma posição de contato acima 
	 * do limite superior.
	 */
	@Test
	void testVerificaFavoritoPosicaoAcimaLimiteSuperior() {
		try {
			this.agenda.verificaFavorito(101);
			fail("A posição para o contato não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método verificaFavorito de Agenda com um contato nulo.
	 */
	@Test
	void testVerificaFavoritoContatoNulo() {
		try {
			this.agenda.verificaFavorito(90);
			fail("O contato não existe");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método verificaFavorito de Agenda com um contato favorito.
	 */
	@Test
	void testVerificaFavoritoExistente() {
		this.agenda.cadastraContato(7, "Ingrid", "Jackeline", "(81) 89920-0987");
		this.agenda.adicionaFavorito(7, 1);
		assertTrue(this.agenda.verificaFavorito(7));
	}
	
	/**
	 * Testa o método verificaFavorito de Agenda com um contato não favorito.
	 */
	@Test
	void testVerificaFavoritoInexistente() {
		this.agenda.cadastraContato(7, "Ingrid", "Jackeline", "(81) 89920-0987");
		assertFalse(this.agenda.verificaFavorito(7));
	}
	
	/**
	 * Testa o método adicionaFavorito de Agenda com todos os parâmetros válidos.
	 */
	@Test
	void testAdicionaFavoritoCasoBase() {
		this.agenda.cadastraContato(1, "Ingrid", "Jackeline", "(81) 32192-9876");
		this.agenda.adicionaFavorito(1, 1);
	}
		
	/**
	 * Testa o método adicionaFavorito de Agenda com a posição de contato no limite 
	 * inferior.
	 */
	@Test
	void testAdicionaFavoritoPosicaoContatoLimiteInferior() {
		this.agenda.cadastraContato(1, "Ingrid", "Jackeline", "(81) 89920-0987");
		this.agenda.adicionaFavorito(1, 5);
	}
	
	/**
	 * Testa o método adicionaFavorito de Agenda com a posição de contato no limite 
	 * superior.
	 */
	@Test
	void testAdicionaFavoritoPosicaoContatoLimiteSuperior() {
		this.agenda.cadastraContato(100, "Ingrid", "Jackeline", "(81) 89920-0987");
		this.agenda.adicionaFavorito(100, 5);
	}
	
	/**
	 * Testa o método adicionaFavorito de Agenda com uma posição de contato abaixo 
	 * do limite inferior.
	 */
	@Test
	void testAdicionaFavoritoPosicaoContatoAbaixoLimiteInferior() {
		try {
			this.agenda.adicionaFavorito(0, 5);
			fail("A posição para o contato não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método adicionaFavorito de Agenda com uma posição de contato acima 
	 * do limite superior.
	 */
	@Test
	void testAdicionaFavoritoPosicaoContatoAcimaLimiteSuperior() {
		try {
			this.agenda.adicionaFavorito(101, 5);
			fail("A posição para o contato não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método adicionaFavorito de Agenda com a posição de contato favorito 
	 * no limite inferior.
	 */
	@Test
	void testAdicionaFavoritoPosicaoFavoritoLimiteInferior() {
		this.agenda.cadastraContato(20, "Ingrid", "Jackeline", "(81) 89920-0987");
		this.agenda.adicionaFavorito(20, 1);
	}
	
	/**
	 * Testa o método adicionaFavorito de Agenda com a posição de contato favorito 
	 * no limite superior.
	 */
	@Test
	void testAdicionaFavoritoPosicaoFavoritoLimiteSuperior() {
		this.agenda.cadastraContato(20, "Ingrid", "Jackeline", "(81) 89920-0987");
		this.agenda.adicionaFavorito(20, 10);
	}
	
	/**
	 * Testa o método adicionaFavorito de Agenda com a posição de contato favorito 
	 * abaixo do limite inferior.
	 */
	@Test
	void testAdicionaFavoritoPosicaoFavoritoAbaixoLimiteInferior() {
		try {
			this.agenda.adicionaFavorito(20, 0);
			fail("A posição para o contato favorito não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método adicionaFavorito de Agenda com a posição de contato favorito 
	 * acima do limite superior.
	 */
	@Test
	void testAdicionaFavoritoPosicaoFavoritoAcimaLimiteSuperior() {
		try {
			this.agenda.adicionaFavorito(20, 11);
			fail("A posição para o contato favorito não existe");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}

	/**
	 * Testa o método adicionaFavorito de Agenda com um contato nulo.
	 */
	@Test
	void testAdicionaFavoritoContatoNulo() {
		try {
			this.agenda.adicionaFavorito(38, 1);
			fail("O contato não existe");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método adicionaFavorito de Agenda com um contato já favoritado.
	 */
	@Test
	void testAdicionaFavoritoExistente() {
		try {
			this.agenda.cadastraContato(1, "Ingrid", "Jackeline", "(81) 32192-9876");
			this.agenda.adicionaFavorito(1, 1);
			this.agenda.adicionaFavorito(1, 3);
			fail("O contato já está favoritado");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método listaFavoritos de Agenda verificando a exibição da lista 
	 * de favoritos da agenda.
	 */
	@Test
	void testListaFavoritos() {
		this.agenda.cadastraContato(1, "Ingrid", "Jackeline", "(81) 32192-9876");
		this.agenda.cadastraContato(9, "Tania", "Maria", "(81) 54321-6789");
		this.agenda.cadastraContato(11, "Jacksivam", "Castro", "(81) 45784-2387");
		this.agenda.cadastraContato(16, "Aline", "Assis", "(81) 44839-3728");
		this.agenda.cadastraContato(39, "Loren", "Narrane", "(81) 56543-3298");
		this.agenda.cadastraContato(53, "Laila", "Naomi", "(81) 34328-9874");
		this.agenda.cadastraContato(82, "Lais", "Rosa", "(81) 32981-8921");
		this.agenda.cadastraContato(97, "Emily", "Gabriely", "(81) 34983-2391");
		this.agenda.adicionaFavorito(1, 3);
		this.agenda.adicionaFavorito(9, 1);
		this.agenda.adicionaFavorito(11, 2);
		this.agenda.adicionaFavorito(39, 4);
		assertEquals("\n1 - Tania Maria\n2 - Jacksivam Castro\n3 - Ingrid Jackeline\n4 - Loren Narrane", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método toString de Agenda verificando a exibição da lista de contatos 
	 * da agenda.
	 */
	@Test
	void testToString() {
		this.agenda.cadastraContato(1, "Ingrid", "Jackeline", "(81) 32192-9876");
		this.agenda.cadastraContato(2, "Aline", "Assis", "(81) 54321-6789");
		this.agenda.cadastraContato(3, "Loren", "Narrane", "(81) 45784-2387");
		this.agenda.cadastraContato(4, "Laila", "Naomi", "(81) 34328-9874");
		this.agenda.cadastraContato(5, "Lais", "Rosa", "(81) 32981-8921");
		this.agenda.cadastraContato(6, "Emily", "Gabriely", "(81) 34983-2391");
		assertEquals("\n1 - Ingrid Jackeline\n2 - Aline Assis\n3 - Loren Narrane\n4 - Laila Naomi\n5 - Lais Rosa\n6 - Emily Gabriely", this.agenda.toString());
	}

}