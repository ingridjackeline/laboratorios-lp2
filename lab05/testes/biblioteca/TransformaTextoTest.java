package biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testa todas as funcionalidades da classe TransformaTexto, bem como as possíveis 
 * exceções que podem ocorrer durante a sua execução.
 * 
 * @author Ingrid Jackeline
 *
 */
class TransformaTextoTest {

	/**
	 * O objeto transformaTexto a ser utilizado em todos os testes de funcionalidade.
	 */
	private TransformaTexto transformaTexto;
	
	/**
	 * Prepara o objeto transformaTexto que será utilizado em todos os testes.
	 */
	@BeforeEach
	void setUp() {
		this.transformaTexto = new TransformaTexto();
	}

	/**
	 * Testa o construtor com logger de TransformaTexto, utilizando um logger nulo 
	 * como parâmetro.
	 */
	@Test
	void testTransformaTextoComLoggerNulo() {
		try {
			new TransformaTexto(null);
			fail("Não é permitido deixar o logger nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o construtor sem logger de TransformaTexto, verificando se as 
	 * transformações padrões foram devidamente cadastradas com a inicialização 
	 * do objeto.
	 */
	@Test
	void testCadastraTransformacoesPadroes() {
		assertTrue(this.transformaTexto.getTiposTransformacoes().containsKey("CaMeLcAsEfY"));
		assertTrue(this.transformaTexto.getTiposTransformacoes().containsKey("clean"));
		assertTrue(this.transformaTexto.getTiposTransformacoes().containsKey("InterrogaPraPontos"));
		assertTrue(this.transformaTexto.getTiposTransformacoes().containsKey("upperCase"));
		assertTrue(this.transformaTexto.getTiposTransformacoes().containsKey("cleanSpaces"));
		assertTrue(this.transformaTexto.getTiposTransformacoes().containsKey("VogaisPraEstrelas"));
	}

	/**
	 * Testa o método cadastraTransformacao de TransformaTexto, utilizando um 
	 * tipo de transformação nulo como parâmetro.
	 */
	@Test
	void testCadastraTransformacaoComTipoTransformacaoNulo() {
		try {
			AlgoritmoTransformacao algoritmo = new CamelCaseFy();
			this.transformaTexto.cadastraTransformacao(null, algoritmo);
			fail("Não é permitido deixar o tipo de transformação nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método cadastraTransformacao de TransformaTexto, utilizando um 
	 * tipo de transformação vazio como parâmetro.
	 */
	@Test
	void testCadastraTransformacaoComTipoTransformacaoVazio() {
		try {
			AlgoritmoTransformacao algoritmo = new Clean();
			this.transformaTexto.cadastraTransformacao("", algoritmo);
			fail("Não é permitido deixar o tipo de transformação vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}

	/**
	 * Testa o método cadastraTransformacao de TransformaTexto, utilizando um 
	 * algoritmo de transformação nulo como parâmetro.
	 */
	@Test
	void testCadastraTransformacaoComAlgoritmoTransformacaoNulo() {
		try {
			this.transformaTexto.cadastraTransformacao("Clean", null);
			fail("Não é permitido deixar o algoritmo de transformação nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método cadastraTransformacao de TransformaTexto, cadastrando um tipo 
	 * de transformação válido.
	 */
	@Test
	void testCadastraTransformacaoValida() {
		AlgoritmoTransformacao algoritmo = new VogaisPraEstrelas();
		this.transformaTexto.cadastraTransformacao("vogaispraestrelas", algoritmo);
		assertTrue(this.transformaTexto.getTiposTransformacoes().containsKey("vogaispraestrelas"));
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando um tipo de 
	 * transformação nulo como parâmetro.
	 */
	@Test
	void testTransformaComTipoTransformacaoNulo() {
		try {
			this.transformaTexto.transforma(null, "oi, como vc vai?");
			fail("Não é permitido deixar o tipo de transformação nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando um tipo de 
	 * transformação vazio como parâmetro.
	 */
	@Test
	void testTransformaComTipoTransformacaoVazio() {
		try {
			this.transformaTexto.transforma("", "oi, como vc vai?");
			fail("Não é permitido deixar o tipo de transformação vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando um tipo de 
	 * transformação não cadastrado como parâmetro.
	 */
	@Test
	void testTransformaComTipoTransformacaoNaoCadastrado() {
		try {
			this.transformaTexto.transforma("lowerCase", "oi, como vc vai?");
			fail("Não é permitido realizar a operação com um tipo de transformação não cadastrado.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando um texto original 
	 * nulo como parâmetro.
	 */
	@Test
	void testTransformaComTextoOriginalNulo() {
		try {
			this.transformaTexto.transforma("clean", null);
			fail("Não é permitido deixar o texto original nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando um texto original 
	 * vazio como parâmetro.
	 */
	@Test
	void testTransformaComTextoOriginalVazio() {
		try {
			this.transformaTexto.transforma("upperCase", "");
			fail("Não é permitido deixar o texto original vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação CamelCaseFy e um texto com letras minúsculas e sinais de 
	 * pontuação.
	 */
	@Test
	void testTransformaComCamelCaseFyLetrasMinusculasEPontuacao() {
		assertEquals(this.transformaTexto.transforma("CaMeLcAsEfY", "oi, como vc vai?"), "Oi, CoMo vC VaI?");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação CamelCaseFy e um texto com letras maiúsculas e sinais de 
	 * pontuação.
	 */
	@Test
	void testTransformaComCamelCaseFyLetrasMaiusculasEPontuacao() {
		assertEquals(this.transformaTexto.transforma("CaMeLcAsEfY", "OLÁ! VENHA CONFERIR AS PROMOÇÕES DA NOSSA LOJA."), "OlÁ! vEnHa cOnFeRiR As pRoMoÇõEs dA NoSsA LoJa.");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação CamelCaseFy e um texto com letras alternadas entre 
	 * maiúsculas e minúsculas e números.
	 */
	@Test
	void testTransformaComCamelCaseFyLetrasAlternadasENumeros() {
		assertEquals(this.transformaTexto.transforma("CaMeLcAsEfY", "o pEdIdO CoNtÉm 150 cOxInHaS E 270 EmPaDiNhAs"), "O PeDiDo cOnTéM 150 CoXiNhAs e 270 eMpAdInHaS");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação CamelCaseFy e um texto com números e sinais de pontuação.
	 */
	@Test
	void testTransformaComCamelCaseFyNumerosEPontuacao() {
		assertEquals(this.transformaTexto.transforma("CaMeLcAsEfY", "1281:.,;!@#$%2139238-*+/(){}[]=&594"), "1281:.,;!@#$%2139238-*+/(){}[]=&594");
	}

	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação Clean e um texto com letras e sinais de pontuação.
	 */
	@Test
	void testTransformaComCleanLetrasEPontuacao() {
		assertEquals(this.transformaTexto.transforma("clean", "Oi, Como Vc Vai? Eu estou bem! E você?"), "Oi Como Vc Vai Eu estou bem E você");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação Clean e um texto com números e sinais de pontuação.
	 */
	@Test
	void testTransformaComCleanNumerosEPontuacao() {
		assertEquals(this.transformaTexto.transforma("clean", "@(456 * 50) / 5% + 4.6 - [$456] : #323 = {89} + |-41|"), "456  50  5  46  456  323  89  41");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação Clean e um texto apenas com sinais de pontuação.
	 */
	@Test
	void testTransformaComCleanApenasPontuacao() {
		assertEquals(this.transformaTexto.transforma("clean", "!@#$%&*()_-/*-+?,.:;{}[]<>'|"), "");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação Clean e um texto sem sinais de pontuação.
	 */
	@Test
	void testTransformaComCleanSemPontuacao() {
		assertEquals(this.transformaTexto.transforma("clean", "O torneio de vôlei começará às 17h na quadra do centro da cidade"), "O torneio de vôlei começará às 17h na quadra do centro da cidade");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação InterrogaPraPontos e um texto com sinais de interrogação.
	 */
	@Test
	void testTransformaComInterrogaPraPontosTextoComInterrogacoes() {
		assertEquals(this.transformaTexto.transforma("InterrogaPraPontos", "Oi? Tudo bem com você?? Como foi a mudança? Você vai se mudar de novo???"), "Oi. Tudo bem com você.. Como foi a mudança. Você vai se mudar de novo...");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação InterrogaPraPontos e um texto sem sinais de interrogação.
	 */
	@Test
	void testTransformaComInterrogaPraPontosTextoSemInterrogacoes() {
		assertEquals(this.transformaTexto.transforma("InterrogaPraPontos", "Os pedidos do supermercado foram estes: 5 tomates, 2 batatas, 4 cenouras e 3 chuchus!!"), "Os pedidos do supermercado foram estes: 5 tomates, 2 batatas, 4 cenouras e 3 chuchus!!");
	}

	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação InterrogaPraPontos e um texto com pontos finais.
	 */
	@Test
	void testTransformaComInterrogaPraPontosTextoComPontos() {
		assertEquals(this.transformaTexto.transforma("InterrogaPraPontos", "Bolsas. Sapatos. Calças. Blusas. Vestidos. Acessórios."), "Bolsas. Sapatos. Calças. Blusas. Vestidos. Acessórios.");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação UpperCase e um texto com letras minúsculas e sinais de 
	 * pontuação.
	 */
	@Test
	void testTransformaComUpperCaseTextoComLetrasMinusculas() {
		assertEquals(this.transformaTexto.transforma("upperCase", "olá, como você está? tenho muitas novidades."), "OLÁ, COMO VOCÊ ESTÁ? TENHO MUITAS NOVIDADES.");
	}

	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação UpperCase e um texto com letras maiúsculas e sinais de 
	 * pontuação.
	 */
	@Test
	void testTransformaComUpperCaseTextoComLetrasMaiusculas() {
		assertEquals(this.transformaTexto.transforma("upperCase", "EU ESTOU BEM! COMO ESTÃO OS PREPARATIVOS PARA A FESTA?"), "EU ESTOU BEM! COMO ESTÃO OS PREPARATIVOS PARA A FESTA?");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação UpperCase e um texto com letras alternadas entre maiúsculas e 
	 * minúsculas e números.
	 */
	@Test
	void testTransformaComUpperCaseTextoComLetrasAlternadasENumeros() {
		assertEquals(this.transformaTexto.transforma("upperCase", "Os CeNárIoS 1, 2 e 3 aPReSEnTaDos nÃo CoNdIzEm cOm a ReALiDAdE."), "OS CENÁRIOS 1, 2 E 3 APRESENTADOS NÃO CONDIZEM COM A REALIDADE.");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação UpperCase e um texto sem letras.
	 */
	@Test
	void testTransformaComUpperCaseTextoSemLetras() {
		assertEquals(this.transformaTexto.transforma("upperCase", "{120 * [458 + 50 / (23493 - 3299)] ** 7}"), "{120 * [458 + 50 / (23493 - 3299)] ** 7}");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação CleanSpaces e um texto com letras, sinais de pontuação e 
	 * espaços.
	 */
	@Test
	void testTransformaComCleanSpacesTextoComLetrasPontuacaoEEspacos() {
		assertEquals(this.transformaTexto.transforma("cleanSpaces", "Olá. Como você vai? Os pedidos de entrega já estão prontos!!"), "Olá.Comovocêvai?Ospedidosdeentregajáestãoprontos!!");
	}

	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação CleanSpaces e um texto com números, sinais de pontuação e 
	 * espaços.
	 */
	@Test
	void testTransformaComCleanSpacesTextoComNumerosPontuacaoEEspacos() {
		assertEquals(this.transformaTexto.transforma("cleanSpaces", "{345 + [211 - 456 * (87 / 7)] * 5}"), "{345+[211-456*(87/7)]*5}");
	}

	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação CleanSpaces e um texto sem espaços.
	 */
	@Test
	void testTransformaComCleanSpacesTextoSemEspacos() {
		assertEquals(this.transformaTexto.transforma("cleanSpaces", "Livros,cadernos,canetas,lápis?Lapiseira,estojo,régua."), "Livros,cadernos,canetas,lápis?Lapiseira,estojo,régua.");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação VogaisPraEstrelas e um texto com vogais minúsculas.
	 */
	@Test
	void testTransformaComVogaisPraEstrelasTextoComVogaisMinusculas() {
		assertEquals(this.transformaTexto.transforma("VogaisPraEstrelas", "a receita desse bolo leva ingredientes como o açúcar, a farinha de trigo e o leite."), "✰ r✰c✰✰t✰ d✰ss✰ b✰l✰ l✰v✰ ✰ngr✰d✰✰nt✰s c✰m✰ ✰ ✰ç✰c✰r, ✰ f✰r✰nh✰ d✰ tr✰g✰ ✰ ✰ l✰✰t✰.");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação VogaisPraEstrelas e um texto com vogais maiúsculas.
	 */
	@Test
	void testTransformaComVogaisPraEstrelasTextoComVogaisMaiusculas() {
		assertEquals(this.transformaTexto.transforma("VogaisPraEstrelas", "O BRÓCOLIS, O FEIJÃO E O PÊSSEGO ESTÃO EM FALTA NO SUPERMERCADO!"), "✰ BR✰C✰L✰S, ✰ F✰✰J✰✰ ✰ ✰ P✰SS✰G✰ ✰ST✰✰ ✰M F✰LT✰ N✰ S✰P✰RM✰RC✰D✰!");
	}

	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação VogaisPraEstrelas e um texto com vogais alternadas entre maiúsculas 
	 * e minúsculas e números.
	 */
	@Test
	void testTransformaComVogaisPraEstrelasTextoComVogaisAlternadasENumeros() {
		assertEquals(this.transformaTexto.transforma("VogaisPraEstrelas", "Os nÚmeros 340 e 505 Da FroTA de ôNIbuS EsTãO iNdISpoNÍvEis nO moMeNTO."), "✰s n✰m✰r✰s 340 ✰ 505 D✰ Fr✰T✰ d✰ ✰N✰b✰S ✰sT✰✰ ✰Nd✰Sp✰N✰v✰✰s n✰ m✰M✰NT✰.");
	}
	
	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação VogaisPraEstrelas e um texto sem vogais.
	 */
	@Test
	void testTransformaComVogaisPraEstrelasTextoSemVogais() {
		assertEquals(this.transformaTexto.transforma("VogaisPraEstrelas", "Td crt. Vlw!!"), "Td crt. Vlw!!");
	}

	/**
	 * Testa o método transforma de TransformaTexto, utilizando o tipo de 
	 * transformação VogaisPraEstrelas e um texto com estrelas.
	 */
	@Test
	void testTransformaComVogaisPraEstrelasTextoComEstrelas() {
		assertEquals(this.transformaTexto.transforma("VogaisPraEstrelas", "H✰j✰ ✰ d✰✰ ✰st✰ ✰ns✰l✰r✰d✰ ✰ q✰✰nt✰."), "H✰j✰ ✰ d✰✰ ✰st✰ ✰ns✰l✰r✰d✰ ✰ q✰✰nt✰.");
	}
	
	/**
	 * Testa o método contaTransformacao de TransformaTexto, verificando a 
	 * contagem de nenhuma transformação realizada no sistema.
	 */
	@Test
	void testContaNenhumaTransformacaoRealizada() {
		assertEquals(this.transformaTexto.contaTransformacao(), 0);
	}
	
	/**
	 * Testa o método contaTransformacao de TransformaTexto, verificando a 
	 * contagem de transformações repetidas realizadas no sistema.
	 */
	@Test
	void testContaTransformacoesRepetidasRealizadas() {
		this.transformaTexto.transforma("CaMeLcAsEfY", "Olá, mundo!");
		this.transformaTexto.transforma("clean", "oi, como vc vai?");
		this.transformaTexto.transforma("CaMeLcAsEfY", "Olá, mundo!");
		this.transformaTexto.transforma("clean", "oi, como vc vai?");
		this.transformaTexto.transforma("InterrogaPraPontos", "Onde você mora?");
		assertEquals(this.transformaTexto.contaTransformacao(), 5);
	}
	
	/**
	 * Testa o método contaTransformacao de TransformaTexto, verificando a 
	 * contagem de transformações diferentes realizadas no sistema.
	 */
	@Test
	void testContaTransformacoesDiferentesRealizadas() {
		this.transformaTexto.transforma("CaMeLcAsEfY", "Olá, mundo!");
		this.transformaTexto.transforma("clean", "oi, como vc vai?");
		this.transformaTexto.transforma("cleanSpaces", "A COMIDA QUEIMOU NA PANELA!");
		this.transformaTexto.transforma("upperCase", "O produto está fora de estoque!");
		this.transformaTexto.transforma("InterrogaPraPontos", "onde você mora?");
		this.transformaTexto.transforma("VogaisPraEstrelas", "O quadro ainda não foi pintado?");
		this.transformaTexto.transforma("upperCase", "O esmalte que comprei é verde.");
		this.transformaTexto.transforma("VogaisPraEstrelas", "ESTÁ CHOVENDO MUITO!!");
		assertEquals(this.transformaTexto.contaTransformacao(), 8);
	}

	/**
	 * Testa o método historico de TransformaTexto, utilizando uma posição 
	 * abaixo do limite inferior permitido como parâmetro.
	 */
	@Test
	void testHistoricoPosicaoAbaixoDoLimiteInferior() {
		try {
			this.transformaTexto.historico(-1);
			fail("Não é permitido acessar uma transformação com posição negativa no histórico.");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}

	/**
	 * Testa o método historico de TransformaTexto, utilizando uma posição 
	 * no limite inferior permitido, mas com o histórico vazio.
	 */
	@Test
	void testHistoricoVazioPosicaoNoLimiteInferior() {
		try {
			this.transformaTexto.historico(0);
			fail("Não é permitido acessar uma posição inexistente no histórico.");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método historico de TransformaTexto, utilizando uma posição 
	 * no limite inferior permitido como parâmetro.
	 */
	@Test
	void testHistoricoPosicaoNoLimiteInferior() {
		this.transformaTexto.transforma("cleanSpaces", "O dia está chuvoso hoje.");
		this.transformaTexto.transforma("clean", "oi, como vc vai?");
		assertEquals(this.transformaTexto.historico(0), "O dia está chuvoso hoje. -> cleanSpaces -> Odiaestáchuvosohoje.");
	}
	
	/**
	 * Testa o método historico de TransformaTexto, utilizando uma posição 
	 * no limite superior permitido como parâmetro.
	 */
	@Test
	void testHistoricoPosicaoNoLimiteSuperior() {
		this.transformaTexto.transforma("cleanSpaces", "oi, como vc vai?");
		this.transformaTexto.transforma("clean", "O dia está chuvoso hoje.");
		this.transformaTexto.transforma("upperCase", "Eu perdi o meu celular!");
		this.transformaTexto.transforma("InterrogaPraPontos", "Está tudo bem???");
		assertEquals(this.transformaTexto.historico(3), "Está tudo bem??? -> InterrogaPraPontos -> Está tudo bem...");
	}
	
	/**
	 * Testa o método historico de TransformaTexto, utilizando uma posição 
	 * acima do limite superior permitido como parâmetro.
	 */
	@Test
	void testHistoricoPosicaoAcimaDoLimiteSuperior() {
		this.transformaTexto.transforma("cleanSpaces", "oi, como vc vai?");
		this.transformaTexto.transforma("clean", "O dia está chuvoso hoje.");
		this.transformaTexto.transforma("upperCase", "Eu perdi o meu celular!");
		this.transformaTexto.transforma("InterrogaPraPontos", "Está tudo bem???");
		try {
			this.transformaTexto.historico(4);
			fail("Não é permitido acessar uma posição inexistente no histórico.");
		} catch (IndexOutOfBoundsException ioobe) {
			
		}
	}
	
	/**
	 * Testa o método historico de TransformaTexto, verificando a exibição 
	 * de posições que apresentam transformações repetidas.
	 */
	@Test
	void testHistoricoPosicoesComTransformacoesRepetidas() {
		this.transformaTexto.transforma("CaMeLcAsEfY", "a rEcEiTa dO BoLo eStÁ InCoMpLeTa!");
		this.transformaTexto.transforma("CaMeLcAsEfY", "a rEcEiTa dO BoLo eStÁ InCoMpLeTa!");
		this.transformaTexto.transforma("VogaisPraEstrelas", "Frutas: abacaxi, melancia, pêssego e cupuaçu.");
		this.transformaTexto.transforma("CaMeLcAsEfY", "a rEcEiTa dO BoLo eStÁ InCoMpLeTa!");
		this.transformaTexto.transforma("clean", "Olá, tudo bem? Não se esqueça da reunião às 14h!!");
		assertEquals(this.transformaTexto.historico(0), "a rEcEiTa dO BoLo eStÁ InCoMpLeTa! -> CaMeLcAsEfY -> A ReCeItA Do bOlO EsTá iNcOmPlEtA!");
		assertEquals(this.transformaTexto.historico(1), "a rEcEiTa dO BoLo eStÁ InCoMpLeTa! -> CaMeLcAsEfY -> A ReCeItA Do bOlO EsTá iNcOmPlEtA!");
		assertEquals(this.transformaTexto.historico(3), "a rEcEiTa dO BoLo eStÁ InCoMpLeTa! -> CaMeLcAsEfY -> A ReCeItA Do bOlO EsTá iNcOmPlEtA!");
	}
	
	/**
	 * Testa o método historico de TransformaTexto, verificando a exibição 
	 * de todas as posições existentes no histórico.
	 */
	@Test
	void testHistoricoTodasAsPosicoesExistentes() {
		this.transformaTexto.transforma("cleanSpaces", "oi, como vc vai?");
		this.transformaTexto.transforma("clean", "Olá, tudo bem? Não se esqueça da reunião às 14h!!");
		this.transformaTexto.transforma("upperCase", "Eu perdi o meu celular!");
		this.transformaTexto.transforma("InterrogaPraPontos", "Está tudo bem???");
		this.transformaTexto.transforma("CaMeLcAsEfY", "a rEcEiTa dO BoLo eStÁ InCoMpLeTa!");
		this.transformaTexto.transforma("VogaisPraEstrelas", "Frutas: abacaxi, melancia, pêssego e cupuaçu.");
		assertEquals(this.transformaTexto.historico(0), "oi, como vc vai? -> cleanSpaces -> oi,comovcvai?");
		assertEquals(this.transformaTexto.historico(1), "Olá, tudo bem? Não se esqueça da reunião às 14h!! -> clean -> Olá tudo bem Não se esqueça da reunião às 14h");
		assertEquals(this.transformaTexto.historico(2), "Eu perdi o meu celular! -> upperCase -> EU PERDI O MEU CELULAR!");
		assertEquals(this.transformaTexto.historico(3), "Está tudo bem??? -> InterrogaPraPontos -> Está tudo bem...");
		assertEquals(this.transformaTexto.historico(4), "a rEcEiTa dO BoLo eStÁ InCoMpLeTa! -> CaMeLcAsEfY -> A ReCeItA Do bOlO EsTá iNcOmPlEtA!");
		assertEquals(this.transformaTexto.historico(5), "Frutas: abacaxi, melancia, pêssego e cupuaçu. -> VogaisPraEstrelas -> Fr✰t✰s: ✰b✰c✰x✰, m✰l✰nc✰✰, p✰ss✰g✰ ✰ c✰p✰✰ç✰.");
	}
	
	/**
	 * Testa o método listaOriginais de TransformaTexto, verificando a exibição da lista 
	 * sem textos originais.
	 */
	@Test
	void testListaOriginaisVazia() {
		assertEquals(this.transformaTexto.listaOriginais(), "");
	}
	
	/**
	 * Testa o método listaOriginais de TransformaTexto, verificando a exibição de 
	 * textos iguais e com a mesma case que sofreram as mesmas transformações.
	 */
	@Test
	void testListaOriginaisComTransformacoesIguaisETextosRepetidosComAMesmaCase() {
		this.transformaTexto.transforma("upperCase", "oi, como vc vai?");
		this.transformaTexto.transforma("upperCase", "oi, como vc vai?");
		assertEquals(this.transformaTexto.listaOriginais(), "oi, como vc vai?");
	}
	
	/**
	 * Testa o método listaOriginais de TransformaTexto, verificando a exibição de 
	 * textos iguais e com a mesma case que sofreram transformações diferentes.
	 */
	@Test
	void testListaOriginaisComTransformacoesDiferentesETextosRepetidosComAMesmaCase() {
		this.transformaTexto.transforma("upperCase", "Olá, mundo!");
		this.transformaTexto.transforma("cleanSpaces", "Olá, mundo!");
		assertEquals(this.transformaTexto.listaOriginais(), "Olá, mundo!");
	}
	
	/**
	 * Testa o método listaOriginais de TransformaTexto, verificando a exibição de 
	 * textos iguais, mas com cases diferentes, que sofreram as mesmas transformações.
	 */
	@Test
	void testListaOriginaisComTransformacoesIguaisETextosRepetidosComCasesDiferentes() {
		this.transformaTexto.transforma("upperCase", "oi, como vc vai?");
		this.transformaTexto.transforma("upperCase", "Oi, como vc vai?");
		this.transformaTexto.transforma("upperCase", "Oi, Como Vc Vai?");
		assertEquals(this.transformaTexto.listaOriginais(), "Oi, Como Vc Vai?\noi, como vc vai?\nOi, como vc vai?");
	}
	
	/**
	 * Testa o método listaOriginais de TransformaTexto, verificando a exibição de 
	 * textos iguais, mas com cases diferentes, que sofreram transformações diferentes.
	 */
	@Test
	void testListaOriginaisComTransformacoesDiferentesETextosRepetidosComCasesDiferentes() {
		this.transformaTexto.transforma("clean", "olá, mundo!");
		this.transformaTexto.transforma("cleanSpaces", "Olá, Mundo!");
		this.transformaTexto.transforma("VogaisPraEstrelas", "olá, Mundo!");
		assertEquals(this.transformaTexto.listaOriginais(), "Olá, Mundo!\nolá, mundo!\nolá, Mundo!");
	}
	
	/**
	 * Testa o método listaOriginais de TransformaTexto, verificando a exibição de 
	 * textos diferentes que sofreram transformações diferentes.
	 */
	@Test
	void testListaOriginaisComTransformacoesDiferentesETextosDiferentes() {
		this.transformaTexto.transforma("CaMeLcAsEfY", "Boa noite a todos!");
		this.transformaTexto.transforma("clean", "Hoje o dia está ensolarado.");
		this.transformaTexto.transforma("cleanSpaces", "EU PERDI O MEU CELULAR!");
		this.transformaTexto.transforma("upperCase", "os pedidos já foram entregues!");
		this.transformaTexto.transforma("InterrogaPraPontos", "tudo bem com você?");
		this.transformaTexto.transforma("VogaisPraEstrelas", "O torneio de vôlei começa amanhã.");
		assertEquals(this.transformaTexto.listaOriginais(), "Hoje o dia está ensolarado.\nO torneio de vôlei começa amanhã.\nEU PERDI O MEU CELULAR!\nBoa noite a todos!\ntudo bem com você?\nos pedidos já foram entregues!");
	}

	/**
	 * Testa o método listaTransformacoes de TransformaTexto, verificando a exibição em 
	 * ordem alfabética de todos os tipos de transformações padrões já cadastrados no 
	 * sistema.
	 */
	@Test
	void testListaTransformacoes() {
		assertEquals(this.transformaTexto.listaTransformacoes(), "CaMeLcAsEfY\nclean\ncleanSpaces\nInterrogaPraPontos\nupperCase\nVogaisPraEstrelas");
	}
	
	/**
	 * Testa o logger ContagemLogger no TransformaTexto, verificando o registro e a 
	 * exibição das operações que foram realizadas no sistema.
	 */
	@Test
	void testContagemLoggerRegistraOperacoesRealizadas() {
		Logger logger = new ContagemLogger();
		TransformaTexto tt = new TransformaTexto(logger);
		tt.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		tt.transforma("clean", "oi, como vc vai?");
		tt.contaTransformacao();
		tt.historico(0);
		tt.transforma("clean", "olá, tudo bem?");
		tt.listaOriginais();
		tt.contaTransformacao();
		tt.listaTransformacoes();
		tt.historico(1);
		assertEquals(logger.toString(), "listaOriginais - 1\nlistaTransformacoes - 1\nhistorico - 2\ncontaTransformacao - 2\ntransforma - 3");
	}

}