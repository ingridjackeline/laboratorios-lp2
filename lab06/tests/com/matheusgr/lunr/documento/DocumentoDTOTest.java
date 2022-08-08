package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class DocumentoDTOTest {

	@Test
	void testDocumentoDTONulo() {
		try {
			new DocumentoDTO(null);
			fail("Não é permitido deixar o documento nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testMetricaTextoUtil() {
		Documento documentoHtml = new DocumentoHtml("a23ehawei8", "Olá, tudo bem com você?");
		DocumentoDTO documento = new DocumentoDTO(documentoHtml);
		assertEquals(documento.metricaTextoUtil(), documentoHtml.metricaTextoUtil());
	}
	
	@Test
	void testGetId() {
		Documento documentoJava = new DocumentoJava("ejieruahawe23", "Hoje o dia está ensolarado.");
		DocumentoDTO documento = new DocumentoDTO(documentoJava);
		assertEquals(documento.getId(), documentoJava.getId());
	}

	@Test
	void testGetTexto() {
		Documento documentoTexto1 = new DocumentoTexto("awe236teqkq", "As roupas estão na promoção.");
		Documento documentoTexto2 = new DocumentoTexto("dednenawieu", "As roupas estão na promoção.");
		DocumentoDTO documento1 = new DocumentoDTO(documentoTexto1);
		DocumentoDTO documento2 = new DocumentoDTO(documentoTexto2);
		assertEquals(Arrays.toString(documento1.getTexto()), Arrays.toString(documento2.getTexto()));
	}
	
	@Test
	void testGetMetadados() {
		Documento documentoTexto = new DocumentoTexto("awe236teqkq", "As roupas estão na promoção.");
		DocumentoDTO documento = new DocumentoDTO(documentoTexto);
		assertEquals(documento.getMetadados(), documentoTexto.getMetadados());
	}
	
	@Test
	void testToString() {
		Documento documentoJava = new DocumentoJava("ejieruahawe23", "Hoje o dia está ensolarado.");
		DocumentoDTO documento = new DocumentoDTO(documentoJava);
		assertEquals(documento.toString(), documentoJava.toString());
	}
	
	@Test
	void testHashCode() {
		Documento documentoHtml = new DocumentoHtml("a23ehawei8", "Olá, tudo bem com você?");
		Documento documentoJava = new DocumentoJava("a23ehawei8", "Hoje o dia está ensolarado.");
		DocumentoDTO documento1 = new DocumentoDTO(documentoHtml);
		DocumentoDTO documento2 = new DocumentoDTO(documentoJava);
		assertEquals(documento1.hashCode(), documento2.hashCode());
	}
	
	@Test
	void testEqualsObjetosIdsIguais() {
		Documento documentoTexto = new DocumentoTexto("ejieruahawe23", "As roupas estão na promoção.");
		Documento documentoJava = new DocumentoJava("ejieruahawe23", "Hoje o dia está ensolarado.");
		DocumentoDTO documento1 = new DocumentoDTO(documentoTexto);
		DocumentoDTO documento2 = new DocumentoDTO(documentoJava);
		assertTrue(documento1.equals(documento2));
	}
	
	@Test
	void testEqualsObjetosIdsDiferentes() {
		Documento documentoHtml1 = new DocumentoHtml("a23ehawei8", "Olá, tudo bem com você?");
		Documento documentoHtml2 = new DocumentoHtml("sdknejqwen", "Olá, tudo bem com você?");
		DocumentoDTO documento1 = new DocumentoDTO(documentoHtml1);
		DocumentoDTO documento2 = new DocumentoDTO(documentoHtml2);
		assertFalse(documento1.equals(documento2));
	}
	
}