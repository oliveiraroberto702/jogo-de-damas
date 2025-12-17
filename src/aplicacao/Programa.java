package aplicacao;

import java.util.Scanner;

import partida.PartidaDeDamas;
import partida.PecaDaPartida;
import partida.PosicaoDaPeca;

class Programa {
	
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 PartidaDeDamas partidaDeDamas = new PartidaDeDamas();
		 
		 while (true) {
			 UI.montaTabuleiro(partidaDeDamas.getPecas());
			 System.out.println();
			 System.out.print("Origem: ");
			 PosicaoDaPeca origem = UI.lerPosicionamentoDasPecas(sc);
			 
			 System.out.println();
			 System.out.print("Destino: ");
			 PosicaoDaPeca destino = UI.lerPosicionamentoDasPecas(sc);
			 
			 PecaDaPartida pecaComida = partidaDeDamas.performaMovimentoDaPartida(origem, destino);
		 } 
			 
		 
		
	}
}
