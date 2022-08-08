package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class DocumentoJavaTest {

	@Test
	void testDocumentoJavaIdNulo() {
		try {
			new DocumentoJava(null, "O vestido está na promoção.");
			fail("Não é permitido deixar o id nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testDocumentoJavaIdVazio() {
		try {
			new DocumentoJava("", "O vestido está na promoção.");
			fail("Não é permitido deixar o id vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testDocumentoJavaTextoOriginalNulo() {
		try {
			new DocumentoJava("fsjejiw", null);
			fail("Não é permitido deixar o texto original nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testDocumentoJavaTextoOriginalVazio() {
		try {
			new DocumentoJava("fsjejiw", "");
			fail("Não é permitido deixar o texto original vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testDocumentoJavaValido() {
		DocumentoJava documentoJava = new DocumentoJava("fsdekweq23", "O vestido está na promoção.");
		assertEquals(documentoJava.getId(), "fsdekweq23");
	}
	
	@Test
	void testMetricaTextoUtil() {
		DocumentoJava documentoJava = new DocumentoJava("a23ehawei8", "Olá, tudo bem com você?");
		assertEquals(documentoJava.metricaTextoUtil(), 0.7391304347826086);
	}
	
	@Test
	void testGetTexto() {
		DocumentoJava documentoJava = new DocumentoJava("rijrj347212", "Hoje está um dia chuvoso.");
		assertEquals(Arrays.toString(documentoJava.getTexto()), "[Hoje, chuvoso, dia, está, um]");
	}
	
	@Test
	void testGetMetadadosVerificaChaves() {
		DocumentoJava documentoJava = new DocumentoJava("rijrj347212", "Hoje está um dia chuvoso.");
		assertTrue(documentoJava.getMetadados().containsKey("LINHAS"));
		assertTrue(documentoJava.getMetadados().containsKey("METADATADATE"));
		assertTrue(documentoJava.getMetadados().containsKey("TIPO"));
		assertTrue(documentoJava.getMetadados().containsKey("TAMANHO"));
		assertTrue(documentoJava.getMetadados().containsKey("AUTHOR"));
		assertTrue(documentoJava.getMetadados().containsKey("IMPORTS"));
	}
	
	@Test
	void testGetMetadadosVerificaMetadados() {
		DocumentoJava documentoJava = new DocumentoJava("rijrj347212", "Hoje está um dia chuvoso.");
		long momentoCriacaoObjeto = System.currentTimeMillis();
		assertEquals(documentoJava.getMetadados().get("LINHAS"), "0");
		assertEquals(documentoJava.getMetadados().get("IMPORTS"), "0");
		assertEquals(documentoJava.getMetadados().get("METADATADATE"), "" + momentoCriacaoObjeto);
		assertEquals(documentoJava.getMetadados().get("TIPO"), "java");
		assertEquals(documentoJava.getMetadados().get("TAMANHO"), "24");
		assertEquals(documentoJava.getMetadados().get("AUTHOR"), "");
	}

	@Test
	void testHashCode() {
		DocumentoJava documentoJava1 = new DocumentoJava("eeirjsweu", "Olá, mundo!");
		DocumentoJava documentoJava2 = new DocumentoJava("eeirjsweu", "Hoje está chovendo.");
		assertEquals(documentoJava1.hashCode(), documentoJava2.hashCode());
	}
	
	@Test
	void testEqualsObjetosIdsIguais() {
		DocumentoJava documentoJava1 = new DocumentoJava("wsrejiwueq", "Amanhã é o dia do evento.");
		DocumentoJava documentoJava2 = new DocumentoJava("wsrejiwueq", "Eu perdi o meu celular!");
		assertTrue(documentoJava1.equals(documentoJava2));
	}
	
	@Test
	void testEqualsObjetosIdsDiferentes() {
		DocumentoJava documentoJava1 = new DocumentoJava("wsrejiwueq", "Amanhã é o dia do evento.");
		DocumentoJava documentoJava2 = new DocumentoJava("efh34772w", "Amanhã é o dia do evento.");
		assertFalse(documentoJava1.equals(documentoJava2));
	}
	
	@Test
	void testToString() {
		DocumentoJava documentoJava = new DocumentoJava("sfeoeijaow242", "Hoje está um dia chuvoso!");
		assertEquals(documentoJava.toString(), "===sfeoeijaow242" + System.lineSeparator() + "Hoje está um dia chuvoso");
	}

}