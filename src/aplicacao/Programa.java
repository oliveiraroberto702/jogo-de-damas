package aplicacao;

import partida.PartidaDeDamas;

class Programa {
	
	 public static void main(String[] args) {
		
		 PartidaDeDamas partidaDeDamas = new PartidaDeDamas();
		 UI.montaTabuleiro(partidaDeDamas.getPecas());
		 
		
	}
}
