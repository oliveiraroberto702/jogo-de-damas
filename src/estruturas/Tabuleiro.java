package estruturas;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peca [] [] pecas;
	public Tabuleiro(int linhas, int colunas) {
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
}
