package jogogalo.textui;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import jogogalo.core.Aplicacao;

/**
 * Command for showing the number of finished games.
 */
public class ShowNumberOfGames extends Command<Aplicacao> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowNumberOfGames(Aplicacao app) {
        super("Ver Número de Jogos", app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        
        Display display = new Display();
        
        display.addNewLine("Numero de Jogos:" + entity().obtemNumeroJogos());
        
        display.display();
    }
}
