package estruturas;

public class Posicao {
	private int linha;
	private int coluna;
	private String tipo;
	public Posicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	public Posicao(int linha, int coluna, String tipo) {
		this.linha=linha;
		this.coluna=linha;
		this.tipo=tipo;
	}
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	public void setValores(int linha, int coluna) {
		this.linha = linha;
		this.coluna=coluna;
	}
	public void setValoresCompleto(int linha, int coluna, String tipo) {
		this.linha=linha;
		this.coluna=coluna;
		this.tipo=tipo;
	}
	@Override
	public String toString() {
		return linha +", " + coluna;
	}
}
