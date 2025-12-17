package partida;

import estruturas.Peca;
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
	
	public PecaDaPartida performaMovimentoDaPartida(PosicaoDaPeca posicaoOrigem, PosicaoDaPeca posicaoDestino) {
		Posicao origem = posicaoOrigem.paraPosicao();
		Posicao destino = posicaoDestino.paraPosicao();
		validarPosicaoOrigem(origem);
		Peca  pecaComida = fazMovimento(origem, destino);
		return (PecaDaPartida) pecaComida;
		
	}
	
	private Peca fazMovimento(Posicao origem, Posicao destino) {
		Peca p =tabuleiro.removePeca(origem);
		Peca pecaComida = tabuleiro.removePeca(destino);
		tabuleiro.colocaPeca(p, destino);
		return pecaComida;
	}
	private void validarPosicaoOrigem(Posicao posicao) {
		if(!tabuleiro.haUmaPeca(posicao)) {
			throw new PartidaExcecao("Não existe peça na posição de origem");
		}
		
	}
	private void colocaNovaPeca(char coluna, int linha, PecaDaPartida peca) {
		tabuleiro.colocaPeca(peca, new PosicaoDaPeca(coluna, linha).paraPosicao());
		
	}
	private void cargaInicial() {
		
		colocaNovaPeca('a',8, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('b',8, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('c',8, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('d',8, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('e',8, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('f',8, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('g',8, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('h',8, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('a',7, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('b',7, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('c',7, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('d',7, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('e',7, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('f',7, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('g',7, new Peao(tabuleiro, Cor.WHITE));
		colocaNovaPeca('h',7, new Dama(tabuleiro, Cor.WHITE));
		
		colocaNovaPeca('a',2, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('b',2, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('c',2, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('d',2, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('e',2, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('f',2, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('g',2, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('h',2, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('a',1, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('b',1, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('c',1, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('d',1, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('e',1, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('f',1, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('g',1, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('h',1, new Dama(tabuleiro, Cor.BLACK));
		
		
		
	}
}
