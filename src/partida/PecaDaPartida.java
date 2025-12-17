package partida;

import estruturas.Peca;
import estruturas.Tabuleiro;

public abstract class PecaDaPartida extends Peca {
	private Cor cor;

	public PecaDaPartida(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

	
	

}
