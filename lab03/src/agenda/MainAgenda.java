package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus necessários para manipular uma agenda de contatos.
 * 
 * @author Ingrid Jackeline
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		System.out.println("Carregando agenda inicial");
		
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nÃ£o encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}
	}
	
	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		
		System.out.println("Carregamos " + carregados + " registros.");
	}

	/**
	 * Exibe o menu e captura a escolha do usuário.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print("\n" + "(C)adastrar Contato\n" + "(L)istar Contatos\n" + 
		"(E)xibir Contato\n" + "(F)avoritos\n" + "(A)dicionar Favorito\n" + "(T)ags\n" + "(S)air\n" + "\n" + "Opção> ");
		
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida pelo usuário do sistema.
	 * 
	 * @param opcao Opção digitada.
	 * @param agenda A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "T":
			adicionaTags(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Cadastra um contato na agenda de contatos. 
	 * 
	 * @param agenda A agenda de contatos.
	 * @param scanner Scanner para pedir informações do contato a ser cadastrado.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\n" + "Posição> ");
		int posicao = scanner.nextInt();
		System.out.print("Nome> ");
		scanner.nextLine();
		String nome = scanner.nextLine().trim();
		System.out.print("Sobrenome> ");
		String sobrenome = scanner.nextLine().trim();
		System.out.print("Telefone> ");
		String telefone = scanner.nextLine().trim();

		if (posicao - 1 < 0 || posicao - 1 > 99) {
			System.out.println("POSIÇÃO INVÁLIDA");
		} else if (nome.equals("") || telefone.equals("")) {
			System.out.println("CONTATO INVÁLIDO");
		} else {
			if (agenda.verificaCadastroExistente(nome, sobrenome)) {
				System.out.println("CONTATO JÁ CADASTRADO");
			} else {
				agenda.cadastraContato(posicao, nome, sobrenome, telefone);
				System.out.println("CADASTRO REALIZADO");
			}
		}
	}	
	
	/**
	 * Imprime a lista dos contatos existentes na agenda.
	 * 
	 * @param agenda A agenda de contatos.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println(agenda.toString());
	}
	
	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda de contatos.
	 * @param scanner Scanner que captura o contato a ser exibido.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicao = scanner.nextInt();
		
		System.out.println(agenda.exibeContato(posicao));
	}
	
	/**
	 * Imprime a lista dos contatos favoritos da agenda.
	 * 
	 * @param agenda A agenda de contatos.
	 */
	private static void listaFavoritos(Agenda agenda) {
		System.out.println(agenda.listaFavoritos());
	}
	
	/**
	 * Adiciona um contato existente à lista de favoritos da agenda.
	 * 
	 * @param agenda A agenda de contatos.
	 * @param scanner Scanner que captura a posição do contato existente e a posição em
	 * que ele ficará na lista de favoritos.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicaoContato = scanner.nextInt();
		System.out.print("Posicao> ");
		int posicaoFavorito = scanner.nextInt();
		
		if (agenda.verificaFavorito(posicaoContato)) {
			System.out.println("CONTATO JÁ FAVORITADO");
		} else {
			agenda.adicionaFavorito(posicaoContato, posicaoFavorito);
			System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicaoFavorito + "!");
		}
	}
	
	/**
	 * Adiciona tags aos contatos da agenda.
	 * 
	 * @param agenda A agenda de contatos.
	 * @param scanner Scanner que captura o contato a receber a tag, bem como a tag a ser adicionada
	 * e a sua respectiva posição no contato.
	 */
	private static void adicionaTags(Agenda agenda, Scanner scanner) {
		System.out.print("Contato(s)> ");
		scanner.nextLine();
		String[] posicaoContato = scanner.nextLine().split(" ");
		System.out.print("Tag> ");
		String tag = scanner.next();
		System.out.print("Posicao tag> ");
		int posicaoTag = scanner.nextInt();
		
		for (String valor : posicaoContato) {
			int posicao = Integer.parseInt(valor);
			agenda.adicionaTags(posicao, posicaoTag, tag);
		}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.exit(0);
	}
	
}