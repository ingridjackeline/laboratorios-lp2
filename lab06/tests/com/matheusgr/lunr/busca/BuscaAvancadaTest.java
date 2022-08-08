package com.matheusgr.lunr.busca;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoHtml;
import com.matheusgr.lunr.documento.DocumentoJava;
import com.matheusgr.lunr.documento.DocumentoService;
import com.matheusgr.lunr.documento.DocumentoTexto;

class BuscaAvancadaTest {

	@Test
	void testBuscaSimplesTermosNulos() {
		try {
			new BuscaAvancada(null);
			fail("Não é permitido deixar os metadados nulos.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaSimplesTermosVazios() {
		Map<String, String> metadados = new HashMap<>();
		metadados.put("", "");
		try {
			new BuscaAvancada(metadados);
			fail("Não é permitido deixar todos os metadados vazios.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testBusca() {
		DocumentoService documentoService = new DocumentoService();
		Documento documentoJava1 = new DocumentoJava("o213hig", "Olá, está tudo bem hoje?");
		Documento documentoHtml1 = new DocumentoHtml("S23ID9", "O dia está ensolarado hoje.");
		Documento documentoTexto1 = new DocumentoTexto("23uhse829df", "Amanhã é o dia do meu aniversário!");
		Documento documentoJava2 = new DocumentoJava("238472fe8", "A classe está completa hoje.");
		Documento documentoTexto2 = new DocumentoTexto("addwhe21", "O dia está muito chuvoso hoje.");
		documentoService.adicionaDocumento(documentoJava1);
		documentoService.adicionaDocumento(documentoHtml1);
		documentoService.adicionaDocumento(documentoTexto1);
		documentoService.adicionaDocumento(documentoJava2);
		documentoService.adicionaDocumento(documentoTexto2);
		Map<String, String> metadados = new HashMap<>();
		metadados.put("TIPO", "java");
		metadados.put("LINHAS", "0");
		BuscaAvancada buscaAvancada = new BuscaAvancada(metadados);
		Map<Documento, Integer> resultado = buscaAvancada.busca(documentoService);
		assertEquals(resultado.get(documentoJava1), 2);
		assertEquals(resultado.get(documentoJava2), 2);
	}

	@Test
	void testDescreveConsulta() {
		Map<String, String> metadados = new HashMap<>();
		metadados.put("TIPO", "java");
		metadados.put("LINHAS", "0");
		BuscaAvancada buscaAvancada = new BuscaAvancada(metadados);
		String descricaoConsulta = "";
		for (int l = 0; l < buscaAvancada.descreveConsulta().length; l++) {     
			 for (int c = 0; c <  buscaAvancada.descreveConsulta()[0].length; c++) {   
			     descricaoConsulta += buscaAvancada.descreveConsulta()[l][c];
			 }     
			 descricaoConsulta += "\n";
		}	
		assertEquals(descricaoConsulta, "METADADO 1LINHAS: 0\nMETADADO 2TIPO: java\n");
	}

}