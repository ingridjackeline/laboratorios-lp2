package com.matheusgr.similaridade;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.matheusgr.lunr.documento.DocumentoHtml;
import com.matheusgr.lunr.documento.DocumentoJava;
import com.matheusgr.lunr.documento.DocumentoService;
import com.matheusgr.lunr.documento.DocumentoTexto;

class SimilaridadeServiceTest {

	private SimilaridadeService similaridadeService;
	private DocumentoService documentoService;
	
	@BeforeEach
	void setUp() {
		this.documentoService = new DocumentoService();
		this.similaridadeService = new SimilaridadeService(documentoService);
	}

	@Test
	void testSimilaridadeIdsNulos() {
		try {
			this.similaridadeService.similaridade(null, null);
			fail("Não é permitido deixar o id do documento nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testSimilaridadeIdsVazios() {
		try {
			this.similaridadeService.similaridade("", "");
			fail("Não é permitido deixar o id do documento vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testSimilaridadeSemTermosEmComum() {
		this.documentoService.adicionaDocumento(new DocumentoJava("37uew38", "Olá, tudo bem com você?"));
		this.documentoService.adicionaDocumento(new DocumentoHtml("7eweiw7q73", "Hoje está um dia ensolarado."));
		assertEquals(this.similaridadeService.similaridade("37uew38", "7eweiw7q73"), 0.0);
	}
	
	@Test
	void testSimilaridadeComAlgunsTermosEmComum() {
		this.documentoService.adicionaDocumento(new DocumentoHtml("37uew38", "Uma casa feliz é uma casa bonita."));
		this.documentoService.adicionaDocumento(new DocumentoTexto("7eweiw7q73", "Um dia feliz é um bom dia."));
		assertEquals(this.similaridadeService.similaridade("37uew38", "7eweiw7q73"), 0.2);
	}
	
	@Test
	void testSimilaridadeComTodosOsTermosEmComum() {
		this.documentoService.adicionaDocumento(new DocumentoJava("37uew38", "Uma casa feliz é uma casa bonita."));
		this.documentoService.adicionaDocumento(new DocumentoTexto("7eweiw7q73", "Uma casa feliz é uma casa bonita."));
		assertEquals(this.similaridadeService.similaridade("37uew38", "7eweiw7q73"), 1.0);
	}

}