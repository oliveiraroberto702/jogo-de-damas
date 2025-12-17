package partida.pecas;

import estruturas.Tabuleiro;
import partida.Cor;
import partida.PecaDaPartida;

public class Dama extends PecaDaPartida{
    public Dama(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	
	}
	@Override
	public String toString() {
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_WHITE = "\u001B[37m";
		return "D";
	}
	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		return mat;
	}

}
