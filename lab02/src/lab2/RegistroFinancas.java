package lab2;

/**
 * Representa��o do registro de finan�as do aluno durante o curso. � importante para o aluno 
 * ter controle sobre os ganhos e as despesas obtidas em sua conta financeira.
 * 
 * @author Ingrid Jackeline
 */
public class RegistroFinancas {
	
	/**
	 * Cont�m os ganhos iniciais do aluno em sua conta.
	 */
	private int ganhosIniciais;
	
	/**
	 * Cont�m os ganhos que o aluno obteve posteriormente em sua conta.
	 */
	private int[] ganhosAluno;
	
	/**
	 * Cont�m o total de despesas obtidas pelo estudante.
	 */
	private int totalDespesas;
	
	/**
	 * Cont�m o total de ganhos obtidos pelo estudante.
	 */
	private int totalGanhos;
	
	/**
	 * Cont�m o valor l�quido gerado pela diferen�a entre o total de ganhos e o total de despesas.
	 */
	private int valorLiquidoDisponivel;
	
	/**
	 * Constr�i o registro de finan�as a partir dos ganhos iniciais do estudante e do n�mero
	 * total de ganhos obtidos posteriormente.
	 * 
	 * @param ganhosIniciais os ganhos iniciais do estudante
	 * @param totalDeGanhos o n�mero total de ganhos obtidos posteriormente pelo estudante
	 */
	public RegistroFinancas(int ganhosIniciais, int totalDeGanhos) {
		this.ganhosIniciais = ganhosIniciais;
		this.ganhosAluno = new int[totalDeGanhos];
	}
	
	/**
	 * Adiciona o ganho obtido pelo estudante, ap�s o ganho inicial, no Array criado para 
	 * cont�-lo, de acordo a sua posi��o entre os demais ganhos.
	 * 
	 * @param valorCentavos o valor em centavos do ganho obtido pelo aluno
	 * @param posicaoGanho a posi��o ocupada pelo ganho entre os demais ganhos obtidos
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
	 * Retorna uma String que apresenta as posi��es de todos os ganhos obtidos, seguidas dos seus 
	 * respectivos valores. A representa��o segue o formato "Posi��oDoGanho - ValorDoGanho".
	 * 
	 * @return a representa��o em String de todos os ganhos e das suas respectivas posi��es
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
	 * Retorna uma String que apresenta o total de ganhos, o total de despesas e o valor l�quido 
	 * dispon�vel no registro de finan�as do aluno. A representa��o segue o formato "Total recebidos: 
	 * TotalDeGanhos, Despesas totais: TotalDeDespesas, Total dispon�vel: ValorL�quidoDispon�vel".
	 * 
	 * @return a representa��o em String do estado geral financeiro do estudante
	 */
	public String toString() {
		calculaTotalGanhos();
		calculaValorLiquido();
		return "Total recebidos: " + totalGanhos + ", " + "Despesas totais: " + totalDespesas + ", " + "Total dispon�vel: " + valorLiquidoDisponivel;
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
	 * Calcula o valor l�quido da conta do aluno, gerado a partir da diferen�a entre o seu total 
	 * de ganhos e o seu total de despesas.
	 */
	private void calculaValorLiquido() {
		valorLiquidoDisponivel = totalGanhos - totalDespesas;
	}
	
}