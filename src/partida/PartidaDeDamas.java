package partida;

import java.util.ArrayList;
import java.util.List;

import estruturas.Peca;
import estruturas.Posicao;
import estruturas.Tabuleiro;
import partida.pecas.Dama;
import partida.pecas.Peao;

public class PartidaDeDamas {
	private int turno;
	private Cor jogadorCorrente;
	private Tabuleiro tabuleiro;
	public String capturaAtivada; // meu
	public boolean turnoNaoMuda;// meu
	private List<Peca> pecasNoTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();
	
	public PartidaDeDamas() {
		tabuleiro = new Tabuleiro(8,8); // aqui é que se define que o tabuleiro tem que ser 8 x 8
		turno=1;
		turnoNaoMuda=true; //
		jogadorCorrente= Cor.RED;
		cargaInicial();
	}
	
	public int getTurno() {
		return turno;	
	}
	
	public Cor getJogadorCorrente() {
		return jogadorCorrente;
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
	public boolean [][] possiveisMovimentos(PosicaoDaPeca posicaoDeOrigem) {
		Posicao posicao = posicaoDeOrigem.paraPosicao();
		validarPosicaoOrigem(posicao);
		return tabuleiro.peca(posicao).possiveisMovimentos();
	}
	public PecaDaPartida performaMovimentoDaPartida(PosicaoDaPeca posicaoOrigem, PosicaoDaPeca posicaoDestino, PosicaoDaPeca posicaoCapturada) {
		Posicao origem = posicaoOrigem.paraPosicao();
		Posicao destino = posicaoDestino.paraPosicao();
		Posicao capturada=posicaoCapturada.paraPosicao();
		
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino, destino); //destino
		Peca  pecaCapturada = fazMovimento(origem, destino, capturada);
		
		
		//meu
		String s="peão";
		
		PecaDaPartida [][] pec = getPecas();
		if ((getJogadorCorrente() == Cor.RED && destino.getLinha() ==0 || getJogadorCorrente() == Cor.BLACK && destino.getLinha() ==7 ) && s.equals(pec[destino.getLinha()][destino.getColuna()].toString())) {
		   	Peca p =tabuleiro.removePeca(destino);
		   	if (getJogadorCorrente() == Cor.RED) {
		   		colocaNovaPeca((char) ('a' +destino.getColuna()),8 - destino.getLinha() , new Dama(tabuleiro, Cor.RED));
		   	} else {
		   		colocaNovaPeca((char) ('a' +destino.getColuna()),8 - destino.getLinha() , new Dama(tabuleiro, Cor.BLACK));
		   	}
		}
				
		// meu
		
		if(posicaoCapturada.getTipo() != null) {
			if (!(posicaoCapturada.getTipo().substring(0,3)).equals("sim")) {
				turnoNaoMuda=false;
				proximoTurno();
				
			}	
			capturaAtivada=posicaoCapturada.getTipo().substring(0,3) + posicaoCapturada.getTipo().substring(3);//
			turnoNaoMuda=true;
			
		}  else {
			turnoNaoMuda=false;
			proximoTurno();
		}
		return (PecaDaPartida) pecaCapturada;
		
	}
	
	private Peca fazMovimento(Posicao origem, Posicao destino, Posicao destinoCapturada) {
			
		Peca p =tabuleiro.removePeca(origem); 
		Peca pecaCapturada = tabuleiro.removePeca(destinoCapturada); 
		
		
		tabuleiro.colocaPeca(p, destino);
		
		if(pecaCapturada !=null) {
			pecasNoTabuleiro.remove(destino);
			pecasCapturadas.add(pecaCapturada);
		}
		return pecaCapturada;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if((posicao.getLinha()%2==0 && posicao.getColuna()%2==0) || (posicao.getLinha()%2!=0 && posicao.getColuna()%2!=0)) {
			throw new PartidaExcecao("Não existe peça na posição de origem");
		}
		if(!tabuleiro.haUmaPeca(posicao)) {
			throw new PartidaExcecao("Não existe peça na posição de origem");
		}
		if(jogadorCorrente != ((PecaDaPartida) tabuleiro.peca(posicao)).getCor()) { 
			throw new PartidaExcecao("A cor da peça escolhida não é a sua");
		}
		if(!tabuleiro.peca(posicao).existeAlgumMovimentoPossivel()) {
			throw new PartidaExcecao("Não há movimentos possíveis para a peça escolhida");
		}
		
	}
	
	private void validarPosicaoDestino(Posicao origem, Posicao destino, Posicao posicaoDestinoCapturada) {
		if(!tabuleiro.peca(origem).possivelMovimento(destino)) {
			throw new PartidaExcecao("A peça escolhida não pode movimentar-se para posição de destino");
		}
	}
	
	public void proximoTurno() { //private void proximoTurno() {
		turno++;
		jogadorCorrente = ((jogadorCorrente == Cor.RED) ? Cor.BLACK: Cor.RED);
		
	}
	private void colocaNovaPeca(char coluna, int linha, PecaDaPartida peca) {
		tabuleiro.colocaPeca(peca, new PosicaoDaPeca(coluna, linha).paraPosicao());
		pecasNoTabuleiro.add(peca);
	}
	private void cargaInicial() {
		
	   
		colocaNovaPeca('b',8, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('d',8, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('f',8, new Peao(tabuleiro, Cor.BLACK));  //f8
		colocaNovaPeca('h',8, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('b',6, new Peao(tabuleiro, Cor.BLACK)); //a7
	    colocaNovaPeca('c',7, new Peao(tabuleiro, Cor.BLACK)); 
		colocaNovaPeca('e',7, new Peao(tabuleiro, Cor.BLACK));
		colocaNovaPeca('g',7, new Peao(tabuleiro, Cor.BLACK)); 
		colocaNovaPeca('b',4, new Peao(tabuleiro, Cor.BLACK));  // b6
		colocaNovaPeca('d',4, new Peao(tabuleiro, Cor.BLACK));  // d6
		colocaNovaPeca('f',4, new Peao(tabuleiro, Cor.BLACK));  // f6
		colocaNovaPeca('h',6, new Peao(tabuleiro, Cor.BLACK));
		
		//colocaNovaPeca('e',5, new Peao(tabuleiro, Cor.RED)); //
	
		colocaNovaPeca('a',3, new Peao(tabuleiro, Cor.RED));  //A3
		colocaNovaPeca('c',3, new Peao(tabuleiro, Cor.RED));  //C3 
		colocaNovaPeca('e',3, new Peao(tabuleiro, Cor.RED));  //e3 
		colocaNovaPeca('g',3, new Peao(tabuleiro, Cor.RED));
		colocaNovaPeca('b',2, new Peao(tabuleiro, Cor.RED)); 
		colocaNovaPeca('d',2, new Peao(tabuleiro, Cor.RED));
		colocaNovaPeca('f',2, new Peao(tabuleiro, Cor.RED));
		colocaNovaPeca('h',2, new Peao(tabuleiro, Cor.RED));
		colocaNovaPeca('a',1, new Peao(tabuleiro, Cor.RED));
		colocaNovaPeca('c',1, new Peao(tabuleiro, Cor.RED));
		colocaNovaPeca('e',1, new Peao(tabuleiro, Cor.RED));
		colocaNovaPeca('g',1, new Peao(tabuleiro, Cor.RED));   
		
		
		
		
	}
}
