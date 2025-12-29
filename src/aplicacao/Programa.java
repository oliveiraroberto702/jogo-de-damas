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
					origem.getLinha(), origem.getColuna(), tipo);
				    PecaDaPartida pecaCapturada = partidaDeDamas.performaMovimentoDaPartida(origem, destino, destinoCapturada);
				    if (pecaCapturada != null) {
					   capturada.add(pecaCapturada);
					   System.out.println(partidaDeDamas.capturaAtivada); //
					   boolean[][] pec = possiveisMovimentos;
					   System.out.println("--------------------------------------------");
					   int ntrue = 0;
					   for (int i = 0; i < pec.length; i++) {
						   for (int j = 0; j < pec.length; j++) {
							   System.out.print(pec[i][j] + "  ");
							   if (pec[i][j] == true) {
								   ntrue++;
								   							   }
						   }
						   System.out.println();
					   }
					   System.out.println();
					   if (ntrue == 2  || ntrue==3) {
						   
						   origem=destino;
						   zonaCapturada=true;
						   dirCap=partidaDeDamas.capturaAtivada.substring(5,7);
						  					  
						   if (dirCap.equals("nw")) {
						       linhacap=(8-Integer.parseInt(partidaDeDamas.capturaAtivada.substring(4,5)))-1;
						       colunacap=(partidaDeDamas.capturaAtivada.charAt(3) - 'a')-1;
						   }
						   if (dirCap.equals("ne")) {
						       linhacap=(8-Integer.parseInt(partidaDeDamas.capturaAtivada.substring(4,5)))-1;
						       colunacap=(partidaDeDamas.capturaAtivada.charAt(3) - 'a')+1;
						   }
						   if (dirCap.equals("sw")) {
						       linhacap=(8-Integer.parseInt(partidaDeDamas.capturaAtivada.substring(4,5)))+1;
						       colunacap=(partidaDeDamas.capturaAtivada.charAt(3) - 'a')-1;
						   }
						   if (dirCap.equals("se")) {
						       linhacap=(8-Integer.parseInt(partidaDeDamas.capturaAtivada.substring(4,5)))+1;
						       colunacap=(partidaDeDamas.capturaAtivada.charAt(3) - 'a')+1;
						   }
						   pec[linhacap][colunacap] = false;
						   if(partidaDeDamas.getJogadorCorrente()==Cor.RED && dirCap.equals("nw")) {
							   colunacap=colunacap+4;
							   if(pec[linhacap][colunacap]==true) {
								   pec[linhacap][colunacap]=false;
								   partidaDeDamas.proximoTurno();
								   zonaCapturada=true;
							   }
						   }
						   if(partidaDeDamas.getJogadorCorrente()==Cor.RED && dirCap.equals("ne")) {
							   colunacap=colunacap-4;
							   if(pec[linhacap][colunacap]==true) {
								   pec[linhacap][colunacap]=false;
								   partidaDeDamas.proximoTurno();
								   zonaCapturada=false;
							   }
						   }
						   if(partidaDeDamas.getJogadorCorrente()==Cor.BLACK && dirCap.equals("sw")) {
							   colunacap=colunacap+4;
							   if(pec[linhacap][colunacap]==true) {
								   pec[linhacap][colunacap]=false;
								   partidaDeDamas.proximoTurno();
								   zonaCapturada=false;
							   }
						   }
						   if(partidaDeDamas.getJogadorCorrente()==Cor.BLACK && dirCap.equals("se")) {
							   colunacap=colunacap-4;
							   if(pec[linhacap][colunacap]==true) {
								   pec[linhacap][colunacap]=false;
								   partidaDeDamas.proximoTurno();
								   zonaCapturada=false;
							   }
						   }	
					   } else {
						   partidaDeDamas.proximoTurno();
						   
					   }
					   System.out.println(partidaDeDamas.getJogadorCorrente());
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
