package jogogalo.core;

/**
 * Classe abstracta que define os metodos comuns a PecaJogador1/2 e PecaLivre
 *
 * @author 51355 Joao Silva / 65921 Marco Tomas / 71047 Pedro Santos
 * @version 1.0
 */
public abstract class Peca {

    /**
     * Metodo abstracto para ser implementado nas subclasses <p>
     * Define o simbolo da peca correspondente a cada jogador a casa livre
     * 
     * @return String
     */
	public abstract String devolveSimbolo ();
                
    /**
     * Metodo abstracto para ser implementado nas subclasses <p>
     * Define o nome correspondente a cada jogador a casa livre
     * 
     * @return String
     */
	public abstract String devolveJogador ();

    /**
     * Verifica se o objecto sobre o qual foi invocado e o argumento pertencem a mesma classe <p>
     * Sujeito a override na classe PecaLivre
     * 
     * @param p objecto com o qual se quer comparar
     * @return booleano true se pertencerem a mesma classe, false se nao pertencerem
     * @see PecaLivre#pertencemMesmoJogador(jogogalo.Peca) 
     */
	public boolean pertencemMesmoJogador (Peca p) {
		return getClass() == p.getClass();
	}
    /**
     * Verifica se a peca e PecaLivre <p>
     * Por defeito retorna false <p>
     * Sujeito a override na classe PecaLivre
     * 
     * @return String
     * @see PecaLivre#ePecaLivre() 
     */
	public boolean ePecaLivre () {
		return false;
	}
}