package lab2;

/**
 * Representação do registro de finanças do aluno durante o curso. É importante para o aluno 
 * ter controle sobre os ganhos e as despesas obtidas em sua conta financeira.
 * 
 * @author Ingrid Jackeline
 */
public class RegistroFinancas {
	
	/**
	 * Contém os ganhos iniciais do aluno em sua conta.
	 */
	private int ganhosIniciais;
	
	/**
	 * Contém os ganhos que o aluno obteve posteriormente em sua conta.
	 */
	private int[] ganhosAluno;
	
	/**
	 * Contém o total de despesas obtidas pelo estudante.
	 */
	private int totalDespesas;
	
	/**
	 * Contém o total de ganhos obtidos pelo estudante.
	 */
	private int totalGanhos;
	
	/**
	 * Contém o valor líquido gerado pela diferença entre o total de ganhos e o total de despesas.
	 */
	private int valorLiquidoDisponivel;
	
	/**
	 * Constrói o registro de finanças a partir dos ganhos iniciais do estudante e do número
	 * total de ganhos obtidos posteriormente.
	 * 
	 * @param ganhosIniciais os ganhos iniciais do estudante
	 * @param totalDeGanhos o número total de ganhos obtidos posteriormente pelo estudante
	 */
	public RegistroFinancas(int ganhosIniciais, int totalDeGanhos) {
		this.ganhosIniciais = ganhosIniciais;
		this.ganhosAluno = new int[totalDeGanhos];
	}
	
	/**
	 * Adiciona o ganho obtido pelo estudante, após o ganho inicial, no Array criado para 
	 * contê-lo, de acordo a sua posição entre os demais ganhos.
	 * 
	 * @param valorCentavos o valor em centavos do ganho obtido pelo aluno
	 * @param posicaoGanho a posição ocupada pelo ganho entre os demais ganhos obtidos
	 */
	public void adicionaGanhos(int valorCentavos, int posicaoGanho) {
		ganhosAluno[posicaoGanho - 1] = valorCentavos;
	}
	
	/**
	 * Adiciona despesas ao total de despesas na conta do aluno.
	 * 
	 * @param valorCentavos o valor em centavos da despesa obtida pelo aluno
	 */
	public void pagaDespesa(int valorCentavos) {
		totalDespesas += valorCentavos;
	}
	
	/**
	 * Retorna uma String que apresenta as posições de todos os ganhos obtidos, seguidas dos seus 
	 * respectivos valores. A representação segue o formato "PosiçãoDoGanho - ValorDoGanho".
	 * 
	 * @return a representação em String de todos os ganhos e das suas respectivas posições
	 */
	public String exibeGanhos() {
		int posicaoGanho = 0;
		String ganho = "";
		for (int i = 0; i < ganhosAluno.length; i++) {
			posicaoGanho += 1;
			ganho += posicaoGanho + " - " + ganhosAluno[i] + "\n";
		}
		return ganho.trim();
	}
	
	/**
	 * Retorna uma String que apresenta o total de ganhos, o total de despesas e o valor líquido 
	 * disponível no registro de finanças do aluno. A representação segue o formato "Total recebidos: 
	 * TotalDeGanhos, Despesas totais: TotalDeDespesas, Total disponível: ValorLíquidoDisponível".
	 * 
	 * @return a representação em String do estado geral financeiro do estudante
	 */
	public String toString() {
		calculaTotalGanhos();
		calculaValorLiquido();
		return "Total recebidos: " + totalGanhos + ", " + "Despesas totais: " + totalDespesas + ", " + "Total disponível: " + valorLiquidoDisponivel;
	}

	/**
	 * Calcula o total de ganhos obtidos pelo aluno, desde os ganhos iniciais.
	 */
	private void calculaTotalGanhos() {
		totalGanhos = ganhosIniciais;
		for (int ganho : ganhosAluno) {
			totalGanhos += ganho;
		}
	}

	/**
	 * Calcula o valor líquido da conta do aluno, gerado a partir da diferença entre o seu total 
	 * de ganhos e o seu total de despesas.
	 */
	private void calculaValorLiquido() {
		valorLiquidoDisponivel = totalGanhos - totalDespesas;
	}
	
}