package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * BuscaSimples realiza uma operação de busca a partir de termos.
 * 
 * Dado os termos, deve se buscar por tais documentos e ordená-los de acordo com
 * a quantidade de termos que são atendidos pela busca.
 * 
 * Quanto mais termos da busca estão presentes, mais relevância tem o documento.
 * 
 * Não importa a quantidade de vezes que um termo aparece no documento, apenas
 * se o documento tem ou não o termo pelo menos uma vez.
 * 
 * Os documentos que não tem nenhum dos termos pesquisados, não devem ser
 * retornados.
 */
class BuscaSimples implements Busca {

	/**
	 * Os termos a serem buscados na pesquisa.
	 */
	private String[] termos;

	/**
	 * Construtor padrão com os termos a serem encontrados.
	 * 
	 * Os termos não vazios são ignorados. Pelo menos 1 termo deve ser não vazio.
	 * 
	 * @param termos Termos a serem pesquisados.
	 */
	public BuscaSimples(String[] termos) {
		(new ValidadorBusca()).valida(termos);
		this.termos = termos;
	}

	public Map<Documento, Integer> busca(DocumentoService ds) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		for (String termo : this.termos) {
			if (termo.isBlank()) {
				continue;
			}
			for (Documento d : ds.busca(termo)) {
				respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);
			}
		}
		return respostaDocumento;
	}
	
	public String[][] descreveConsulta() {
		String[][] resultado = new String[this.termos.length][];
		for (int i = 0; i < resultado.length; i++) {
			resultado[i] = new String[] {"TERMO " + (i + 1), this.termos[i]};
		}
		return resultado;
	}
	
}