package com.matheusgr.lunr.busca;

import java.util.Map;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Interface que define os métodos em comum a serem implementados por todos os tipos de busca 
 * presentes no sistema.
 */
public interface Busca {
	
	/**
	 * Realiza a busca a partir da consulta ao DocumentoService.
	 * 
	 * O DocumentoService realiza apenas operações simples de busca, mas sem
	 * ordenação ou tratamento da lógica de relevância.
	 * 
	 * @param ds DocumentoService a ser utilizado para busca.
	 * @return Mapa com os documentos encontrados e o fator de relevância de cada
	 *         operação.
	 */
	Map<Documento, Integer> busca(DocumentoService ds);
	
	/**
	 * Descreve uma consulta para explicar a consulta que foi feita.
	 * 
	 * @return Descrição da busca, onde cada linha representa um parâmetro de busca
	 *         e as colunas representam um detelhamento de cada parâmetro.
	 */
	String[][] descreveConsulta();

}