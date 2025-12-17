package partida.pecas;

import estruturas.Tabuleiro;
import partida.Cor;
import partida.PecaDaPartida;

public class Peao  extends PecaDaPartida{

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	
	}
	@Override
	public String toString() {
		return "p";
	}
	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		return mat;
	}
}
