package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Representa a biblioteca de transformações textuais BibliTeX e todas as 
 * suas funcionalidades, incluindo os tipos de transformações que podem ser 
 * utilizados e armazenando um histórico de todas as transformações realizadas, 
 * bem como os textos originais que foram processados durante a execução do 
 * sistema.
 * 
 * @author Ingrid Jackeline
 *
 */
public class TransformaTexto {

	/**
	 * Armazena todas as transformações que foram realizadas pelo sistema, de 
	 * acordo com a ordem em que estas ocorreram.
	 */
	private List<String> historicoTransformacoes;
	
	/**
	 * Armazena todos os textos originais que foram transformados pelo sistema, 
	 * suprimindo as possíveis repetições.
	 */
	private Set<String> textosOriginais;
	
	/**
	 * Armazena todos os tipos de transformação disponíveis no sistema, apresentando 
	 * uma associação entre cada nome cadastrado e o tipo de transformação que ele 
	 * representa.
	 */
	private Map<String, AlgoritmoTransformacao> tiposTransformacoes;
	
	/**
	 * O logger que registra as operações realizadas no sistema.
	 */
	private Logger logger;
	
	/**
	 * Constrói a biblioteca de transformações textuais, responsável por armazenar 
	 * os tipos de transformação disponíveis, os textos originais processados e o 
	 * histórico das transformações realizadas. 
	 */
	public TransformaTexto() {
		this.historicoTransformacoes = new ArrayList<String>();
		this.textosOriginais = new HashSet<String>();
		this.tiposTransformacoes = new HashMap<String, AlgoritmoTransformacao>();
		cadastraTransformacoesPadroes();
	}
	
	/**
	 * Constrói a biblioteca de transformações textuais, responsável por armazenar 
	 * os tipos de transformação disponíveis, os textos originais processados e o 
	 * histórico das transformações realizadas. Além disso, ela possui um logger que 
	 * é responsável por registrar as operações realizadas no sistema.
	 * 
	 * @param logger O logger que registrará as operações realizadas no sistema.
	 */
	public TransformaTexto(Logger logger) {
		if (logger == null) {
			throw new NullPointerException("O logger não pode ser nulo.");
		}
		
		this.historicoTransformacoes = new ArrayList<String>();
		this.textosOriginais = new HashSet<String>();
		this.tiposTransformacoes = new HashMap<String, AlgoritmoTransformacao>();
		this.logger = logger;
		cadastraTransformacoesPadroes();
	}
	
	/**
	 * Cadastra todas as transformações padrões que devem estar disponíveis para 
	 * o usuário assim que a biblioteca for inicializada.
	 */
	private void cadastraTransformacoesPadroes() {
		AlgoritmoTransformacao algoritmoCamelCase = new CamelCaseFy();
		AlgoritmoTransformacao algoritmoClean = new Clean();
		AlgoritmoTransformacao algoritmoInterroga = new InterrogaPraPontos();
		AlgoritmoTransformacao algoritmoUpperCase = new UpperCase();
		AlgoritmoTransformacao algoritmoCleanSpaces = new CleanSpaces();
		AlgoritmoTransformacao algoritmoVogaisEstrelas = new VogaisPraEstrelas();
		
		this.tiposTransformacoes.put("CaMeLcAsEfY", algoritmoCamelCase);
		this.tiposTransformacoes.put("clean", algoritmoClean);
		this.tiposTransformacoes.put("InterrogaPraPontos", algoritmoInterroga);
		this.tiposTransformacoes.put("upperCase", algoritmoUpperCase);
		this.tiposTransformacoes.put("cleanSpaces", algoritmoCleanSpaces);
		this.tiposTransformacoes.put("VogaisPraEstrelas", algoritmoVogaisEstrelas);
	}
	
	/**
	 * Retorna o histórico de todas as transformações realizadas no sistema.
	 * 
	 * @return O histórico de todas as transformações realizadas.
	 */
	public List<String> getHistoricoTransformacoes() {
		return this.historicoTransformacoes;
	}
	
	/**
	 * Retorna o conjunto de todos os textos originais que foram utilizados nas 
	 * transformações textuais do sistema.
	 * 
	 * @return O conjunto dos textos originais que foram transformados.
	 */
	public Set<String> getTextosOriginais() {
		return this.textosOriginais;
	}
	
	/**
	 * Retorna todos os tipos de transformações que estão cadastrados na biblioteca, 
	 * com cada um deles associado ao seu respectivo nome de cadastro.
	 * 
	 * @return A associação entre todos os tipos de transformação cadastrados e os 
	 * seus respectivos nomes.
	 */
	public Map<String, AlgoritmoTransformacao> getTiposTransformacoes() {
		return this.tiposTransformacoes;
	}
	
	/**
	 * Cadastra os novos tipos de transformações textuais que poderão ser 
	 * implementados pela biblioteca, além dos tipos padrões já existentes.
	 * 
	 * @param tipoTransformacao O nome do tipo de transformação a ser cadastrado.
	 * @param algoritmoTransformacao O algoritmo de transformação a ser cadastrado.
	 */
	public void cadastraTransformacao(String tipoTransformacao, AlgoritmoTransformacao algoritmoTransformacao) {
		if (tipoTransformacao == null) {
			throw new NullPointerException("O tipo de transformação não pode ser nulo.");
		} else if (tipoTransformacao.isBlank()) {
			throw new IllegalArgumentException("O tipo de transformação não pode ser vazio.");
		}
		if (algoritmoTransformacao == null) {
			throw new NullPointerException("O algoritmo de transformação não pode ser nulo.");
		}
		if (logger != null) {
			this.logger.registraOperacao("cadastraTransformacao", tipoTransformacao);
		}
		
		this.tiposTransformacoes.put(tipoTransformacao, algoritmoTransformacao);
	}
	
	/**
	 * Realiza as transformações textuais da biblioteca a partir do tipo de transformação 
	 * escolhido e do texto original a ser transformado.
	 * 
	 * @param tipoTransformacao O nome do tipo de transformação cadastrado.
	 * @param textoOriginal O texto original a ser transformado.
	 * @return O texto transformado a partir do tipo de transformação utilizado.
	 */
	public String transforma(String tipoTransformacao, String textoOriginal) {
		if (tipoTransformacao == null) {
			throw new NullPointerException("O tipo de transformação não pode ser nulo.");
		} else if (tipoTransformacao.isBlank()) {
			throw new IllegalArgumentException("O tipo de transformação não pode ser vazio.");
		} else if (!this.tiposTransformacoes.containsKey(tipoTransformacao)) {
			throw new IllegalArgumentException("O tipo de transformação não está cadastrado.");
		}
		if (textoOriginal == null) {
			throw new NullPointerException("O texto original não pode ser nulo.");
		} else if (textoOriginal.isBlank()) {
			throw new IllegalArgumentException("O texto original não pode ser vazio.");
		}
		if (logger != null) {
			this.logger.registraOperacao("transforma", tipoTransformacao);
		}
		
		AlgoritmoTransformacao algoritmoTransformacao = this.tiposTransformacoes.get(tipoTransformacao);
		String textoTransformado = algoritmoTransformacao.transforma(textoOriginal);
		
		adicionaTextoAosTextosOriginais(textoOriginal);
		adicionaTransformacaoAoHistorico(textoOriginal, tipoTransformacao, textoTransformado);
		
		return textoTransformado;
	}
	
	/**
	 * Adiciona o texto original utilizado na transformação da biblioteca ao 
	 * conjunto de textos originais, caso ele ainda não faça parte desse conjunto.
	 * 
	 * @param textoOriginal O texto original utilizado na transformação.
	 */
	private void adicionaTextoAosTextosOriginais(String textoOriginal) {
		this.textosOriginais.add(textoOriginal);
	}
	
	/**
	 * Adiciona a transformação textual realizada na biblioteca ao histórico de 
	 * transformações, armazenando o texto original, o tipo de transformação utilizado 
	 * e o texto transformado. Ela é adicionada mesmo que já haja outra transformação 
	 * idêntica no histórico.
	 * 
	 * @param textoOriginal O texto original que foi transformado.
	 * @param tipoTransformacao O tipo de transformação utilizado.
	 * @param textoTransformado O texto criado a partir da transformação realizada.
	 */
	private void adicionaTransformacaoAoHistorico(String textoOriginal, String tipoTransformacao, String textoTransformado) {
		String transformacao = textoOriginal + " -> " + tipoTransformacao + " -> " + textoTransformado;
		this.historicoTransformacoes.add(transformacao);
	}
	
	/**
	 * Conta todas as transformações que foram realizadas pela biblioteca, levando em 
	 * consideração as possíveis repetições.
	 * 
	 * @return O número de transformações realizadas pela biblioteca.
	 */
	public int contaTransformacao() {
		if (logger != null) {
			this.logger.registraOperacao("contaTransformacao", "");
		}
		
		return this.historicoTransformacoes.size();
	}
	
	/**
	 * Exibe a transformação realizada pela biblioteca de acordo com a posição 
	 * que ela ocupa no histórico das transformações.
	 * 
	 * @param posicaoHistorico A posição que a transformação a ser consultada 
	 * ocupa no histórico.
	 * @return Todas as informações referentes à transformação especificada, como 
	 * o texto original, o tipo de transformação e o texto transformado.
	 */
	public String historico(int posicaoHistorico) {
		if (posicaoHistorico < 0 || posicaoHistorico >= this.historicoTransformacoes.size()) {
			throw new IndexOutOfBoundsException("A posição da transformação realizada não existe no histórico.");
		}
		if (logger != null) {
			this.logger.registraOperacao("historico", Integer.toString(posicaoHistorico));
		}
		
		return this.historicoTransformacoes.get(posicaoHistorico);
	}
	
	/**
	 * Lista todos os textos originais que foram processados pela biblioteca durante 
	 * as operações de transformação textual.
	 * 
	 * @return A representação em String de todos os textos originais da biblioteca.
	 */
	public String listaOriginais() {
		if (logger != null) {
			this.logger.registraOperacao("listaOriginais", "");
		}
		
		String textos = "";
		for (String texto : this.textosOriginais) {
			textos += texto + "\n";
		}
		return textos.trim();
	}
	
	/**
	 * Lista todos os tipos de transformação textual cadastrados na biblioteca 
	 * em ordem alfabética.
	 * 
	 * @return A representação em String de todos os tipos de transformação textual 
	 * da biblioteca.
	 */
	public String listaTransformacoes() {
		if (logger != null) {
			this.logger.registraOperacao("listaTransformacoes", "");
		}
		
		List<String> nomesAlgoritmos = new ArrayList<String>();
		for (AlgoritmoTransformacao algoritmo : this.tiposTransformacoes.values()) {
			nomesAlgoritmos.add(algoritmo.getNome());
		}
		Collections.sort(nomesAlgoritmos, String.CASE_INSENSITIVE_ORDER);
		
		String listaTransformacoes = "";
		for (String nomeAlgoritmo : nomesAlgoritmos) {
			listaTransformacoes += nomeAlgoritmo + "\n";
		}
		return listaTransformacoes.trim();
	}
	
}