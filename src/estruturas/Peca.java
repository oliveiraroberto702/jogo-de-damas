package estruturas;

public class Peca {
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null; // desnecessário
	}
	
	protected Tabuleiro getTabuleirp() {  // somente subclasses e classes do mesmpo pacote
		return tabuleiro;
	}
	
	
	
}
