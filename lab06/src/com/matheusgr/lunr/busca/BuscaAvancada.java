package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * BuscaAvancada realiza uma operação de busca a partir de metadados.
 * 
 * Os documentos a serem retornados devem conter todos os metadados apresentados 
 * na operação de busca.
 */
class BuscaAvancada implements Busca {

	/**
	 * Os metadados a serem buscados na pesquisa.
	 */
	private Map<String, String> metadados;
	
	/**
	 * Construtor padrão com os metadados a serem encontrados.
	 * 
	 * @param metadados Metadados a serem pesquisados.
	 */
	public BuscaAvancada(Map<String, String> metadados) {
		(new ValidadorBusca()).valida(metadados);
		this.metadados = metadados;
	}
	
	public Map<Documento, Integer> busca(DocumentoService ds) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		for (String tipoMetadado : this.metadados.keySet()) {
			String metadado = this.metadados.get(tipoMetadado);
			for(Documento d : ds.busca(tipoMetadado, metadado)) {
				respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);
			}
		}
		
		Map<Documento, Integer> respostaBusca = new HashMap<>();
		for (Documento d : respostaDocumento.keySet()) {
			int metadadosIguais = respostaDocumento.get(d);
			if (metadadosIguais == this.metadados.size()) {
				respostaBusca.put(d, metadadosIguais);
			}
		}
		
		return respostaBusca;
	}
	
	public String[][] descreveConsulta() {
		String[][] resultado = new String[this.metadados.size()][];
		int i = 0;
		for (String tipoMetadado : this.metadados.keySet()) {
			String metadado = this.metadados.get(tipoMetadado);
			resultado[i] = new String[] {"METADADO " + (i + 1), tipoMetadado + ": " + metadado};
			i += 1;
		}
		return resultado;
	}
	
}