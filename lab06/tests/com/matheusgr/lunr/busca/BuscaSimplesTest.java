package com.matheusgr.lunr.busca;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import org.junit.jupiter.api.Test;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoHtml;
import com.matheusgr.lunr.documento.DocumentoJava;
import com.matheusgr.lunr.documento.DocumentoService;
import com.matheusgr.lunr.documento.DocumentoTexto;

class BuscaSimplesTest {

	@Test
	void testBuscaSimplesTermosNulos() {
		try {
			new BuscaSimples(null);
			fail("Não é permitido deixar os termos nulos.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testBuscaSimplesTermosVazios() {
		try {
			new BuscaSimples(new String[]{"", "", ""});
			fail("Não é permitido deixar todos os termos vazios.");
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
		BuscaSimples buscaSimples = new BuscaSimples(new String[]{"hoje", "dia", "está"});
		Map<Documento, Integer> resultado = buscaSimples.busca(documentoService);
		assertEquals(resultado.get(documentoJava1), 2);
		assertEquals(resultado.get(documentoHtml1), 3);
		assertEquals(resultado.get(documentoTexto1), 1);
		assertEquals(resultado.get(documentoJava2), 2);
		assertEquals(resultado.get(documentoTexto2), 3);
	}

	@Test
	void testDescreveConsulta() {
		BuscaSimples buscaSimples = new BuscaSimples(new String[]{"hoje", "dia", "está"});
		String descricaoConsulta = "";
		for (int l = 0; l < buscaSimples.descreveConsulta().length; l++) {     
			 for (int c = 0; c <  buscaSimples.descreveConsulta()[0].length; c++) {   
			     descricaoConsulta += buscaSimples.descreveConsulta()[l][c];
			 }     
			 descricaoConsulta += "\n";
		}	
		assertEquals(descricaoConsulta, "TERMO 1hoje\nTERMO 2dia\nTERMO 3está\n");
	}
	
}