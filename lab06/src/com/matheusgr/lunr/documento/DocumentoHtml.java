package com.matheusgr.lunr.documento;

import java.util.HashMap;
import java.util.Map;
import biblitex.TransformaTexto;

/**
 * DocumentoHTML representa e extrai dados de um HTML.
 * 
 * Os termos extraídos são obtidos dos textos dos nós do HTML. São ignorados
 * nome de tags ou de propriedades. Por não ser um texto bem formulado, limpa-se
 * da melhor forma possível o HTML.
 * 
 * Os metadados são obtidos de características do documento, mas de detalhes
 * descritos na tag HEAD.
 */
public class DocumentoHtml extends DocumentoAbstract implements Documento {

	/**
	 * O head metadado do documento html.
	 */
	private static final String HEAD_METADADO = "HEAD";

	/**
	 * Construtor padrão. Realiza o processamento de extração do HTML.
	 * 
	 * @param id ID do documento a ser criado.
	 * @param original HTML do documento a ser criado.
	 */
	public DocumentoHtml(String id, String original) {
		super(id, original);
		var transformaTexto = new TransformaTexto();
		var txt = transformaTexto.transforma(TransformaTexto.Algoritmos.html, original);
		super.limpo = transformaTexto.transforma(TransformaTexto.Algoritmos.clean, txt).strip();
	}

	@Override
	public Map<String, String> getMetadados() {
		if (super.metadados != null) {
			return super.metadados;
		}
		super.metadados = extractHead(super.original);
		super.metadados.put("LINHAS", "" + super.original.chars().filter((value) -> '\n' == value).count());
		super.metadados.put("TAMANHO", "" + super.limpo.length());
		super.metadados.put("METADATADATE", "" + System.currentTimeMillis());
		super.metadados.put("TIPO", "" + "html");
		return super.metadados;
	}

	/*
	 * Os metadados do HTML incluem, especificamente:
	 * - Quantidade de tags, estimada a partir da quantidade de símbolos <
	 * - Todo o corpo da tag <head>
	 */
	private Map<String, String> extractHead(String original2) {
		Map<String, String> metadados2 = new HashMap<>();
		metadados2.put("BRUTE_TAGS", "" + super.original.chars().filter((value) -> '<' == value).count());
		String meta = "";
		int headStart = original2.toLowerCase().indexOf("<head>");
		if (headStart != -1) {
			int headEnd = original2.toLowerCase().indexOf("</head>");
			if (headEnd != -1) {
				meta = original2.substring(headStart, headEnd);
			}
		}
		metadados2.put(HEAD_METADADO, meta);
		return metadados2;
	}
	
	@Override
	public String toString() {
		return "===" + super.id + System.lineSeparator() + this.getMetadados().get(HEAD_METADADO)
				+ System.lineSeparator() + "===" + super.limpo;
	}
	
}