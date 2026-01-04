package partida;

import estruturas.Posicao;

public class PosicaoDaPeca {
	private char coluna;
	private int linha;
	private char colunax;
	private int linhax;
	private String tipo;
	public PosicaoDaPeca(char coluna, int linha) {
		if(coluna < 'a'|| coluna > 'h' || linha < 1 || linha > 8  ) {
			throw new PartidaExcecao("Erro de instanciamento. Valores válidos são de a1 até h8");
		}
		this.coluna = coluna;
		this.linha = linha;
	}
	public PosicaoDaPeca(char coluna, int linha, char colunax, int linhax, String tipo) {
	       this.coluna=coluna;
	       this.linha=linha;
	       this.colunax=colunax;
	       this.linhax=linhax;
	       this.tipo=tipo;
	}
	public PosicaoDaPeca(char coluna, int linha,  String tipo) {
	       this.coluna=coluna;
	       this.linha=linha;
	       this.tipo=tipo;
	}
	public char getColuna() {
		return coluna;
	}
	public int getLinha() {
		return linha;
	}
	public char getColunax() {
		return colunax;
	}
	public int getLinhax() {
		return linhax;
	}
	public String getTipo() {
		return tipo;
	}
	protected Posicao paraPosicao() { 
		return new Posicao(8 - linha, coluna - 'a' );
	}
	protected Posicao paraPosicaoCapturada() {
		return new Posicao(8-linha, coluna - 'a', tipo);
	}
	protected static PosicaoDaPeca daPosicao(Posicao posicao) {
		return new PosicaoDaPeca ((char) ('a' - posicao.getColuna()), 8 - posicao.getLinha());
		
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
}
