package partida;

import estruturas.Posicao;
import estruturas.Tabuleiro;
import partida.pecas.Dama;
import partida.pecas.Peao;

public class PartidaDeDamas {
	private Tabuleiro tabuleiro;
	
	public PartidaDeDamas() {
		tabuleiro = new Tabuleiro(8,8); // aqui é que se define que o tabuleiro tem que ser 8 x 8
		cargaInicial();
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
	private void cargaInicial() {
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (2,1));
		tabuleiro.colocaPeca(new Dama(tabuleiro, Cor.BLACK), new Posicao (0,4));
		tabuleiro.colocaPeca(new Dama(tabuleiro, Cor.WHITE), new Posicao (7,4));
	}
}
