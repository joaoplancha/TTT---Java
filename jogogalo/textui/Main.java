package jogogalo.textui;

import jogogalo.core.Aplicacao;

import jogogalo.textui.MainMenu;

import static pt.utl.ist.po.ui.UserInteraction.IO;


public class Main {

    public static void main(String[] args) throws Exception {

        Aplicacao app =  new Aplicacao();
        MainMenu menu = new MainMenu(app);
    
        menu.open();
        IO.close();
    }
}
