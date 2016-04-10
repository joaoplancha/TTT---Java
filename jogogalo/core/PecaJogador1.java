package jogogalo.core;

/**
 * Define as caracteristicas de Jogador 1 <p>
 * Representa uma posicao do tabuleiro que foi preenchida com a peca do Jogador 1
 *
 * @author 51355 Joao Silva / 65921 Marco Tomas / 71047 Pedro Santos
 * @version 1.0
 */
public class PecaJogador1 extends Peca {
    
        /**
         * Faz o override do metodo com o mesmo nome na classe Peca <p>
         * Define a String "x" como simbolo correspondente a peca do Jogador 1
         * 
         * @return String "x"
         * @see Peca#devolveSimbolo() 
         */
	public String devolveSimbolo () {
		return "x";
	}
       
        /**
         * Faz o override do metodo com o mesmo nome na classe Peca <p>
         * Define o nome do Jogador correspondente ao Jogador 1 <p>
         * 
         * @return String "Jogador 1"
         * @see Peca#devolveJogador() 
         */
	public String devolveJogador () {
		return "Jogador 1";
	}
}