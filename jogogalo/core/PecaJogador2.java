package jogogalo.core;

/**
 * Define as caracteristicas de Jogador 2 <p>
 * Representa uma posicao do tabuleiro que foi preenchida com a peca do Jogador 2
 * 
 * @author 51355 Joao Silva / 65921 Marco Tomas / 71047 Pedro Santos
 * @version 1.0
 */
public class PecaJogador2 extends Peca {

        /**
         * Faz o override do metodo com o mesmo nome na classe Peca <p>
         * Define a String "o" como simbolo correspondente a peca do Jogador 2
         * 
         * @return String "o"
         * @see Peca#devolveSimbolo() 
         */
	public String devolveSimbolo () {
		return "o";
	}

        /**
         * Faz o override do metodo com o mesmo nome na classe Peca <p>
         * Define o nome do Jogador correspondente ao Jogador 2 <p>
         * 
         * @return String "Jogador 2"
         * @see Peca#devolveJogador() 
         */
	public String devolveJogador () {
		return "Jogador 2";
	}
}