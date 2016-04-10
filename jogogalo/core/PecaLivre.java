package jogogalo.core;

/**
 * Define as caracteristicas de PecaLivre <p>
 * Representa uma posicao no tabuleiro que nao esta preenchida por pecas de nenhum jogador
 *
 * @author 51355 Joao Silva / 65921 Marco Tomas / 71047 Pedro Santos
 * @version 1.0
 * @see Peca
 */
public class PecaLivre extends Peca {
    
        /**
         * Faz o override do metodo com o mesmo nome na classe Peca <p>
         * Indica que e uma posicao vaga
         * 
         * @return booleano true se a posicao estiver livre, false e nao estiver
         * @see Peca#ePecaLivre() 
         */
	public boolean ePecaLivre () {
		return true;
	}
        
        /**
         * Faz o override do metodo com o mesmo nome na classe Peca <p>
         * Define a String " " como simbolo correspondente a casa vazia
         * 
         * @return String " "
         * @see Peca#devolveSimbolo() 
         */
	public String devolveSimbolo () {
		return " ";
	}

        /**
         * Faz o override do metodo com o mesmo nome na classe Peca <p>
         * Define o nome do Jogador correspondente a uma casa vazia <p>
         * 
         * @return String "Ninguem"
         * @see Peca#devolveJogador() 
         */
	public String devolveJogador () {
		return "Ninguem";
	}

        /**
         * Faz o override do metodo com o mesmo nome na classe Peca <p>
         * Devolve sempre false
         * 
         * @param p objecto da classe PecaJogador1 ou PecaJogador2
         * @return booleano false
         * @see Peca#pertencemMesmoJogador(jogogalo.Peca) 
         */
	public boolean pertencemMesmoJogador (Peca p) {
		return false;
	}

}