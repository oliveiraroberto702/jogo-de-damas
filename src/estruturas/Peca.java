package estruturas;

public abstract class Peca {
	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null; // desnecessário
	}
	
	protected Tabuleiro getTabuleiro() {  // somente subclasses e classes do mesmpo pacote
		return tabuleiro;
	}
	
	public abstract boolean [][] possiveisMovimentos();
	
	public boolean possivelMovimento(Posicao posicao) {  // método concreto que chama uma possivel implementação de um metodo abstrato através de um subclasse concreta
		return possiveisMovimentos()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean existeAlgumMovimentoPossivel() {
		boolean [][] mat = possiveisMovimentos();
		for(int i=0; i<mat.length;i++) {
			for (int j=0;j<mat.length;j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
