package alunos;

import java.util.Scanner;

/**
 * Interface com o menu necessário para manipular o controle de alunos.
 * 
 * @author Ingrid Jackeline
 *
 */
public class MainControle {

	/**
	 * Contém a lógica necessária para o bom funcionamento do menu.
	 */
	public static void main(String[] args) {
		ControleAlunos controle = new ControleAlunos();
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		
		while (true) {
			escolha = menu(scanner);
			scanner.nextLine();
			comando(escolha, controle, scanner);
		}
	}
	
	/**
	 * Exibe o menu e captura a escolha do usuário.
	 * 
	 * @param scanner Captura a opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print("\n" + "(C)adastrar Aluno\n" + "(E)xibir Aluno\n" + 
		"(N)ovo Grupo\n" + "(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" + 
		"(R)egistrar Aluno que Respondeu\n" + "(I)mprimir Alunos que Responderam\n" + "(O)lhaí quais Grupos o Aluno Tá\n" + 
		"(S)im, quero Fechar o Programa!\n" + "\n" + "Opção> ");
		
		return scanner.next().toUpperCase();
	}
	
	/**
	 * Interpreta a opção escolhida pelo usuário do sistema.
	 * 
	 * @param opcao A opção digitada.
	 * @param controle O controle de alunos que está sendo manipulado.
	 * @param scanner O objeto scanner para o caso de o comando precisar de mais input.
	 */
	private static void comando(String opcao, ControleAlunos controle, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraAluno(controle, scanner);
			break;
		case "E":
			consultaAluno(controle, scanner);
			break;
		case "N":
			cadastraGrupo(controle, scanner);
			break;
		case "A":
			System.out.print("(A)locar Aluno ou (P)ertinência a Grupo? ");
			String escolha = scanner.next().toUpperCase();
			scanner.nextLine();
			switch (escolha) {
			case "A":
				alocaAlunoEmGrupo(controle, scanner);
				break;
			case "P":
				verificaPertinenciaAoGrupo(controle, scanner);
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
			}
			break;
		case "R":
			registraAlunoQueRespondeQuestao(controle, scanner);
			break;
		case "I":
			imprimeAlunosQueRespondemQuestoes(controle);
			break;
		case "O":
			imprimeGruposDoAluno(controle, scanner);
			break;
		case "S":
			System.exit(0);
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Cadastra um aluno no controle de alunos.
	 * 
	 * @param controle O controle de alunos.
	 * @param scanner O scanner que captura as informações do cadastro.
	 */
	private static void cadastraAluno(ControleAlunos controle, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine().trim();
		System.out.print("Nome: ");
		String nome = scanner.nextLine().trim();
		System.out.print("Curso: ");
		String curso = scanner.nextLine().trim();
		
		if (controle.verificaMatriculaExistente(matricula)) {
			System.out.println("MATRÍCULA JÁ CADASTRADA!");
		} else {
			controle.cadastraAluno(matricula, nome, curso);
			System.out.println("CADASTRO REALIZADO!");
		}
	}
	
	/**
	 * Exibe as informações do aluno cadastrado no controle de alunos.
	 * 
	 * @param controle O controle de alunos.
	 * @param scanner O scanner que captura o aluno a ser exibido.
	 */
	private static void consultaAluno(ControleAlunos controle, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine().trim();
		
		if (controle.verificaMatriculaExistente(matricula)) {
			System.out.print("\nAluno: ");
			System.out.println(controle.consultaAluno(matricula));
		} else {
			System.out.println("Aluno não cadastrado.");
		}
	}
	
	/**
	 * Cadastra um grupo no controle de alunos.
	 * 
	 * @param controle O controle de alunos.
	 * @param scanner O scanner que captura as informações do cadastro.
	 */
	private static void cadastraGrupo(ControleAlunos controle, Scanner scanner) {
		System.out.print("\nGrupo: ");
		String nomeGrupo = scanner.nextLine().trim();
		System.out.print("Tamanho: ");
		String tamanho = scanner.nextLine().trim();
		
		if (controle.verificaGrupoExistente(nomeGrupo)) {
			System.out.println("GRUPO JÁ CADASTRADO!");
		} else {
			controle.cadastraGrupo(nomeGrupo, tamanho);
			System.out.println("CADASTRO REALIZADO!");
		}
	}
	
	/**
	 * Aloca um aluno em um grupo do controle de alunos.
	 * 
	 * @param controle O controle de alunos.
	 * @param scanner O scanner que captura as informações da alocação.
	 */
	private static void alocaAlunoEmGrupo(ControleAlunos controle, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine().trim();
		System.out.print("Grupo: ");
		String nomeGrupo = scanner.nextLine().trim();
		
		if (!controle.verificaMatriculaExistente(matricula)) {
			System.out.println("Aluno não cadastrado.");
		} else if (!controle.verificaGrupoExistente(nomeGrupo)) {
			System.out.println("Grupo não cadastrado.");
		} else if (controle.verificaGrupoCheio(nomeGrupo)) {
			System.out.println("GRUPO CHEIO!");
		} else {
			controle.alocaAlunoEmGrupo(matricula, nomeGrupo);
			System.out.println("ALUNO ALOCADO!");
		}
	}
	
	/**
	 * Verifica se um aluno pertence a um grupo do controle de alunos.
	 * 
	 * @param controle O controle de alunos.
	 * @param scanner O scanner que captura as informações a serem utilizadas na verificação.
	 */
	private static void verificaPertinenciaAoGrupo(ControleAlunos controle, Scanner scanner) {
		System.out.print("\nGrupo: ");
		String nomeGrupo = scanner.nextLine().trim();
		System.out.print("Aluno: ");
		String matricula = scanner.nextLine().trim();
		
		if (!controle.verificaGrupoExistente(nomeGrupo)) {
			System.out.println("GRUPO NÃO CADASTRADO!");
		} else if (!controle.verificaMatriculaExistente(matricula)) {
			System.out.println("ALUNO NÃO CADASTRADO!");
		} else if (controle.verificaPertinenciaAoGrupo(nomeGrupo, matricula)) {
			System.out.println("ALUNO PERTENCE AO GRUPO!");
		} else {
			System.out.println("ALUNO NÃO PERTENCE AO GRUPO!");
		}
	}
	
	/**
	 * Registra um aluno cadastrado no controle de alunos que responde uma questão no quadro.
	 * 
	 * @param controle O controle de alunos.
	 * @param scanner O scanner que captura as informações do registro.
	 */
	private static void registraAlunoQueRespondeQuestao(ControleAlunos controle, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine().trim();
		
		if (!controle.verificaMatriculaExistente(matricula)) {
			System.out.println("Aluno não cadastrado.");
		} else {
			controle.registraAlunoQueRespondeQuestao(matricula);
			System.out.println("ALUNO REGISTRADO!");
		}
	}
	
	/**
	 * Imprime a lista dos alunos cadastrados no controle de alunos que respondem questões no quadro.
	 * 
	 * @param controle O controle de alunos.
	 */
	private static void imprimeAlunosQueRespondemQuestoes(ControleAlunos controle) {
		System.out.println("\nAlunos:");
		System.out.println(controle.imprimeAlunosQueRespondemQuestoes());
	}
	
	/**
	 * Imprime todos os grupos aos quais um aluno cadastrado no controle de alunos pertence.
	 * 
	 * @param controle O controle de alunos.
	 * @param scanner O scanner que captura o aluno escolhido para a impressão.
	 */
	private static void imprimeGruposDoAluno(ControleAlunos controle, Scanner scanner) {
		System.out.print("\nAluno: ");
		String matricula = scanner.nextLine().trim();
		
		if (!controle.verificaMatriculaExistente(matricula)) {
			System.out.println("Aluno não cadastrado.");
		} else {
			System.out.println("Grupos:");
			System.out.println(controle.imprimeGruposDoAluno(matricula));
		}
	}
	
}