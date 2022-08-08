package com.matheusgr.lunr.documento;

import java.util.HashMap;
import java.util.Map;
import biblitex.TransformaTexto;

/**
 * Documento de texto simples. Não precisa de tratamento complexos nem tem
 * metadados próprios.
 */
public class DocumentoTexto extends DocumentoAbstract implements Documento {

	/**
	 * Construtor padrão do documento de texto.
	 * 
	 * @param id ID do documento.
	 * @param txt Texto do documento.
	 */
	public DocumentoTexto(String id, String txt) {
		super(id, txt);
		super.limpo = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.clean, txt).strip();
	}

	@Override
	public Map<String, String> getMetadados() {
		if (super.metadados != null) {
			return super.metadados;
		}
		super.metadados = new HashMap<String, String>();
		super.metadados.put("LINHAS", "" + super.original.chars().filter((value) -> '\n' == value).count());
		super.metadados.put("TAMANHO", "" + super.limpo.length());
		super.metadados.put("METADATADATE", "" + System.currentTimeMillis());
		super.metadados.put("TIPO", "" + "txt");
		return super.metadados;
	}

}