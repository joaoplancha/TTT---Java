package jogogalo.textui;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import jogogalo.core.Aplicacao;
import jogogalo.core.JogoGalo;

/**
 * Command for showing the final state of a finished game.
 */
public class ShowGame extends Command<Aplicacao> {

      /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowGame(Aplicacao app) {
        super("Mostrar Jogo", app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Form f = new Form();
        InputInteger _idx = new InputInteger(f, "Indique o indice do Jogo: ");
        f.parse();
        Display display = new Display();

        if (_idx.value() <= entity().obtemNumeroJogos() && _idx.value() > 0)
            display.addNewLine(entity().retornaJogo(_idx.value()).obtemEstadoJogo());
        else
            display.addNewLine("Indice de jogo invalido!");

        display.display();

    }
}