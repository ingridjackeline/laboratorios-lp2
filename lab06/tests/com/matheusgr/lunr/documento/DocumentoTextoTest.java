package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class DocumentoTextoTest {

	@Test
	void testDocumentoTextoIdNulo() {
		try {
			new DocumentoTexto(null, "A loja está com novos produtos.");
			fail("Não é permitido deixar o id nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testDocumentoTextoIdVazio() {
		try {
			new DocumentoTexto("", "A loja está com novos produtos.");
			fail("Não é permitido deixar o id vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testDocumentoTextoTextoOriginalNulo() {
		try {
			new DocumentoTexto("sdewkaofk", null);
			fail("Não é permitido deixar o texto original nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testDocumentoTextoTextoOriginalVazio() {
		try {
			new DocumentoTexto("sdewkaofk", "");
			fail("Não é permitido deixar o texto original vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testDocumentoTextoValido() {
		DocumentoTexto documentoTexto = new DocumentoTexto("fsdekweq23", "A loja está com novos produtos.");
		assertEquals(documentoTexto.getId(), "fsdekweq23");
	}
	
	@Test
	void testMetricaTextoUtil() {
		DocumentoTexto documentoTexto = new DocumentoTexto("a23ehawei8", "As blusas da loja são estampadas.");
		assertEquals(documentoTexto.metricaTextoUtil(), 0.8181818181818182);
	}
	
	@Test
	void testGetTexto() {
		DocumentoTexto documentoTexto = new DocumentoTexto("rijrj347212", "As blusas da loja são estampadas.");
		assertEquals(Arrays.toString(documentoTexto.getTexto()), "[As, blusas, da, estampadas, loja, são]");
	}
	
	@Test
	void testGetMetadadosVerificaChaves() {
		DocumentoTexto documentoTexto = new DocumentoTexto("rijrj347212", "Hoje o dia está ensolarado.");
		assertTrue(documentoTexto.getMetadados().containsKey("LINHAS"));
		assertTrue(documentoTexto.getMetadados().containsKey("METADATADATE"));
		assertTrue(documentoTexto.getMetadados().containsKey("TIPO"));
		assertTrue(documentoTexto.getMetadados().containsKey("TAMANHO"));
	}
	
	@Test
	void testGetMetadadosVerificaMetadados() {
		DocumentoTexto documentoTexto = new DocumentoTexto("rijrj347212", "Hoje o dia está ensolarado.");
		long momentoCriacaoObjeto = System.currentTimeMillis();
		assertEquals(documentoTexto.getMetadados().get("LINHAS"), "0");
		assertEquals(documentoTexto.getMetadados().get("METADATADATE"), "" + momentoCriacaoObjeto);
		assertEquals(documentoTexto.getMetadados().get("TIPO"), "txt");
		assertEquals(documentoTexto.getMetadados().get("TAMANHO"), "26");
	}

	@Test
	void testHashCode() {
		DocumentoTexto documentoTexto1 = new DocumentoTexto("fsdekweq23", "Olá, mundo!");
		DocumentoTexto documentoTexto2 = new DocumentoTexto("fsdekweq23", "Hoje está chovendo.");
		assertEquals(documentoTexto1.hashCode(), documentoTexto2.hashCode());
	}
	
	@Test
	void testEqualsObjetosIdsIguais() {
		DocumentoTexto documentoTexto1 = new DocumentoTexto("wsrejiwueq", "Amanhã é o dia do evento.");
		DocumentoTexto documentoTexto2 = new DocumentoTexto("wsrejiwueq", "Eu perdi o meu celular!");
		assertTrue(documentoTexto1.equals(documentoTexto2));
	}
	
	@Test
	void testEqualsObjetosIdsDiferentes() {
		DocumentoTexto documentoTexto1 = new DocumentoTexto("wsrejiwueq", "Amanhã é o dia do evento.");
		DocumentoTexto documentoTexto2 = new DocumentoTexto("efh34772w", "Amanhã é o dia do evento.");
		assertFalse(documentoTexto1.equals(documentoTexto2));
	}
	
	@Test
	void testToString() {
		DocumentoTexto documentoTexto = new DocumentoTexto("rijrj347212", "Hoje o dia está ensolarado.");
		assertEquals(documentoTexto.toString(), "===rijrj347212" + System.lineSeparator() + "Hoje o dia está ensolarado");
	}
	
}