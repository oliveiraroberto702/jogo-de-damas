package partida.pecas;

import java.awt.Color;

import estruturas.Posicao;
import estruturas.Tabuleiro;
import partida.Cor;
import partida.PecaDaPartida;

public class Peao extends PecaDaPartida {

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);

	}

	@Override
	public String toString() {
		return "peão";
	}
	
	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0,0);
		if (getCor() == Cor.RED) {
			//nw
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);	
			if(getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] =true;
				
			} else {
				if (getTabuleiro().existePosicao(p) &&  existePecaOponente(p)) {
					p.setValores(posicao.getLinha() - 2, posicao.getColuna() - 2);	
					if (getTabuleiro().existePosicao(p)) {
					   mat[p.getLinha()][p.getColuna()] =true;
					}   
				}
			}
			 
			//ne
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() +1);
			if(getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] =true;
				
			} else {
				if (getTabuleiro().existePosicao(p) &&  existePecaOponente(p)) {
					p.setValores(posicao.getLinha() - 2, posicao.getColuna() +2);
					if (getTabuleiro().existePosicao(p)) {
						mat[p.getLinha()][p.getColuna()] =true;
					}	
				}
			}
		} else {	
			//sw
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);	
			if(getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] =true;
				
			} else {
				if (getTabuleiro().existePosicao(p) &&  existePecaOponente(p)) {
					p.setValores(posicao.getLinha() +2, posicao.getColuna() - 2);	
					if (getTabuleiro().existePosicao(p)) {
						mat[p.getLinha()][p.getColuna()] =true;
					}	
				}
			}
			//se
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);	
			if(getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] =true;
				
			} else {
				if (getTabuleiro().existePosicao(p) &&  existePecaOponente(p)) {
					p.setValores(posicao.getLinha() +2, posicao.getColuna() + 2);
					if (getTabuleiro().existePosicao(p)) {
						mat[p.getLinha()][p.getColuna()] =true;
					}	
				}
			}
			
					
		}
		
		return mat;
	}
	
}
