package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentoServiceTest {

	private DocumentoService documentoService;
	
	@BeforeEach
	void setUp() {
		this.documentoService = new DocumentoService();
	}

	@Test
	void testAdicionaDocumentoNulo() {
		try {
			this.documentoService.adicionaDocumento(null);
			fail("Não é permitido adicionar um documento nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testAdicionaERecuperaDocumentoJava() {
		Documento documentoJava = new DocumentoJava("o213hig", "Olá, tudo bem?");
		this.documentoService.adicionaDocumento(documentoJava);
		assertEquals(this.documentoService.recuperaDocumento("o213hig").get(), documentoJava);
	}
	
	@Test
	void testAdicionaERecuperaDocumentoHtml() {
		Documento documentoHtml = new DocumentoHtml("S23ID9", "O dia está ensolarado hoje.");
		this.documentoService.adicionaDocumento(documentoHtml);
		assertEquals(this.documentoService.recuperaDocumento("S23ID9").get(), documentoHtml);
	}
	
	@Test
	void testAdicionaERecuperaDocumentoTexto() {
		Documento documentoTexto = new DocumentoTexto("23uhse829df", "Amanhã é o meu aniversário!");
		this.documentoService.adicionaDocumento(documentoTexto);
		assertEquals(this.documentoService.recuperaDocumento("23uhse829df").get(), documentoTexto);
	}

	@Test
	void testRecuperaDocumentoIdNulo() {
		try {
			this.documentoService.recuperaDocumento(null);
			fail("Não é permitido recuperar um documento com id nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testRecuperaDocumentoIdVazio() {
		try {
			this.documentoService.recuperaDocumento("");
			fail("Não é permitido recuperar um documento com id vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testTotalDocumentosVazio() {
		assertEquals(this.documentoService.totalDocumentos(), 0);
	}

	@Test
	void testTotalDocumentos() {
		this.documentoService.adicionaDocumento(new DocumentoJava("o213hig", "Olá, tudo bem?"));
		this.documentoService.adicionaDocumento(new DocumentoHtml("S23ID9", "O dia está ensolarado hoje."));
		this.documentoService.adicionaDocumento(new DocumentoTexto("23uhse829df", "Amanhã é o meu aniversário!"));
		this.documentoService.adicionaDocumento(new DocumentoJava("238472fe8", "As classes estão completas."));
		this.documentoService.adicionaDocumento(new DocumentoTexto("addwhe21", "Não sei como resolver essa questão."));
		assertEquals(this.documentoService.totalDocumentos(), 5);
	}

	@Test
	void testConcatenaPrimeiroDocumentosIdNulo() {
		this.documentoService.adicionaDocumento(new DocumentoJava("o213hig", "Olá, tudo bem?"));
		try {
			this.documentoService.concatena(null, "o213hig");
			fail("Não é permitido concatenar documento com id nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testConcatenaPrimeiroDocumentoIdVazio() {
		this.documentoService.adicionaDocumento(new DocumentoJava("o213hig", "Olá, tudo bem?"));
		try {
			this.documentoService.concatena("", "o213hig");
			fail("Não é permitido concatenar documento com id vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testConcatenaSegundoDocumentosIdNulo() {
		this.documentoService.adicionaDocumento(new DocumentoTexto("23uhse829df", "Amanhã é o meu aniversário!"));
		try {
			this.documentoService.concatena("23uhse829df", null);
			fail("Não é permitido concatenar documento com id nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testConcatenaSegundoDocumentoIdVazio() {
		this.documentoService.adicionaDocumento(new DocumentoTexto("23uhse829df", "Amanhã é o meu aniversário!"));
		try {
			this.documentoService.concatena("23uhse829df", "");
			fail("Não é permitido concatenar documento com id vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testConcatenaDocumentosNovoIdGerado() {
		this.documentoService.adicionaDocumento(new DocumentoHtml("S23ID9", "O dia está ensolarado hoje."));
		this.documentoService.adicionaDocumento(new DocumentoTexto("23uhse829df", "Amanhã é o meu aniversário!"));
		assertEquals(this.documentoService.concatena("S23ID9", "23uhse829df"), "_MERGES23ID9|23uhse829df");
	}

	@Test
	void testSumarizaDocumentoIdNulo() {
		try {
			this.documentoService.sumariza(null);
			fail("Não é permitido sumarizar documento com id nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testSumarizaDocumentoIdVazio() {
		try {
			this.documentoService.sumariza("");
			fail("Não é permitido sumarizar documento com id vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	
	@Test
	void testBuscaTermoNulo() {
		try {
			this.documentoService.busca(null);
			fail("Não é permitido pesquisar um termo nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaTermoVazio() {
		try {
			this.documentoService.busca("");
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
		this.documentoService.adicionaDocumento(documentoJava1);
		this.documentoService.adicionaDocumento(documentoHtml1);
		this.documentoService.adicionaDocumento(documentoTexto1);
		this.documentoService.adicionaDocumento(documentoJava2);
		this.documentoService.adicionaDocumento(documentoTexto2);
		
		Set<Documento> documentosEncontrados = this.documentoService.busca("hoje");
		assertTrue(documentosEncontrados.contains(documentoJava1));
		assertTrue(documentosEncontrados.contains(documentoHtml1));
		assertFalse(documentosEncontrados.contains(documentoTexto1));
		assertFalse(documentosEncontrados.contains(documentoJava2));
		assertTrue(documentosEncontrados.contains(documentoTexto2));
	}
	
	@Test
	void testBuscaTipoMetadadoNulo() {
		try {
			this.documentoService.busca(null, "txt");
			fail("Não é permitido pesquisar um tipo de metadado nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaTipoMetadadoVazio() {
		try {
			this.documentoService.busca("", "txt");
			fail("Não é permitido pesquisar um tipo de metadado vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testBuscaMetadadoNulo() {
		try {
			this.documentoService.busca("TIPO", null);
			fail("Não é permitido pesquisar um metadado nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaMetadadoVazio() {
		try {
			this.documentoService.busca("TIPO", "");
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
		this.documentoService.adicionaDocumento(documentoJava1);
		this.documentoService.adicionaDocumento(documentoHtml1);
		this.documentoService.adicionaDocumento(documentoTexto1);
		this.documentoService.adicionaDocumento(documentoJava2);
		this.documentoService.adicionaDocumento(documentoTexto2);
		
		Set<Documento> documentosEncontrados = this.documentoService.busca("TIPO", "java");
		assertTrue(documentosEncontrados.contains(documentoJava1));
		assertFalse(documentosEncontrados.contains(documentoHtml1));
		assertFalse(documentosEncontrados.contains(documentoTexto1));
		assertTrue(documentosEncontrados.contains(documentoJava2));
		assertFalse(documentosEncontrados.contains(documentoTexto2));
	}
	
}