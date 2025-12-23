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
			return "DAMA";
	}
	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		return mat;
	}

}
