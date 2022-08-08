package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentoRepositoryTest {

	private DocumentoRepository documentoRepository;
	
	@BeforeEach
	void setUp() {
		this.documentoRepository = new DocumentoRepository();
	}
	
	@Test
	void testAdicionaDocumentoNulo() {
		try {
			this.documentoRepository.adiciona(null);
			fail("Não é permitido adicionar um documento nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testAdicionaERecuperaDocumentoJava() {
		Documento documentoJava = new DocumentoJava("o213hig", "Olá, tudo bem?");
		this.documentoRepository.adiciona(documentoJava);
		assertEquals(this.documentoRepository.recupera("o213hig").get(), documentoJava);
	}
	
	@Test
	void testAdicionaERecuperaDocumentoHtml() {
		Documento documentoHtml = new DocumentoHtml("S23ID9", "O dia está ensolarado hoje.");
		this.documentoRepository.adiciona(documentoHtml);
		assertEquals(this.documentoRepository.recupera("S23ID9").get(), documentoHtml);
	}
	
	@Test
	void testAdicionaERecuperaDocumentoTexto() {
		Documento documentoTexto = new DocumentoTexto("23uhse829df", "Amanhã é o meu aniversário!");
		this.documentoRepository.adiciona(documentoTexto);
		assertEquals(this.documentoRepository.recupera("23uhse829df").get(), documentoTexto);
	}

	@Test
	void testRecuperaDocumentoIdNulo() {
		try {
			this.documentoRepository.recupera(null);
			fail("Não é permitido recuperar um documento com id nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testRecuperaDocumentoIdVazio() {
		try {
			this.documentoRepository.recupera("");
			fail("Não é permitido recuperar um documento com id vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testTotalDocumentosVazio() {
		assertEquals(this.documentoRepository.totalDocumentos(), 0);
	}

	@Test
	void testTotalDocumentos() {
		this.documentoRepository.adiciona(new DocumentoJava("o213hig", "Olá, tudo bem?"));
		this.documentoRepository.adiciona(new DocumentoHtml("S23ID9", "O dia está ensolarado hoje."));
		this.documentoRepository.adiciona(new DocumentoTexto("23uhse829df", "Amanhã é o meu aniversário!"));
		this.documentoRepository.adiciona(new DocumentoJava("238472fe8", "As classes estão completas."));
		assertEquals(this.documentoRepository.totalDocumentos(), 4);
	}

	@Test
	void testBuscaTermoNulo() {
		try {
			this.documentoRepository.busca(null);
			fail("Não é permitido pesquisar um termo nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaTermoVazio() {
		try {
			this.documentoRepository.busca("");
			fail("Não é permitido pesquisar um termo vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}

	@Test
	void testBuscaTermoValido() {
		Documento documentoJava1 = new DocumentoJava("o213hig", "Olá, hoje é o dia do nosso evento!");
		Documento documentoHtml1 = new DocumentoHtml("S23ID9", "O dia está ensolarado hoje.");
		Documento documentoTexto1 = new DocumentoTexto("23uhse829df", "Hoje é o meu aniversário!");
		Documento documentoJava2 = new DocumentoJava("238472fe8", "As classes estão completas.");
		Documento documentoTexto2 = new DocumentoTexto("addwhe21", "Não sei se resolverei esse problema hoje.");
		this.documentoRepository.adiciona(documentoJava1);
		this.documentoRepository.adiciona(documentoHtml1);
		this.documentoRepository.adiciona(documentoTexto1);
		this.documentoRepository.adiciona(documentoJava2);
		this.documentoRepository.adiciona(documentoTexto2);
		
		Set<Documento> documentosEncontrados = this.documentoRepository.busca("hoje");
		assertTrue(documentosEncontrados.contains(documentoJava1));
		assertTrue(documentosEncontrados.contains(documentoHtml1));
		assertFalse(documentosEncontrados.contains(documentoTexto1));
		assertFalse(documentosEncontrados.contains(documentoJava2));
		assertTrue(documentosEncontrados.contains(documentoTexto2));
	}
	
	@Test
	void testBuscaTipoMetadadoNulo() {
		try {
			this.documentoRepository.busca(null, "txt");
			fail("Não é permitido pesquisar um tipo de metadado nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaTipoMetadadoVazio() {
		try {
			this.documentoRepository.busca("", "txt");
			fail("Não é permitido pesquisar um tipo de metadado vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testBuscaMetadadoNulo() {
		try {
			this.documentoRepository.busca("TIPO", null);
			fail("Não é permitido pesquisar um metadado nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaMetadadoVazio() {
		try {
			this.documentoRepository.busca("TIPO", "");
			fail("Não é permitido pesquisar um metadado vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}

	@Test
	void testBuscaTipoMetadadoEMetadadoValidos() {
		Documento documentoJava1 = new DocumentoJava("o213hig", "Olá, hoje é o dia do nosso evento!");
		Documento documentoHtml1 = new DocumentoHtml("S23ID9", "O dia está ensolarado hoje.");
		Documento documentoTexto1 = new DocumentoTexto("23uhse829df", "Hoje é o meu aniversário!");
		Documento documentoJava2 = new DocumentoJava("238472fe8", "As classes estão completas.");
		Documento documentoTexto2 = new DocumentoTexto("addwhe21", "Não sei se resolverei esse problema hoje.");
		this.documentoRepository.adiciona(documentoJava1);
		this.documentoRepository.adiciona(documentoHtml1);
		this.documentoRepository.adiciona(documentoTexto1);
		this.documentoRepository.adiciona(documentoJava2);
		this.documentoRepository.adiciona(documentoTexto2);
		
		Set<Documento> documentosEncontrados = this.documentoRepository.busca("TIPO", "java");
		assertTrue(documentosEncontrados.contains(documentoJava1));
		assertFalse(documentosEncontrados.contains(documentoHtml1));
		assertFalse(documentosEncontrados.contains(documentoTexto1));
		assertTrue(documentosEncontrados.contains(documentoJava2));
		assertFalse(documentosEncontrados.contains(documentoTexto2));
	}

}