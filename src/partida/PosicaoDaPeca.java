package partida;

import estruturas.Posicao;

public class PosicaoDaPeca {
	private char coluna;
	private int linha;
	public PosicaoDaPeca(char coluna, int linha) {
		if(coluna < 'a'|| coluna > 'h' || linha < 1 || linha > 8  ) {
			throw new PartidaExcecao("Erro de instanciamento. Valores válidos são de a1 até h8");
		}
		this.coluna = coluna;
		this.linha = linha;
	}
	public char getColuna() {
		return coluna;
	}
	public int getLinha() {
		return linha;
	}
	
	protected Posicao paraPosicao() {
		return new Posicao(8 - linha, coluna - 'a' );
	}
	protected static PosicaoDaPeca daPosicao(Posicao posicao) {
		return new PosicaoDaPeca ((char) ('a' - posicao.getColuna()), 8 - posicao.getLinha());
		
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
}
