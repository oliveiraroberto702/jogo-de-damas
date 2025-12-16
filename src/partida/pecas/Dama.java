package partida.pecas;

import estruturas.Tabuleiro;
import partida.Cor;
import partida.PecaDaPartida;

public class Dama extends PecaDaPartida{
    public static final String ANSI_CIANO_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RESET = "\u001B[0m";
	public Dama(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	
	}
	@Override
	public String toString() {
		return ANSI_CIANO_BACKGROUND + "D" + ANSI_RESET;
	}

}
