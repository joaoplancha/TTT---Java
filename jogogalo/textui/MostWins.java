package jogogalo.textui;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import jogogalo.core.Aplicacao;

import java.util.Arrays;


/**
 * Command for showing the final state of a finished game.
 */
public class MostWins extends Command<Aplicacao> {

  private boolean aut = false;
  private int[] authors;
      /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public MostWins(Aplicacao app) {
        super("Jogador com mais vitorias", app);
    }

    public MostWins(Aplicacao app, boolean aut) {
        super("Autoria do trabalho", app);
        this.aut = true;
        authors = this.obtemAutoria();
    }    

    public static int[] obtemAutoria() {
        int[] _autoria = {83, 51355, 65921, 85155};
        return _autoria;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        if (aut) {
            display.addNewLine("Autores do trabalho: " + Arrays.toString(authors));
        } 
        else {
            display.addNewLine("Maior numero de vitorias: " + entity().maisVitorias());
            
        }
        display.display();
    }
}