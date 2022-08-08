package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import biblitex.TransformaTexto;

/**
 * Superclasse abstrata que contém a estrutura de código comum a todos os tipos de documento 
 * existentes no sistema. 
 */
public abstract class DocumentoAbstract implements Documento {
	
	/**
	 * O id do documento.
	 */
	protected String id;
	
	/**
	 * O texto original contido no documento.
	 */
	protected String original;
	
	/**
	 * O texto original após sofrer transformações específicas do documento.
	 */
	protected String limpo;
	
	/**
	 * Os metadados que caracterizam o documento.
	 */
	protected Map<String, String> metadados;
	
	/**
	 * Os termos presentes no documento.
	 */
	protected String[] split;
	
	/**
	 * Construtor padrão que cria o documento a partir do seu id e do texto original a ser 
	 * armazenado.
	 * 
	 * @param id O id do documento.
	 * @param original O texto original a ser armazenado.
	 */
	public DocumentoAbstract(String id, String original) {
		if (id == null) {
			throw new NullPointerException("O id do documento não pode ser nulo.");
		} else if (id.isBlank()) {
			throw new IllegalArgumentException("O id do documento não pode ser vazio.");
		}
		if (original == null) {
			throw new NullPointerException("O texto original do documento não pode ser nulo.");
		} else if (original.isBlank()) {
			throw new IllegalArgumentException("O texto original do documento não pode ser vazio.");
		}
		
		this.id = id;
		this.original = original;
	}

	@Override
	public double metricaTextoUtil() {
		long extractedSize = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanSpaces, this.limpo).length();
		return (1.0 * extractedSize) / this.original.length();
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String[] getTexto() {
		if (this.split == null) {
			this.split = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanLines, this.limpo).split(" ");
			Arrays.sort(this.split);
		}
		return this.split;
	}
	
	@Override
	public abstract Map<String, String> getMetadados();

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentoAbstract other = (DocumentoAbstract) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "===" + this.id + System.lineSeparator() + this.limpo;
	}
	
}