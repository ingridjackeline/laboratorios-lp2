package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Repositório de documentos. O repositório pode ter opreações simples de busca,
 * mas a lógica de ranking, limitação e ordenação deve ficar em outra entidade.
 * 
 * O ID de um documento é único.
 */
class DocumentoRepository {

	/**
	 * Os documentos armazenados no sistema.
	 */
	private Map<String, Documento> documentos;
	
	/**
	 * O validador de documentos.
	 */
	private ValidadorDocumentos validador;

	/**
	 * Construção padrão do repositório de documentos.
	 */
	DocumentoRepository() {
		this.documentos = new HashMap<String, Documento>();
		this.validador = new ValidadorDocumentos();
	}

	/**
	 * Adiciona o documento. O documento é validado para garantir a consistência do
	 * documento (sem termos e id vazios).
	 * 
	 * @param d Documento a ser adicionado.
	 */
	void adiciona(Documento d) {
		if (d == null) {
			throw new NullPointerException("O documento não pode ser nulo.");
		}
		
		this.validador.validacao(d.getId(), d.getTexto());
		this.documentos.put(d.getId(), d);
	}

	/**
	 * Recupera um documento do repositório.
	 * 
	 * @param id ID do documento.
	 * @return Documento, caso exista.
	 */
	Optional<Documento> recupera(String id) {
		this.validador.validacao(id);
		return Optional.ofNullable(this.documentos.get(id));
	}

	/**
	 * Retorna o total de documentos cadastrados.
	 * 
	 * @return O total de documentos cadastrados.
	 */
	int totalDocumentos() {
		return this.documentos.size();
	}

	/**
	 * Realiza uma busca pelos termos.
	 * 
	 * @param termo Termo a ser buscado.
	 * @return Conjunto de documentos com o termo.
	 */
	public Set<Documento> busca(String termo) {
		if (termo == null) {
			throw new NullPointerException("O termo a ser pesquisado não pode ser nulo.");
		} else if (termo.isBlank()) {
			throw new IllegalArgumentException("O termo a ser pesquisado não pode ser vazio.");
		}
		
		return this.documentos.values().stream()
					.filter((x) -> Arrays.binarySearch(x.getTexto(), termo) > 0)
					.collect(Collectors.toSet());
	}
	
	/**
	 * Realiza uma busca pelos metadados.
	 * 
	 * @param tipoMetadado O tipo de metadado a ser pesquisado.
	 * @param metadado O metadado a ser pesquisado.
	 * @return O conjunto dos documentos que apresentam o tipo de metadado e o respectivo 
	 * metadado buscados.
	 */
	public Set<Documento> busca(String tipoMetadado, String metadado) {
		if (tipoMetadado == null || metadado == null) {
			throw new NullPointerException("O metadado ou o tipo de metadado a ser pesquisado não pode ser nulo.");
		} else if (tipoMetadado.isBlank() || metadado.isBlank()) {
			throw new IllegalArgumentException("O metadado ou o tipo de metadado a ser pesquisado não pode ser vazio.");
		}
		
		Set<Documento> documentosBuscados = new HashSet<>();
		for(Documento d : this.documentos.values()) {
			Map<String, String> metadadosDocumento = d.getMetadados();
			if (metadadosDocumento.containsKey(tipoMetadado)) {
				String metadadoD = metadadosDocumento.get(tipoMetadado);
				if (metadadoD.equals(metadado)) {
					documentosBuscados.add(d);
				}
			}
		}
		return documentosBuscados;
	}

}