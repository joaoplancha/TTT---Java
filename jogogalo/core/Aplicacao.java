package jogogalo.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Aplicacao {

	private List<JogoGalo> _jogos;
	private List<JogoGalo> _jogosOrdenados;
	private int _vencedor = 0;

	public Aplicacao() {
		_jogos = new ArrayList<>();
	}

	public void addJogo(JogoGalo game){
		_jogos.add(game);
		
    	if (game.retornaEstado() == EstadoFinal.VENCEDORJ1){
	   		_vencedor++;
    	}
    	if (game.retornaEstado() == EstadoFinal.VENCEDORJ2){
    		_vencedor--;
    	}
	}

	public JogoGalo retornaJogo(int indice) {
		if (indice <= _jogos.size() && indice > 0)
			return _jogos.get(indice-1);
		else {
			System.out.println ("Jogo inexistente");
			return null;			
		}
	}

	public void jaJogados() {
		for (int i = 0; i < _jogos.size(); i++){
			System.out.println ("Estado final do jogo " + i+1 + ": " + _jogos.get(i).obtemEstadoJogo() + "\n");
		}
	}

    public List<JogoGalo> retornaOrdenados() {
        ComparadorJogoGalo comparador = new ComparadorJogoGalo();

        ArrayList<JogoGalo> ordenado = new ArrayList<>(_jogos);
        Collections.sort(ordenado, comparador);
        return ordenado;
    }

    public int obtemNumeroJogos(){
    	return _jogos.size();
    }

    public String maisVitorias(){
    	if (_vencedor > 0)
    		return "Jogador 1";
    	if (_vencedor < 0)
    		return "Jogador 2";
    	else
    		return "Jogador 1 e Jogador 2 tem o mesmo numero de vitorias";
    }


}