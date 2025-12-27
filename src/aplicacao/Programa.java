package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import estruturas.Peca;
import estruturas.Posicao;
import partida.Cor;
import partida.PartidaDeDamas;
import partida.PartidaExcecao;
import partida.PecaDaPartida;
import partida.PosicaoDaPeca;

class Programa {
	
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 PartidaDeDamas partidaDeDamas = new PartidaDeDamas();
		 List<PecaDaPartida> capturada = new ArrayList<>();
				 

		 while (true) {
			 try {
			     String tipo=null;
				 UI.limpaTela();
				 UI.imprimePartida(partidaDeDamas, capturada);
				 System.out.println();
				 System.out.print("Origem: ");
				 PosicaoDaPeca origem = UI.lerPosicionamentoDasPecas(sc);
				 
				 boolean [][] possiveisMovimentos = partidaDeDamas.possiveisMovimentos(origem);
				
			    UI.limpaTela();
						 
				 UI.montaTabuleiro(partidaDeDamas.getPecas(), possiveisMovimentos);
				 System.out.println("Turno: " + partidaDeDamas.getTurno());
				 System.out.println("Aguardando jogador: "+ partidaDeDamas.getJogadorCorrente());
				 System.out.print("Origem: " + origem);
				 System.out.println();
				 System.out.print("Destino: ");
				 PosicaoDaPeca destino = UI.lerPosicionamentoDasPecas(sc);
				
				 PosicaoDaPeca destinoCapturada =UI.posicaoPecaCapturada(partidaDeDamas, possiveisMovimentos, origem.getLinha(), origem.getColuna(), tipo); 
				 PecaDaPartida pecaCapturada = partidaDeDamas.performaMovimentoDaPartida(origem, destino, destinoCapturada); 
				 if(pecaCapturada != null) {
					capturada.add(pecaCapturada); 
					System.out.println(partidaDeDamas.capturaAtivada); //
					System.out.println(partidaDeDamas.getJogadorCorrente());
					
				 }
				
		 
			 }	
			 catch(PartidaExcecao e) {
				 System.out.println(e.getMessage());
				 sc.nextLine();
			 }
			 catch(InputMismatchException e) {
				 System.out.println(e.getMessage());
				 sc.nextLine();
			 }
		 } 
			 
		 
		
	}
}
