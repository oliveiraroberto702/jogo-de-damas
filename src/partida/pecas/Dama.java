package partida.pecas;

import estruturas.Posicao;
import estruturas.Tabuleiro;
import partida.Cor;
import partida.PecaDaPartida;

public class Dama extends PecaDaPartida{
    public Dama(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	
	}
	@Override
	public String toString() {
			return "DAMA";
	}
	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao p = new Posicao(0,0);
		if (getCor() == Cor.RED) {
			//nw
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
			while (getTabuleiro().existePosicao(p) &&!getTabuleiro().haUmaPeca(p)) {
				
				mat[p.getLinha()][p.getColuna()] = true;
				p.setValores(p.getLinha()-1,p.getColuna()-1);
			}
			
			
			//ne
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() +1);
			while (getTabuleiro().existePosicao(p) &&!getTabuleiro().haUmaPeca(p)) {
				
				mat[p.getLinha()][p.getColuna()] = true;
				p.setValores(p.getLinha()-1,p.getColuna()+1);
			}
			
		
			//sw
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
			while (getTabuleiro().existePosicao(p) &&!getTabuleiro().haUmaPeca(p)) {
				
				mat[p.getLinha()][p.getColuna()] = true;
				p.setValores(p.getLinha() + 1,p.getColuna() - 1);
			}
			
			
					
			//se
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
			while (getTabuleiro().existePosicao(p) &&!getTabuleiro().haUmaPeca(p)) {
				
				mat[p.getLinha()][p.getColuna()] = true;
				p.setValores(p.getLinha() + 1,p.getColuna() + 1);
			}
			
		
			
			
			
			
			
		}
		
		return mat;
	}

}
