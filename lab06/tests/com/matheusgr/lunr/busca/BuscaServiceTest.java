package com.matheusgr.lunr.busca;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.matheusgr.lunr.documento.DocumentoDTO;
import com.matheusgr.lunr.documento.DocumentoHtml;
import com.matheusgr.lunr.documento.DocumentoJava;
import com.matheusgr.lunr.documento.DocumentoService;
import com.matheusgr.lunr.documento.DocumentoTexto;

class BuscaServiceTest {

	private BuscaService buscaService;
	
	@BeforeEach
	void setUp() {
		DocumentoService documentoService = new DocumentoService();
		documentoService.adicionaDocumento(new DocumentoJava("o213hig", "Olá, está tudo bem hoje?"));
		documentoService.adicionaDocumento(new DocumentoHtml("S23ID9", "O dia está ensolarado hoje."));
		documentoService.adicionaDocumento(new DocumentoTexto("23uhse829df", "Amanhã é o dia do meu aniversário!"));
		documentoService.adicionaDocumento(new DocumentoJava("238472fe8", "A classe está completa hoje."));
		documentoService.adicionaDocumento(new DocumentoTexto("addwhe21", "O dia está muito chuvoso hoje."));
		documentoService.adicionaDocumento(new DocumentoHtml("2wie2uqo", "O horário da consulta está marcado pra amanhã."));
		
		this.buscaService = new BuscaService(documentoService);
	}
	
	@Test
	void testBuscaServiceDocumentoServiceNulo() {
		try {
			new BuscaService(null);
			fail("Não é permitido deixar o documento service nulo.");
		} catch (NullPointerException npe) {
			
		}
	}

	@Test
	void testBuscaSimples() {
		BuscaSimples buscaSimples = new BuscaSimples(new String[]{"hoje", "dia", "está"});
		DocumentoDTO[] documentosEncontrados = this.buscaService.busca(buscaSimples);
		List<String> idsDocumentos = new ArrayList<>();
		for (DocumentoDTO doc : documentosEncontrados) {
			idsDocumentos.add(doc.getId());
		}
		assertEquals(Arrays.toString(idsDocumentos.toArray()), "[S23ID9, addwhe21, o213hig, 238472fe8, 2wie2uqo]");
	}

	@Test
	void testBuscaBuscaAvancada() {
		Map<String, String> metadados = new HashMap<>();
		metadados.put("TIPO", "java");
		metadados.put("LINHAS", "0");
		BuscaAvancada buscaAvancada = new BuscaAvancada(metadados);
		DocumentoDTO[] documentosEncontrados = this.buscaService.busca(buscaAvancada);
		List<String> idsDocumentos = new ArrayList<>();
		for (DocumentoDTO doc : documentosEncontrados) {
			idsDocumentos.add(doc.getId());
		}
		assertEquals(Arrays.toString(idsDocumentos.toArray()), "[o213hig, 238472fe8]");
	}

	@Test
	void testRecuperaHistoricoPosicaoAbaixoLimiteInferior() {
		try {
			this.buscaService.recuperaHistorico(-1);
			fail("Não é permitido fazer uma busca a partir de uma posição negativa.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testRecuperaHistoricoPosicaoAcimaLimiteSuperior() {
		BuscaSimples buscaSimples1 = new BuscaSimples(new String[]{"hoje", "dia", "está"});
		this.buscaService.busca(buscaSimples1);
		BuscaSimples buscaSimples2 = new BuscaSimples(new String[]{"está", "hoje"});
		this.buscaService.busca(buscaSimples2);
		try {
			this.buscaService.recuperaHistorico(3);
			fail("Não é permitido fazer uma busca a partir de uma posição inexistente no histórico.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testRecuperaHistoricoPosicaoValida() {
		BuscaSimples buscaSimples1 = new BuscaSimples(new String[]{"hoje", "dia", "está"});
		this.buscaService.busca(buscaSimples1);
		BuscaSimples buscaSimples2 = new BuscaSimples(new String[]{"está"});
		this.buscaService.busca(buscaSimples2);
		HistoricoBusca historico = this.buscaService.recuperaHistorico(0);
		assertEquals(Arrays.toString(historico.ids()), "[S23ID9, addwhe21, o213hig, 238472fe8, 2wie2uqo]");
	}

}