package jogogalo.textui;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import jogogalo.textui.HumanPlayer;

import jogogalo.core.Aplicacao;
import jogogalo.core.JogoGalo;
import jogogalo.core.PecaJogador1;
import jogogalo.core.PecaJogador2;
import jogogalo.core.EstadoFinal;

/**
 * Command for starting a new game. Creates a new game and shows a menu with two options: "Play as Player 1" and 
 * "Play as Player 2". When the user quits this menu, if the game is finished then the game is added to the finished games
 * of this application.
 */
public class PlayGame extends Command<Aplicacao> {

    /**
     * Constructor.
     * 
     * @param app the target entity.
     */
    public PlayGame(Aplicacao app) {
        super("Novo Jogo", app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        InputInteger inI = new InputInteger(f, "Indique dimensão do jogo: ");
        f.parse();

        JogoGalo jogo = new JogoGalo(inI.value());

        Command<?>[] commands = {
            new HumanPlayer(jogo, true),
            new HumanPlayer(jogo, false),
        };

        Menu jogoMenu = new Menu("Jogar", commands);
        jogoMenu.entry(1).invisible();
        jogoMenu.open();
 
        if (jogo.retornaEstado() != EstadoFinal.ADECORRER) {
            entity().addJogo(jogo);
        }
    }
}