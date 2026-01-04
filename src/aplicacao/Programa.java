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
			int linhacap=0;
			int colunacap=0;
			String dirCap;
			try {
				String tipo = null;
				boolean zonaCapturada;
				UI.limpaTela();
				UI.imprimePartida(partidaDeDamas, capturada);
				System.out.println();
				System.out.print("Origem: ");
				PosicaoDaPeca origem = UI.lerPosicionamentoDasPecas(sc);
				boolean[][] possiveisMovimentos = partidaDeDamas.possiveisMovimentos(origem);
				do {
					zonaCapturada=false;
					UI.limpaTela();
					UI.montaTabuleiro(partidaDeDamas.getPecas(), possiveisMovimentos);
					System.out.println("Turno: " + partidaDeDamas.getTurno());
					System.out.println("Aguardando jogador: " + partidaDeDamas.getJogadorCorrente());
					System.out.print("Origem: " + origem);
					System.out.println();
					System.out.print("Destino: ");
					PosicaoDaPeca destino = UI.lerPosicionamentoDasPecas(sc);
					PosicaoDaPeca destinoCapturada = UI.posicaoPecaCapturada(partidaDeDamas, possiveisMovimentos,
					origem.getLinha(), origem.getColuna(),destino.getLinha(), destino.getColuna(), tipo);
					System.out.println("Origem:  " + origem+ "    destino: " + destino);
					System.out.println("Destino Capturada: " + destinoCapturada);
				    PecaDaPartida pecaCapturada = partidaDeDamas.performaMovimentoDaPartida(origem, destino, destinoCapturada);
				    System.out.println(partidaDeDamas.capturaAtivada);
				    if(partidaDeDamas.capturaAtivada.substring(0,3).equals("nao")) {
				       zonaCapturada=false;
				       partidaDeDamas.proximoTurno(); 
				    } else if (pecaCapturada != null) {
					     capturada.add(pecaCapturada);
					     System.out.println(partidaDeDamas.capturaAtivada); //
					     boolean [][] pec = possiveisMovimentos;
					     int ntrue=0;
					     for(int i=0; i<pec.length;i++) {
					    	 for(int j=0;j<pec.length;j++) {
					    		 if (pec[i][j] == true) {
					    			 ntrue++;
					    		 }
					    	 }
					     }
					     if(ntrue==0) {
					    	 zonaCapturada=false; //true;
					    	 partidaDeDamas.proximoTurno();
					     }	 else {
					    	 origem=destino;
					    	 zonaCapturada=true; //false;
					    	 //partidaDeDamas.proximoTurno();
					     }
					    	
				    }   
				
				} while (zonaCapturada);
            } catch (PartidaExcecao e) {
            	System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
				
		}

	}
}
