package com.matheusgr.similaridade;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Componente para tratamento da lógica de negócio relativa a similaridade.
 */
public class SimilaridadeService {

	/**
	 * O serviço de documentos.
	 */
	private DocumentoService documentoService;

	/**
	 * Inicialização da lógica de serviço.
	 * 
	 * @param documentoService DocumentoService a ser utilizado pelo
	 *                         SimilaridadeService.
	 */
	public SimilaridadeService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	/**
	 * Calcula e retorna a similaridade.
	 * 
	 * Para o cálculo da similaridade:
	 * <ul>
	 * <li>Pega o documento 1</li>
	 * <li>Pega o documento 2</li>
	 * <li>Pega os termos do documento 1 e coloca em um conjunto (Termos1)</li>
	 * <li>Pega os termos do documento 2 e coloca em um conjunto (Termos2)</li>
	 * <li>Calcula a interseção entre Termos1 e Termos2 (Inters)</li>
	 * <li>Calcula a união entre Termos1 e Termos2 (Uniao)</li>
	 * <li>A similaridade é o tamanho de Inters sobre o tamanho do conjunto
	 * Uniao</li>
	 * </ul>
	 * 
	 * @param docId1 Documento 1.
	 * @param docId2 Documento 2.
	 * @return Valor de similaridade (entre 0 e 1, inclusives) representando a
	 *         semelhança entre os documentos.
	 */
	public double similaridade(String docId1, String docId2) {
		if (docId1 == null || docId2 == null) {
			throw new NullPointerException("O id do documento não pode ser nulo.");
		} else if (docId1.isBlank() || docId2.isBlank()) {
			throw new IllegalArgumentException("O id do documento não pode ser vazio.");
		}
		
		Documento documento1 = this.documentoService.recuperaDocumento(docId1).get();
		Documento documento2 = this.documentoService.recuperaDocumento(docId2).get();
		Set<String> termos1 = new HashSet<>(Arrays.asList(documento1.getTexto()));
		Set<String> termos2 = new HashSet<>(Arrays.asList(documento2.getTexto()));
		Set<String> inters = new HashSet<>();
		for (String termo : termos1) {
			if (termos2.contains(termo)) {
				inters.add(termo);
			}
		}
		Set<String> uniao = new HashSet<>(termos1);
		for (String termo : termos2) {
			if (!uniao.contains(termo)) {
				uniao.add(termo);
			}
		}
		
		double valorInterseccao = inters.size();
		double valorUniao = uniao.size();
		double similaridade = valorInterseccao / valorUniao;
		
		return similaridade;
	}

}