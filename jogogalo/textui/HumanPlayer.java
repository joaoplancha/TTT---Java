package jogogalo.textui;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import jogogalo.core.Aplicacao;
import jogogalo.core.JogoGalo;
import jogogalo.core.Peca;
import jogogalo.core.PecaJogador1;
import jogogalo.core.PecaJogador2;
import jogogalo.core.EstadoFinal;

/**
 * Command for playing as a human player.
 */
public class HumanPlayer extends Command<JogoGalo> {

    private Peca _peca;
    private int _idx; // the index of the other player in the menu

    /**
     * Constructor.
     * 
     * @param game the target entity.
     * @param firstPlayer plays as first player or second player
     */
    public HumanPlayer(JogoGalo game, boolean firstPlayer) {
        super(firstPlayer ? "Jogar Jogador 1" : "Jogar Jogador 2", game);
        _peca = firstPlayer ? new PecaJogador1() : new PecaJogador2();
        _idx = firstPlayer ? 1 : 0;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public void execute() {
        Form f = new Form();
        InputInteger row = new InputInteger(f, "Indique linha da jogada: ");
        InputInteger column = new InputInteger(f, "Indique coluna da jogada: ");
        f.parse();
        Display display = new Display();

        if (entity().fazJogada(_peca, row.value(), column.value())) { // play is valid
            display.add(entity().obtemEstadoJogo());
            invisible();     // turn off this player

            if (entity().retornaEstado() == EstadoFinal.ADECORRER) {
                menu().entry(_idx).visible(); // it is the other player's turn
            } else
                display.addNewLine("Jogo Terminado");
        } else
            display.add("Jogada inválida");

        display.display();
    }
}