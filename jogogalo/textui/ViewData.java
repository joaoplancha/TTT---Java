package jogogalo.textui;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import jogogalo.textui.ShowGame;
import jogogalo.textui.ShowNumberOfGames;
import jogogalo.textui.MostWins;

import jogogalo.core.Aplicacao;

/**
 * Command for showing data of old games. creates a menu with two options for showing information
 * about fineshed games.
 */
public class ViewData extends Command<Aplicacao> {

    /**
     * Constructor.
     * 
     * @param app the target entity.
     */
    public ViewData(Aplicacao app) {
        super("Ver Histórico", app);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Command<?>[] commands = {
            new ShowNumberOfGames(entity()),
            new ShowGame(entity()),
            new MostWins(entity()),
            new MostWins(entity(),true)
        };

        Menu historicoMenu = new Menu("Historico de Jogos", commands);
        historicoMenu.open();

    }
}