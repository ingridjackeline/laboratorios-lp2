package com.matheusgr.lunr.documento;

import java.util.HashMap;
import java.util.Map;
import biblitex.TransformaTexto;

/**
 * Documento base java. As palavras-chave da linguagem ainda são preservadas
 * (como public, private, etc), mas elimina-se documentação e comentários.
 */
public class DocumentoJava extends DocumentoAbstract implements Documento {

	/**
	 * Cria o DocumentoJava, extraindo o texot base.
	 * 
	 * @param id       ID do documento a ser criado.
	 * @param original Código java original.
	 */
	public DocumentoJava(String id, String original) {
		super(id, original);
		var transformaTexto = new TransformaTexto();
		var txt = transformaTexto.transforma(TransformaTexto.Algoritmos.java, original);
		super.limpo = transformaTexto.transforma(TransformaTexto.Algoritmos.clean, txt).strip();
	}

	@Override
	public Map<String, String> getMetadados() {
		if (super.metadados != null) {
			return super.metadados;
		}
		super.metadados = extractData(super.original);
		super.metadados.put("LINHAS", "" + super.original.chars().filter((value) -> '\n' == value).count());
		super.metadados.put("TAMANHO", "" + super.limpo.length());
		super.metadados.put("METADATADATE", "" + System.currentTimeMillis());
		super.metadados.put("TIPO", "" + "java");
		return super.metadados;
	}

	/*
	 * Metadados particulares de java: número de imports e autor da classe.
	 */
	private Map<String, String> extractData(String original2) {
		Map<String, String> metadados2 = new HashMap<>();
		metadados2.put("IMPORTS", "" + ((super.limpo.length() - super.limpo.replaceAll("import ", "").length()) / 7));
		metadados2.put("AUTHOR", "" + (super.original.indexOf("@author") != -1 ? "TRUE" : ""));
		return metadados2;
	}

}