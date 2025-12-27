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
				String tipo = null;
				char colunaCap = 'a';//
				int linhaCap = 0;//

				UI.limpaTela();
				UI.imprimePartida(partidaDeDamas, capturada);
				System.out.println();
				System.out.print("Origem: ");
				// if (!partidaDeDamas.turnoNaoMuda) {
				PosicaoDaPeca origem = UI.lerPosicionamentoDasPecas(sc);
				// } else {
				// PosicaoDaPeca origem = new PosicaoDaPeca(colunaCap, linhaCap);
				// }

				boolean[][] possiveisMovimentos = partidaDeDamas.possiveisMovimentos(origem);

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
				PecaDaPartida pecaCapturada = partidaDeDamas.performaMovimentoDaPartida(origem, destino,
						destinoCapturada);
				if (pecaCapturada != null) {
					capturada.add(pecaCapturada);
					System.out.println(partidaDeDamas.capturaAtivada); //
					linhaCap = 8 - Integer.parseInt(partidaDeDamas.capturaAtivada.substring(4, 5));
					colunaCap = partidaDeDamas.capturaAtivada.charAt(3);
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

					if (ntrue != 2) {
						partidaDeDamas.proximoTurno(); //

					}

					String dirCap = partidaDeDamas.capturaAtivada.substring(5);
					System.out.println(linhaCap + "," + colunaCap + "  -  " + dirCap);
					System.out.println(partidaDeDamas.getJogadorCorrente());
				}

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
