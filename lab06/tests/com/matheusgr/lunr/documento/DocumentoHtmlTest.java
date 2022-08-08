package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class DocumentoHtmlTest {

	@Test
	void testDocumentoHtmlIdNulo() {
		try {
			new DocumentoHtml(null, "Olá, tudo bem?");
			fail("Não é permitido deixar o id nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testDocumentoHtmlIdVazio() {
		try {
			new DocumentoHtml("", "Olá, tudo bem?");
			fail("Não é permitido deixar o id vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testDocumentoHtmlTextoOriginalNulo() {
		try {
			new DocumentoHtml("fsjejiw", null);
			fail("Não é permitido deixar o texto original nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testDocumentoHtmlTextoOriginalVazio() {
		try {
			new DocumentoHtml("fsjejiw", "");
			fail("Não é permitido deixar o texto original vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testDocumentoHtmlValido() {
		DocumentoHtml documentoHtml = new DocumentoHtml("fsdekweq23", "Olá, mundo!");
		assertEquals(documentoHtml.getId(), "fsdekweq23");
	}
	
	@Test
	void testMetricaTextoUtil() {
		DocumentoHtml documentoHtml = new DocumentoHtml("a23ehawei8", "Olá, tudo bem com você?");
		assertEquals(documentoHtml.metricaTextoUtil(), 0.7391304347826086);
	}
	
	@Test
	void testGetTexto() {
		DocumentoHtml documentoHtml = new DocumentoHtml("rijrj347212", "Hoje o dia está ensolarado.");
		assertEquals(Arrays.toString(documentoHtml.getTexto()), "[Hoje, dia, ensolarado, está, o]");
	}
	
	@Test
	void testGetMetadadosVerificaChaves() {
		DocumentoHtml documentoHtml = new DocumentoHtml("rijrj347212", "Hoje o dia está ensolarado.");
		assertTrue(documentoHtml.getMetadados().containsKey("LINHAS"));
		assertTrue(documentoHtml.getMetadados().containsKey("HEAD"));
		assertTrue(documentoHtml.getMetadados().containsKey("METADATADATE"));
		assertTrue(documentoHtml.getMetadados().containsKey("TIPO"));
		assertTrue(documentoHtml.getMetadados().containsKey("TAMANHO"));
		assertTrue(documentoHtml.getMetadados().containsKey("BRUTE_TAGS"));
	}
	
	@Test
	void testGetMetadadosVerificaMetadados() {
		DocumentoHtml documentoHtml = new DocumentoHtml("rijrj347212", "Hoje o dia está ensolarado.");
		long momentoCriacaoObjeto = System.currentTimeMillis();
		assertEquals(documentoHtml.getMetadados().get("LINHAS"), "0");
		assertEquals(documentoHtml.getMetadados().get("HEAD"), "");
		assertEquals(documentoHtml.getMetadados().get("METADATADATE"), "" + momentoCriacaoObjeto);
		assertEquals(documentoHtml.getMetadados().get("TIPO"), "html");
		assertEquals(documentoHtml.getMetadados().get("TAMANHO"), "26");
		assertEquals(documentoHtml.getMetadados().get("BRUTE_TAGS"), "0");
	}

	@Test
	void testHashCode() {
		DocumentoHtml documentoHtml1 = new DocumentoHtml("fsdekweq23", "Olá, mundo!");
		DocumentoHtml documentoHtml2 = new DocumentoHtml("fsdekweq23", "Hoje está chovendo.");
		assertEquals(documentoHtml1.hashCode(), documentoHtml2.hashCode());
	}
	
	@Test
	void testEqualsObjetosIdsIguais() {
		DocumentoHtml documentoHtml1 = new DocumentoHtml("wsrejiwueq", "Amanhã é o dia do evento.");
		DocumentoHtml documentoHtml2 = new DocumentoHtml("wsrejiwueq", "Eu perdi o meu celular!");
		assertTrue(documentoHtml1.equals(documentoHtml2));
	}
	
	@Test
	void testEqualsObjetosIdsDiferentes() {
		DocumentoHtml documentoHtml1 = new DocumentoHtml("wsrejiwueq", "Amanhã é o dia do evento.");
		DocumentoHtml documentoHtml2 = new DocumentoHtml("efh34772w", "Amanhã é o dia do evento.");
		assertFalse(documentoHtml1.equals(documentoHtml2));
	}
	
	@Test
	void testToString() {
		DocumentoHtml documentoHtml = new DocumentoHtml("rijrj347212", "Hoje o dia está ensolarado.");
		assertEquals(documentoHtml.toString(), "===rijrj347212" + System.lineSeparator() + System.lineSeparator() + "===Hoje o dia está ensolarado");
	}

}