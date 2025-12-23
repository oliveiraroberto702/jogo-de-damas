package partida;

import estruturas.Peca;
import estruturas.Posicao;
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

	
	protected boolean existePecaOponente(Posicao posicao) {
		PecaDaPartida p = (PecaDaPartida) getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
		
	}

}
