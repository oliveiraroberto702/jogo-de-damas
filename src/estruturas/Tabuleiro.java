package estruturas;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peca [] [] pecas;
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroExcecao("Erro na criacao de o tabuleiro: deve ter pelos menos 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca [linhas][colunas];  // matriz de peças
		
	}
	public int getLinhas() {
		return linhas;
	}
	public int getColunas() {
		return colunas;
	}
	
	// as peças irão ter "gets" com métodos específico que não irão retornar uma matriz inteira e sim uma peça por vez
	
	public Peca peca(int linha, int coluna) {
		if(!existePosicao(linha, coluna) ) {
			throw new TabuleiroExcecao("Posição externa ao tabuleiro");
		}
		return pecas[linha][coluna]; 
	}
	public Peca peca(Posicao posicao) {
		if(!existePosicao(posicao) ) {
			throw new TabuleiroExcecao("Posição externa ao tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	public void colocaPeca(Peca peca, Posicao posicao) {
	    if((posicao.getLinha()%2 == 0 && posicao.getColuna()%2 == 0) || (posicao.getLinha()%2 != 0 && posicao.getColuna()%2 != 0)) {
	    	throw new TabuleiroExcecao("Posição de origem sem peça");
		}
		if(haUmaPeca(posicao)) {
			throw new TabuleiroExcecao("Já existe umaa peça nesta posição " + posicao);
		}
		
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;     
	}
	public Peca removePeca(Posicao posicao) {
		if(!existePosicao(posicao)) {
			throw new TabuleiroExcecao("Posição externa ao tabuleiro");
		}
		if(peca(posicao) == null ) {
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}
	public boolean existePosicao(int linha, int coluna) {
		 return linha >= 0 && linha < linhas && coluna >=0 && coluna < colunas;
	}
	public boolean existePosicao(Posicao posicao) {
		return existePosicao(posicao.getLinha(), posicao.getColuna());
						
	}
	public boolean haUmaPeca(Posicao posicao) {
		if(!existePosicao(posicao) ) {
			throw new TabuleiroExcecao("Posição externa ao tabuleiro");
		}
		return peca(posicao) != null;
	}
	
}
