package partida;

import estruturas.Tabuleiro;

public class PartidaDeDamas {
	private Tabuleiro tabuleiro;
	
	public PartidaDeDamas() {
		tabuleiro = new Tabuleiro(8,8); // aqui é que se define que o tabuleiro tem que ser 8 x 8
	}

	public PecaDaPartida [][] getPecas() {
		
		PecaDaPartida[][] mat = new PecaDaPartida[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i=0; i<tabuleiro.getLinhas();i++) {
			for(int j=0; j<tabuleiro.getColunas();j++) {
				mat[i][j] =(PecaDaPartida) tabuleiro.peca(i, j);
					
			}
		}
		return mat;
    }
}
