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
		boolean ativou1=false, ativou2=false;
		if (getCor() == Cor.RED) {
			//nw
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);	
			if(getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] =true;
				ativou2=true;
			} else {
				if (getTabuleiro().existePosicao(p) &&  existePecaOponente(p)) {
					p.setValores(posicao.getLinha() - 2, posicao.getColuna() - 2);	
					if (getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
					   mat[p.getLinha()][p.getColuna()] =true;
					   ativou1=true; //meu
					   for(int i=3; i<mat.length;i+=2) {
						   p.setValores(posicao.getLinha() -i, posicao.getColuna() -i);
						   if (getTabuleiro().existePosicao(p) && getTabuleiro().haUmaPeca(p) && existePecaOponente(p)) {
							   p.setValores(posicao.getLinha() -i-1, posicao.getColuna() -i-1);
							   if (getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
								   mat[p.getLinha()][p.getColuna()] =true;
							   } else {
								   break;
							   }
						   }
					   }   
					}
				}	
			}
			 
			//ne
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() +1);
			if(getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
				if(!ativou1) {   // meu
			 	   mat[p.getLinha()][p.getColuna()] =true;
				}  //meu
			} else {
				if (getTabuleiro().existePosicao(p) &&  existePecaOponente(p)) {
					p.setValores(posicao.getLinha() - 2, posicao.getColuna() +2);
					if (getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
						mat[p.getLinha()][p.getColuna()] =true;
						if(ativou2) { //meu
							p.setValores(posicao.getLinha()-1,posicao.getColuna()-1); // meu
							if(getTabuleiro().existePosicao(p)) { //meu
								mat[p.getLinha()][p.getColuna()] =false; //meu
							} // meu	
						}
						for(int i=3;i<mat.length;i+=2) {
							p.setValores(posicao.getLinha() - i, posicao.getColuna() + i);
							if (getTabuleiro().existePosicao(p) && getTabuleiro().haUmaPeca(p) && existePecaOponente(p)) {
								p.setValores(posicao.getLinha() - i-1, posicao.getColuna() +i+1);
								if (getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
									mat[p.getLinha()][p.getColuna()] =true;
								}
							} else {
								break;
							}
						}	
					}	
				}
			}
		} else {	
			//sw
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);	
			if(getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] =true;
				ativou2=true;
			} else {
				if (getTabuleiro().existePosicao(p) &&  existePecaOponente(p)) {
					p.setValores(posicao.getLinha() +2, posicao.getColuna() - 2);	
					if (getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
						mat[p.getLinha()][p.getColuna()] =true;
						ativou1=true;
						for(int i=3;i<mat.length;i+=2) {
							p.setValores(posicao.getLinha() + i, posicao.getColuna() - i);
							if (getTabuleiro().existePosicao(p) && getTabuleiro().haUmaPeca(p) && existePecaOponente(p)) {
								p.setValores(posicao.getLinha() +i+1, posicao.getColuna() -i-1);
								if (getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
									mat[p.getLinha()][p.getColuna()] =true;
								}
							} else {
								break;
							}
						}
					}	
				}
			}
			//se
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);	
			if(getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
				if(!ativou1) {
					mat[p.getLinha()][p.getColuna()] =true;
				}
			} else {
				if (getTabuleiro().existePosicao(p) &&  existePecaOponente(p)) {
					p.setValores(posicao.getLinha() +2, posicao.getColuna() + 2);
					if (getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
						mat[p.getLinha()][p.getColuna()] =true;
						if(ativou2) {
							p.setValores(posicao.getLinha()+1, posicao.getColuna()-1);
							if(getTabuleiro().existePosicao(p)) {
								mat[p.getLinha()][p.getColuna()] =false;
							}	
						}
						for(int i=3;i<mat.length;i+=2) {
							p.setValores(posicao.getLinha() + i, posicao.getColuna() + i);
							if (getTabuleiro().existePosicao(p) && getTabuleiro().haUmaPeca(p) && existePecaOponente(p)) {
								p.setValores(posicao.getLinha() +i+1, posicao.getColuna() +i+1);
								if (getTabuleiro().existePosicao(p) && !getTabuleiro().haUmaPeca(p)) {
									mat[p.getLinha()][p.getColuna()] =true;
								}
							} else {
								break;
							}
						}	
					}
				}
			}
			
					
		}
		
		return mat;
	}
	
}
