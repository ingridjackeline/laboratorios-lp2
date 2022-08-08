package com.matheusgr.lunr.busca;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.matheusgr.lunr.documento.DocumentoDTO;
import com.matheusgr.lunr.documento.DocumentoHtml;
import com.matheusgr.lunr.documento.DocumentoJava;
import com.matheusgr.lunr.documento.DocumentoService;
import com.matheusgr.lunr.documento.DocumentoTexto;

class BuscaRepositoryTest {

	private BuscaRepository buscaRepository;
	
	@BeforeEach
	void setUp() {
		this.buscaRepository = new BuscaRepository();
	}

	@Test
	void testAdicionaBuscaSimples() {
		DocumentoService documentoService = new DocumentoService();
		documentoService.adicionaDocumento(new DocumentoJava("o213hig", "Olá, está tudo bem hoje?"));
		documentoService.adicionaDocumento(new DocumentoHtml("S23ID9", "O dia está ensolarado hoje."));
		documentoService.adicionaDocumento(new DocumentoTexto("23uhse829df", "Amanhã é o dia do meu aniversário!"));
		documentoService.adicionaDocumento(new DocumentoJava("238472fe8", "A classe está completa hoje."));
		documentoService.adicionaDocumento(new DocumentoTexto("addwhe21", "O dia está muito chuvoso hoje."));
		documentoService.adicionaDocumento(new DocumentoHtml("2wie2uqo", "O horário da consulta está marcado pra amanhã."));
		BuscaService buscaService = new BuscaService(documentoService);
		BuscaSimples buscaSimples = new BuscaSimples(new String[]{"hoje", "dia", "está"});
		DocumentoDTO[] documentosEncontrados = buscaService.busca(buscaSimples);
		this.buscaRepository.adicionaBusca(buscaSimples, documentosEncontrados);
		HistoricoBusca historico = this.buscaRepository.recuperar(0);
		assertEquals(Arrays.toString(historico.ids()), "[S23ID9, addwhe21, o213hig, 238472fe8, 2wie2uqo]");
	}
	
	@Test
	void testAdicionaBuscaAvancada() {
		DocumentoService documentoService = new DocumentoService();
		documentoService.adicionaDocumento(new DocumentoJava("o213hig", "Olá, está tudo bem hoje?"));
		documentoService.adicionaDocumento(new DocumentoHtml("S23ID9", "O dia está ensolarado hoje."));
		documentoService.adicionaDocumento(new DocumentoTexto("23uhse829df", "Amanhã é o dia do meu aniversário!"));
		documentoService.adicionaDocumento(new DocumentoJava("238472fe8", "A classe está completa hoje."));
		documentoService.adicionaDocumento(new DocumentoTexto("addwhe21", "O dia está muito chuvoso hoje."));
		documentoService.adicionaDocumento(new DocumentoHtml("2wie2uqo", "O horário da consulta está marcado pra amanhã."));
		BuscaService buscaService = new BuscaService(documentoService);
		Map<String, String> metadados = new HashMap<>();
		metadados.put("TIPO", "java");
		metadados.put("LINHAS", "0");
		BuscaAvancada buscaAvancada = new BuscaAvancada(metadados);
		DocumentoDTO[] documentosEncontrados = buscaService.busca(buscaAvancada);
		this.buscaRepository.adicionaBusca(buscaAvancada, documentosEncontrados);
		HistoricoBusca historico = this.buscaRepository.recuperar(0);
		assertEquals(Arrays.toString(historico.ids()), "[o213hig, 238472fe8]");
	}

	@Test
	void testRecuperarPosicaoAbaixoLimiteInferior() {
		try {
			this.buscaRepository.recuperar(-1);
			fail("Não é permitido fazer uma busca a partir de uma posição negativa.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testRecuperaHistoricoPosicaoAcimaLimiteSuperior() {
		DocumentoService documentoService = new DocumentoService();
		documentoService.adicionaDocumento(new DocumentoJava("o213hig", "Olá, está tudo bem hoje?"));
		documentoService.adicionaDocumento(new DocumentoHtml("S23ID9", "O dia está ensolarado hoje."));
		BuscaService buscaService = new BuscaService(documentoService);
		BuscaSimples buscaSimples = new BuscaSimples(new String[]{"hoje", "dia", "está"});
		DocumentoDTO[] documentosEncontrados = buscaService.busca(buscaSimples);
		this.buscaRepository.adicionaBusca(buscaSimples, documentosEncontrados);
		try {
			this.buscaRepository.recuperar(4);
			fail("Não é permitido fazer uma busca a partir de uma posição inexistente no histórico.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testRecuperaHistoricoPosicaoValida() {
		DocumentoService documentoService = new DocumentoService();
		documentoService.adicionaDocumento(new DocumentoJava("o213hig", "Olá, está tudo bem hoje?"));
		documentoService.adicionaDocumento(new DocumentoHtml("S23ID9", "O dia está ensolarado hoje."));
		documentoService.adicionaDocumento(new DocumentoTexto("23uhse829df", "Amanhã é o dia do meu aniversário!"));
		documentoService.adicionaDocumento(new DocumentoJava("238472fe8", "A classe está completa hoje."));
		documentoService.adicionaDocumento(new DocumentoTexto("addwhe21", "O dia está muito chuvoso hoje."));
		documentoService.adicionaDocumento(new DocumentoHtml("2wie2uqo", "O horário da consulta está marcado pra amanhã."));
		BuscaService buscaService = new BuscaService(documentoService);
		Map<String, String> metadados = new HashMap<>();
		metadados.put("TIPO", "html");
		metadados.put("LINHAS", "0");
		BuscaAvancada buscaAvancada = new BuscaAvancada(metadados);
		DocumentoDTO[] documentosEncontrados = buscaService.busca(buscaAvancada);
		this.buscaRepository.adicionaBusca(buscaAvancada, documentosEncontrados);
		HistoricoBusca historico = this.buscaRepository.recuperar(0);
		assertEquals(Arrays.toString(historico.ids()), "[S23ID9, 2wie2uqo]");
	}

}