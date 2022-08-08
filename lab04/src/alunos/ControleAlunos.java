package alunos;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Representa o controle de alunos da disciplina de Programação II, que inclui os 
 * alunos e grupos de estudo e as operações que podem ser realizadas sobre eles.
 *  
 * @author Ingrid Jackeline
 *
 */
public class ControleAlunos {

	/**
	 * Armazena todos os alunos do sistema, apresentando uma associação entre 
	 * cada matrícula cadastrada e o aluno que ela representa.
	 */
	private HashMap<String, Aluno> alunos;
	
	/**
	 * Armazena todos os grupos de estudo do sistema, apresentando uma associação 
	 * entre cada nome cadastrado e o grupo de estudo que ele representa.
	 */
	private HashMap<String, GrupoEstudo> gruposEstudo;
	
	/**
	 * Armazena todos os alunos que respondem questões no quadro, de acordo com a ordem 
	 * em que foram registrados no sistema.
	 */
	private ArrayList<Aluno> alunosRespondemQuestoes;
	
	/**
	 * Constrói o controle de alunos da disciplina, que armazena todos os grupos de 
	 * estudo, alunos e também quais deles respondem questões no quadro.
	 */
	public ControleAlunos() {
		this.alunos = new HashMap<String, Aluno>();
		this.gruposEstudo = new HashMap<String, GrupoEstudo>();
		this.alunosRespondemQuestoes = new ArrayList<Aluno>();
	}
	
	/**
	 * Retorna um mapa que contém todos os alunos cadastrados no controle, com cada um deles 
	 * associado à sua respectiva matrícula.
	 * 
	 * @return A associação entre todos os alunos cadastrados no controle e as suas 
	 * respectivas matrículas.
	 */
	public HashMap<String, Aluno> getAlunos() {
		return this.alunos;
	}
	
	/**
	 * Retorna um mapa que contém todos os grupos de estudo cadastrados no controle, com cada 
	 * um deles associado ao seu respectivo nome.
	 * 
	 * @return A associação entre todos os grupos cadastrados no controle e os seus 
	 * respectivos nomes.
	 */
	public HashMap<String, GrupoEstudo> getGruposEstudo() {
		return this.gruposEstudo;
	}
	
	/**
	 * Retorna uma lista que contém todos os alunos que responderam questões no quadro, 
	 * respeitando a ordem em que eles foram registrados.
	 * 
	 * @return A lista de todos os alunos que responderam questões no quadro.
	 */
	public ArrayList<Aluno> getAlunosRespondemQuestoes() {
		return this.alunosRespondemQuestoes;
	}
	
	/**
	 * Cadastra um aluno com todas as suas informações no sistema. Ele será identificado 
	 * unicamente pela sua matrícula.
	 * 
	 * @param matricula A matrícula do aluno a ser cadastrado.
	 * @param nome O nome do aluno a ser cadastrado.
	 * @param curso O curso do aluno a ser cadastrado.
	 */
	public void cadastraAluno(String matricula, String nome, String curso) {
		if (verificaMatriculaExistente(matricula)) {
			throw new IllegalArgumentException("A matrícula já está cadastrada.");
		}
		
		this.alunos.put(matricula, new Aluno(matricula, nome, curso));
	}
	
	/**
	 * Verifica se a matrícula do aluno já está cadastrada no controle de alunos.
	 * 
	 * @param matricula A matrícula do aluno a ser verificada.
	 * @return O valor booleano que representa se a matrícula já está cadastrada ou não 
	 * no controle de alunos.
	 */
	public boolean verificaMatriculaExistente(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("A matrícula do aluno não pode ser nula.");
		}
		if (matricula.isBlank()) {
			throw new IllegalArgumentException("A matrícula do aluno não pode ser vazia.");
		}
		
		return this.alunos.containsKey(matricula);
	}
	
	/**
	 * Consulta o aluno a ser exibido através da sua matrícula.
	 * 
	 * @param matricula A matrícula do aluno.
	 * @return A representação em String de todas as informações do aluno.
	 */
	public String consultaAluno(String matricula) {
		if (!verificaMatriculaExistente(matricula)) {
			throw new IllegalArgumentException("A matrícula não está cadastrada.");
		}
		
		Aluno aluno = this.alunos.get(matricula);
		return aluno.toString();
	}
	
	/**
	 * Cadastra um grupo de estudo no sistema a partir do seu nome e do seu tamanho, que 
	 * pode ou não estar definido. Caso o tamanho do grupo não esteja definido, não há 
	 * limite de alunos a serem alocados nele. O grupo de estudo será identificado unicamente 
	 * pelo seu nome.
	 * 
	 * @param nome O nome do grupo a ser cadastrado.
	 * @param tamanho O tamanho do grupo a ser cadastrado, que é opcional.
	 */
	public void cadastraGrupo(String nome, String tamanho) {
		if (verificaGrupoExistente(nome)) {
			throw new IllegalArgumentException("O grupo já está cadastrado.");
		}
		if (tamanho == null) {
			throw new NullPointerException("O tamanho do grupo não pode ser nulo.");
		}
		
		if (tamanho.isBlank()) {
			this.gruposEstudo.put(nome.toUpperCase(), new GrupoEstudo(nome));
		} else {
			int tamanhoGrupo = Integer.parseInt(tamanho);
			this.gruposEstudo.put(nome.toUpperCase(), new GrupoEstudo(nome, tamanhoGrupo));
		}
	}
	
	/**
	 * Verifica se o grupo de estudo já está cadastrado no controle de alunos.
	 * 
	 * @param nomeGrupo O nome do grupo a ser verificado.
	 * @return O valor booleano que representa se o grupo de estudo já está cadastrado 
	 * ou não no controle de alunos.
	 */
	public boolean verificaGrupoExistente(String nomeGrupo) {
		if (nomeGrupo == null) {
			throw new NullPointerException("O nome do grupo não pode ser nulo.");
		}
		if (nomeGrupo.isBlank()) {
			throw new IllegalArgumentException("O nome do grupo não pode ser vazio.");
		}
		
		return this.gruposEstudo.containsKey(nomeGrupo.toUpperCase());
	}
	
	/**
	 * Aloca o aluno em um grupo de estudo a partir da sua matrícula e do nome 
	 * do grupo, caso haja espaço disponível para a sua alocação.
	 * 
	 * @param matricula A matrícula do aluno a ser alocado no grupo.
	 * @param nomeGrupo O nome do grupo de estudo a receber o aluno.
	 * @return Um valor booleano que indica se o aluno foi ou não alocado no grupo. O 
	 * aluno não é alocado se já fizer parte do grupo.
	 */
	public boolean alocaAlunoEmGrupo(String matricula, String nomeGrupo) {
		if (!verificaMatriculaExistente(matricula)) {
			throw new IllegalArgumentException("O aluno não está cadastrado.");
		}
		if (!verificaGrupoExistente(nomeGrupo)) {
			throw new IllegalArgumentException("O grupo não está cadastrado.");
		}
		if (verificaGrupoCheio(nomeGrupo)) {
			throw new IllegalArgumentException("O grupo já está cheio.");
		}
		
		Aluno aluno = this.alunos.get(matricula);
		GrupoEstudo grupoEstudo = this.gruposEstudo.get(nomeGrupo.toUpperCase());
		return grupoEstudo.adicionaAluno(aluno);
	}
	
	/**
	 * Verifica se o grupo de estudo já atingiu o limite de alunos que podem ser 
	 * alocados, caso ele possua um tamanho definido.
	 * 
	 * @param nomeGrupo O nome do grupo de estudo a ser verificado.
	 * @return O valor booleano que representa se o grupo está cheio ou não.
	 */
	public boolean verificaGrupoCheio(String nomeGrupo) {
		if (nomeGrupo == null) {
			throw new NullPointerException("O nome do grupo não pode ser nulo.");
		}
		if (nomeGrupo.isBlank()) {
			throw new IllegalArgumentException("O nome do grupo não pode ser vazio.");
		}
		
		GrupoEstudo grupoEstudo = this.gruposEstudo.get(nomeGrupo.toUpperCase());
		return grupoEstudo.estaCheio();
	}
	
	/**
	 * Verifica se um aluno pertence ou não a um determinado grupo de estudo do sistema.
	 * 
	 * @param nomeGrupo O nome do grupo de estudo utilizado na verificação.
	 * @param matricula A matrícula do aluno utilizada na verificação.
	 * @return O valor booleano que representa se o aluno pertence ou não ao grupo 
	 * especificado.
	 */
	public boolean verificaPertinenciaAoGrupo(String nomeGrupo, String matricula) {
		if (!verificaGrupoExistente(nomeGrupo)) {
			throw new IllegalArgumentException("O grupo não está cadastrado.");
		}
		if (!verificaMatriculaExistente(matricula)) {
			throw new IllegalArgumentException("O aluno não está cadastrado.");
		}
		
		GrupoEstudo grupoEstudo = this.gruposEstudo.get(nomeGrupo.toUpperCase());
		Aluno aluno = this.alunos.get(matricula);
		return grupoEstudo.verificaPertinenciaDoAluno(aluno);
	}
	
	/**
	 * Registra o aluno cadastrado no controle que respondeu uma questão no quadro.
	 * 
	 * @param matricula A matrícula do aluno a ser registrado por responder uma questão.
	 */
	public void registraAlunoQueRespondeQuestao(String matricula) {
		if (!verificaMatriculaExistente(matricula)) {
			throw new IllegalArgumentException("O aluno não está cadastrado.");
		}
		
		Aluno aluno = this.alunos.get(matricula);
		this.alunosRespondemQuestoes.add(aluno);
	}
	
	/**
	 * Retorna a lista de todos os alunos que responderam questões no quadro, contendo 
	 * a ordem em que foram registrados e as suas respectivas informações.
	 * 
	 * @return A representação em String de todos os alunos que responderam questões 
	 * no quadro.
	 */
	public String imprimeAlunosQueRespondemQuestoes() {
		String listaAlunos = "";
		for (int i = 0; i < this.alunosRespondemQuestoes.size(); i++) {
			Aluno aluno = this.alunosRespondemQuestoes.get(i);
			listaAlunos += (i + 1) + ". " + aluno.toString() + "\n";
		}
		return listaAlunos.trim();
	}
	
	/**
	 * Retorna a lista de grupos de estudo nos quais um aluno do controle foi alocado.
	 * 
	 * @param matricula A matrícula do aluno cadastrado no controle de alunos.
	 * @return A representação em String de todos os grupos de estudo aos quais o aluno 
	 * especificado pertence.
	 */
	public String imprimeGruposDoAluno(String matricula) {
		if (!verificaMatriculaExistente(matricula)) {
			throw new IllegalArgumentException("O aluno não está cadastrado.");
		}
		
		Aluno aluno = this.alunos.get(matricula);
		String listaGrupos = "";
		for (GrupoEstudo grupoEstudo : this.gruposEstudo.values()) {
			if (grupoEstudo.verificaPertinenciaDoAluno(aluno)) {
				listaGrupos += grupoEstudo.toString() + "\n";
			}
		}
		return listaGrupos.trim();
	}
	
}