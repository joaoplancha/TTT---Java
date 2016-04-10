package jogogalo.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparadorJogoGalo implements Comparator<JogoGalo> {
    public int compare(JogoGalo g1, JogoGalo g2) {
        if (g1.retornaEstado() == g2.retornaEstado())
            return 0;
        
        switch (g1.retornaEstado()) {
        case VENCEDORJ1:
            return 1;
        case EMPATE:
            return -1;
        case VENCEDORJ2:
            if (g2.retornaEstado() == EstadoFinal.VENCEDORJ1)
                return -1;
            return 1;
        default:
            return -1;
                        
        }
    }
}