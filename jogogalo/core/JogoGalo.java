package jogogalo.core;

/**
 * Classe JogoGalo - Cria um tabuleiro de jogo do jogo e coloca pecas <p>
 * Cria um tabuleiro de jogo do jogo <p>
 * Coloca pecas de 2 jogadores distintos no tabuleiro <p>
 * Verifica quem ganhou o jogo e mostra o estado actual do tabuleiro
 *
 * @author 51355 Joao Silva / 65921 Marco Tomas / 71047 Pedro Santos
 * @version 1.0
 */

public class JogoGalo {
	
	private EstadoFinal _estado;

	/**
	* _tabuleiro - tabuleiro de jogo (Matriz de objectos da classe Peca)<p>
	* Guarda a informação relativa ao posisionamento das pecas e das posicoes livres do jogo do jogo
	*
	*/
	
	private Peca[][] _tabuleiro;

	/**
	 * Construtor: recebe a dimensao do tabuleiro de jogo<p>
	 * Inicializa todas as posicoes do tabuleiro de jogo com pecas livres
	 * 
	 * @param dimensao - dimensao do tabuleiro de jogo (ex. 3 corresponde a um tabuleiro 3x3)
	 * @see PecaLivre
	 */
	public JogoGalo (int dimensao) {
		_tabuleiro = new Peca [dimensao][dimensao];
		Peca peca = new PecaLivre();
		_estado = EstadoFinal.ADECORRER;

		//inicializacao das pecas no jogo
		for (int i = 0; i < dimensao; i++) {
			for (int j = 0; j < dimensao; j++) {
				_tabuleiro[i][j] = peca;
			}
		}


	}

	/**
	 * Coloca pecas no tabuleiro <p>
	 * Coloca um determinado tipo de peca, correspondente a um jogador, na posicao indicada do tabuleiro <p>
	 * Verifica se a posicao indicada faz parte do tabuleiro de jogo e se se encontra vazia no momento <p>
	 * Na versao actual as pecas podem ser objectos das seguintes classes: PecaJogador1, PecaJogador2
	 * 
	 * @param peca tipo de peca a colocar 
	 * @param linha numero de linha onde se quer colocar a peca (varia entre 1 e dimensao)
	 * @param coluna numero de coluna onde se quer colocar a peca (varia entre 1 e dimensao)
	 * 
	 * @see PecaJogador1
	 * @see PecaJogador2
	 * @see PecaLivre
	 * @return valor booleano "true" se for possivel colocar a peca, "false" se nao for
	 */
	public boolean fazJogada (Peca peca, int linha, int coluna) {
		//linha e coluna comecam no 0
		int lin = linha - 1;
		int col = coluna - 1;
		
		//verificar se o jogo ainda nao acabou
		if (_estado != EstadoFinal.ADECORRER){
			System.out.println("\nJogo terminado!");
			return false;

		}

		//verificar se a jogada esta dentro da dimensao do jogo e calha numa casa livre
		if (lin >= 0 && lin < _tabuleiro.length && col >= 0 && col < _tabuleiro.length && _tabuleiro[lin][col].ePecaLivre()){
			_tabuleiro[lin][col] = peca;

			//Verifica se a ultima jogada venceu o jogo
			if(ganhouJogo(linha, coluna)){
				if(peca.devolveJogador().equals("Jogador 1")){
					System.out.println("\nGanhou o Jogador 1!");
					_estado = EstadoFinal.VENCEDORJ1;
				}
				
				if(peca.devolveJogador().equals("Jogador 2")){
					System.out.println("\nGanhou o Jogador 2!");
					_estado = EstadoFinal.VENCEDORJ2;
				}
				return true;
			} 
			else
				if(!haPosicoesLivres()){
					System.out.println("\nEmpate!");
					_estado = EstadoFinal.EMPATE;
				}

		} else
			return false;

		return true;
	}


	/**
	 * Verifica se ha posicoes livres no tabuleiro de jogo 
	 * 
	 * @see PecaLivre
	 * @return valor booleano "true" se houver posicoes livres, "false" se nao houver
	 */
	public boolean haPosicoesLivres () {
		for (int i = 0; i < _tabuleiro.length; i++) {
			for (int j = 0; j < _tabuleiro.length; j++) {
				if (_tabuleiro[i][j].ePecaLivre())
					return true;
			}
		}
		return false;
	}

	/**
	 * Verifica se o jogador ganhou o jogo na ultima jogada <p>
	 * Verifica se o jogador tem 3 pecas seguidas em linha, em coluna ou numa das duas diagonais
	 * tendo por base a ultima jogada
	 * 
	 * @param linha numero de linha onde o jogador colocou a ultima peca (varia entre 1 e dimensao)
	 * @param coluna numero de coluna onde o jogador colocou a ultima peca (varia entre 1 e dimensao)
	 * 
	 * @see Peca
	 * @see PecaLivre
	 * @return valor booleano "true" se o jogador tiver ganho o jogo, "false" se nao tiver ganho o jogo
	 */
	public boolean ganhouJogo (int linha, int coluna) {
		//linha e coluna comecam no 0
		int lin = linha - 1;
		int col = coluna - 1;

		Peca ultima = _tabuleiro[lin][col];
		boolean resultado = true;

		//verificacao da linha
		for (int i = 0; i < _tabuleiro.length; i++) {
			if (!_tabuleiro[lin][i].pertencemMesmoJogador(ultima)){
				resultado = false;
				break;			
			}
		}
		//se nao tiver sido encontrado nenhum valor diferente, entao a linha e do jogador, e ganhou
		if (resultado)
			return true;


		//verificacao da coluna

		resultado = true;

		for (int i = 0; i < _tabuleiro.length; i++) {
			if (!_tabuleiro[i][col].pertencemMesmoJogador(ultima)){
				resultado = false;
				
				break;			
			}
		}
		//se nao tiver sido encontrado nenhum valor diferente, entao a coluna e do jogador, e ganhou
		if (resultado)
			return true;


		//verificacao das diagonais
		resultado = true;

		for (int i = 0; i < _tabuleiro.length; i++) {
			if (!_tabuleiro[i][i].pertencemMesmoJogador(ultima)){
				resultado = false;
				break;
			}

		}
		if (resultado)
			return true;
		resultado = true;
		for (int i = 0; i < _tabuleiro.length; i++) {
			if(!_tabuleiro[i][_tabuleiro.length-1-i].pertencemMesmoJogador(ultima)){
				resultado = false;
				break;
				
			}
		}

		return resultado;

	}
	

	/**
	 * Cria um separador de linha entre duas linhas <p>
	 * Chamado em obtemEstadoJogo()
	 * 
	 * @see JogoGalo#obtemEstadoJogo()
	 * @return String composta por "-+-+-" a separar duas linhas
	 */
	private String criaSeparadorLinha() {
		StringBuilder separador = new StringBuilder();

		for (int i = 0; i < _tabuleiro.length - 1; i++)
			separador.append("-+");

		separador.append("-\n");

		return separador.toString();
	}

	/**
	 * Cria uma String correspondente ao estado de uma linha <p>
	 * A string criada contem os simbolos "x" e "o", nos lugares correspondentes <p>
	 * A separar cada posicao, e colocado o simbolo "|" <p>
	 * Chamado em obtemEstadoJogo ()
	 * 
	 * @param linha Vector de pecas contidas na linha em questao
	 * @see JogoGalo#obtemEstadoJogo()
	 * @return String representativa da linha em causa
	 */
	private String processaLinha(Peca[] linha) {
		StringBuilder res = new StringBuilder();
		int i;

		for(i = 0; i < linha.length - 1; i++) {
			res.append(linha[i].devolveSimbolo()).append("|");
		}

		res.append(linha[i].devolveSimbolo()).append("\n");
		return res.toString();
	}

	/**
	 * Mostra estado do jogo <p>
	 * Faz o output de um conjunto de caracteres que mostram o estado actual do jogo <p>
	 * Diferentes simbolos representam jogadores diferentes (na versao actual: "x" jogador 1, "o" jogador 2) <p>
	 * 
	 * @see JogoGalo#criaSeparadorLinha()
	 * @see JogoGalo#processaLinha(Peca[])
	 * @return String contendo o estado do jogo no momento
	 */
	public String obtemEstadoJogo() {
		StringBuilder str = new StringBuilder();
		String separador = criaSeparadorLinha();
		int i;

		for (i = 0; i < _tabuleiro.length - 1; i++) {
			str.append(processaLinha(_tabuleiro[i]));
			str.append(separador);
		}

		str.append(processaLinha(_tabuleiro[i]));
		return str.toString();
	}
	
	public EstadoFinal retornaEstado(){
		return _estado;
	}

/**
* Funcao main <p>
* Cria um jogo de dimensao 3 <p>
* Cria 2 pecas (p1 e p2), correspondentes ao a 2 jogadores <p>
* Mostra o estado inicial e seguidamente ambos os jogadores colocam pecas em varias posicoes <p>
* Apos cada jogada, verifica se o ultimo jogador a jogar <p>
* Mostra o estado actual
* 
* @param args none
* @see JogoGalo#JogoGalo(int)
* @see JogoGalo#fazJogada(Peca, int, int)
* @see JogoGalo#obtemEstadoJogo()
* @see JogoGalo#ganhouJogo(int, int)
*/
public static void main (String[] args) {
	//1. cria jogo de dimensao 3
	JogoGalo jogo = new JogoGalo(3);
	Peca p1 = new PecaJogador1();
	Peca p2 = new PecaJogador2();
/*
	//2. estado actual 
	System.out.println("Estado Inicial\n" + jogo.obtemEstadoJogo());
	jogo.fazJogada(p1,1,1);
	System.out.println("Estado \n" + jogo.obtemEstadoJogo());
	jogo.fazJogada(p2,2,1);
	System.out.println("Estado \n" + jogo.obtemEstadoJogo());
	jogo.fazJogada(p1,2,2);
	System.out.println("Estado \n" + jogo.obtemEstadoJogo());
	jogo.fazJogada(p2,2,3);
	System.out.println("Estado \n" + jogo.obtemEstadoJogo());
	jogo.fazJogada(p1,1,3);
	System.out.println("Estado \n" + jogo.obtemEstadoJogo());
	jogo.fazJogada(p2,3,3);
	System.out.println("Estado \n" + jogo.obtemEstadoJogo());
	jogo.fazJogada(p1,3,2);
	System.out.println("Estado \n" + jogo.obtemEstadoJogo());
	jogo.fazJogada(p2,1,2);
	System.out.println("Estado \n" + jogo.obtemEstadoJogo());
	jogo.fazJogada(p2,3,1);
	System.out.println("Estado \n" + jogo.obtemEstadoJogo());
*/



/*
	//3. 4. Jogadas 1 e 2
	jogo.fazJogada(p1, 1, 1);
	//System.out.println("P1 ganhou " + jogo.ganhouJogo(1, 1));
	jogo.fazJogada(p2, 1, 2);
	//System.out.println("P2 ganhou " + jogo.ganhouJogo(1, 2));

	//5. Mostra estado actual
	System.out.println("Apos 2 jogadas\n" + jogo.obtemEstadoJogo());

	//6. 7. Jogadas 3 e 4
	jogo.fazJogada(p1, 2, 1);
	//System.out.println("P1 ganhou " + jogo.ganhouJogo(2, 1));
	jogo.fazJogada(p2, 2, 3);
	//System.out.println("P2 ganhou " + jogo.ganhouJogo(2, 3));

	//8. Mostra estado actual
	System.out.println("Apos 4  jogadas\n" + jogo.obtemEstadoJogo());

	//9. 10. Jogadas 5 e 6
	jogo.fazJogada(p1, 3, 1);
	//System.out.println("P1 ganhou " + jogo.ganhouJogo(3, 1));
	jogo.fazJogada(p2, 1, 2);
	//System.out.println("P2 ganhou " + jogo.ganhouJogo(1, 2));

	//11. Mostra estado actual
	System.out.println("Apos 6  jogadas\n" + jogo.obtemEstadoJogo());

	//12. Jogada 7
	jogo.fazJogada(p1, 3, 3);
	//System.out.println("P1 ganhou " + jogo.ganhouJogo(3, 3));

	//13. Mostra estado actual
	System.out.println("Apos 7  jogadas\n" + jogo.obtemEstadoJogo());		*/

}
}