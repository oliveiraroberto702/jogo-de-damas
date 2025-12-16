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
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (0,0));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (0,1));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (0,2));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (0,3));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (0,4));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (0,5));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (0,6));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (0,7));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (1,0));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (1,1));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (1,2));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (1,3));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (1,4));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (1,5));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.WHITE), new Posicao (1,6));
		tabuleiro.colocaPeca(new Dama(tabuleiro, Cor.WHITE), new Posicao (1,7));
		
		tabuleiro.colocaPeca(new Dama(tabuleiro, Cor.BLACK), new Posicao (6,0));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (6,1));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (6,2));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (6,3));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (6,4));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (6,5));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (6,6));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (6,7));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (7,0));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (7,1));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (7,2));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (7,3));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (7,4));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (7,5));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (7,6));
		tabuleiro.colocaPeca(new Peao(tabuleiro, Cor.BLACK), new Posicao (7,7));
		
		
	}
}
