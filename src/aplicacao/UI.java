package aplicacao;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import partida.Cor;
import partida.PartidaDeDamas;
import partida.PecaDaPartida;
import partida.PosicaoDaPeca;

public class UI {
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void limpaTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static PosicaoDaPeca lerPosicionamentoDasPecas(Scanner sc) {

		try {
			String s = sc.nextLine();
			char coluna = s.charAt(0);
			int linha = Integer.parseInt(s.substring(1));
			return new PosicaoDaPeca(coluna, linha);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Erro de leitura na PosicaoDaPeca. Valores válidos são de a1 até h8.");
		}
	}
	  
	public static void imprimePartida (PartidaDeDamas partidaDeDamas, List<PecaDaPartida> capturada) {
		montaTabuleiro(partidaDeDamas.getPecas());
		System.out.println();
		imprimePecaCapturada(capturada);
		System.out.println();
		System.out.println("Turno: " + partidaDeDamas.getTurno());
		System.out.println("Aguardando jogador: " + partidaDeDamas.getJogadorCorrente());
		 
	}
	public static void montaTabuleiro(PecaDaPartida[][] pecas) {
		int nblack = 0;
		int nwhite = 0;
		int row = 0;
		int col = 0;
		String espaco="                                        ";
		for (int i=0; i<10; i++) {
			System.out.println();
		}
		for (int i = 0; i < pecas.length; i++) {
			System.out.print(espaco+(8 - i) + " ");
			for (int j = 0; j < pecas.length; j++) {
				if (nblack == nwhite) {
					nblack++;
				} else {
					nwhite++;
				}
				imprimePeca(pecas[i][j], false, nblack, nwhite, row, col);
				col++;
			}
			System.out.println();
			row++;

		}
		System.out.println(espaco + "   a   b   c   d   e   f   g   h");
	}
	public static void montaTabuleiro(PecaDaPartida[][] pecas, boolean[][] possiveisMovimentos) {
		
		
		int nblack = 0;
		int nwhite = 0;
		int row = 0;
		int col = 0;
		String espaco="                                        ";
		for (int i=0; i<10; i++) {
			System.out.println();
		}
		for (int i = 0; i < pecas.length; i++) {
			System.out.print(espaco+ (8 - i) + " ");
			for (int j = 0; j < pecas.length; j++) {
				if (nblack == nwhite) {
					nblack++;
				} else {
					nwhite++;
				}
				imprimePeca(pecas[i][j], possiveisMovimentos[i][j], nblack, nwhite, row, col);
				col++;
			}
			System.out.println();
			row++;

		}
		System.out.println(espaco+"   a   b   c   d   e   f   g   h");
	}
	
	private static void imprimePeca(PecaDaPartida peca, boolean background, int nblack, int nwhite, int row, int col) { // imprime uma única
		
		if (peca == null) {
			if (nblack != nwhite) {
				if (row % 2 == 0) {
					System.out.print(ANSI_WHITE_BACKGROUND + "    " + ANSI_RESET);
				} else {
					if (!background) {
						System.out.print(ANSI_YELLOW_BACKGROUND + "    " + ANSI_RESET);	
					} else {
						System.out.print(ANSI_BLUE_BACKGROUND + "    " + ANSI_RESET);	
					}
					
				}	
			} else {
				if (row % 2 == 0) {
					
					if(!background) {
						System.out.print(ANSI_YELLOW_BACKGROUND + "    " + ANSI_RESET);
					} else {
						System.out.print(ANSI_BLUE_BACKGROUND + "    " + ANSI_RESET);
					}	
					
				} else {
					System.out.print(ANSI_WHITE_BACKGROUND + "    " + ANSI_RESET);
				}
				
			}

		} else {
			if (peca.getCor() == Cor.BLACK) {
				
				if ((row == 0 || row == 2 || row == 4 || row == 6) && col % 2 == 0) {
					System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + peca + ANSI_RESET);
				} else if ((row == 0 || row == 2 || row == 4 || row == 6) && col % 2 != 0) {
					System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + peca + ANSI_RESET);
				} else if ((row == 1 || row == 3 || row == 5 || row == 7) && col % 2 == 0) {
					System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + peca + ANSI_RESET);
				} else if ((row == 1 || row == 3 || row == 5 || row == 7) && col % 2 != 0) {
					System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + peca + ANSI_RESET);
				}
			} else {
				
				if ((row == 0 || row == 2 || row == 4 || row == 6) && col % 2 == 0) {
					System.out.print(ANSI_WHITE_BACKGROUND + ANSI_RED + peca + ANSI_RESET);
				} else if ((row == 0 || row == 2 || row == 4 || row == 6) && col % 2 != 0) {
					System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_RED + peca + ANSI_RESET);
				} else if ((row == 1 || row == 3 || row == 5 || row == 7) && col % 2 == 0) {
					System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_RED+ peca + ANSI_RESET);
				} else if ((row == 1 || row == 3 || row == 5 || row == 7) && col % 2 != 0) {
					System.out.print(ANSI_WHITE_BACKGROUND + ANSI_RED + peca + ANSI_RESET);
				}
			}
		}

		// System.out.print(" ");

	}
	private static void imprimePecaCapturada(List<PecaDaPartida> pecaCapturada) {
		List<PecaDaPartida> vermelha = pecaCapturada.stream().filter(x -> x.getCor()==Cor.RED).collect(Collectors.toList());
		List<PecaDaPartida> preta = pecaCapturada.stream().filter(x -> x.getCor()==Cor.BLACK).collect(Collectors.toList());
		System.out.println("Peças capturadas:");
		System.out.print("Vermelha: ");
		System.out.print(ANSI_RED);
		System.out.println(Arrays.toString(vermelha.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("Preta:");
		System.out.print(ANSI_RED);
		System.out.println(Arrays.toString(preta.toArray()));
		System.out.print(ANSI_RESET);
		
		
	}
	public static PosicaoDaPeca posicaoPecaCapturada(PartidaDeDamas partidaDeDamas, boolean[][] possiveisMovimentos, int origemlinha, char origemcoluna, String tipo) {

		PecaDaPartida [][] pec = partidaDeDamas.getPecas();
		int linhaCapturada=0;
		int colunaCapturada=0;
		String ativaCapturada=tipo;
		int i1=0, j1=0,i2=0,j2=0;
			 
		for (int i=0; i<possiveisMovimentos.length;i++) {
		for (int j=0; j<possiveisMovimentos.length;j++) {
				 
				if(possiveisMovimentos[i][j] == true) {
					if(i1==0 && j1==0) {
						i1=i;
						j1=j;
					} else {
						i2=i;
						j2=j;
					}
				}
				System.out.print(possiveisMovimentos[i][j] + " , ");	
			}
			System.out.println();
		}
	
		char orig_coluna=origemcoluna;
		int orig_linha=origemlinha;
			
		int origLinha=8-orig_linha;
		int origColuna=orig_coluna - 'a';
		
		String s = "peão";
		
		if (i2==0 && j2==0 ) {
			
			if(partidaDeDamas.getJogadorCorrente()==Cor.BLACK && s.equals(pec[origLinha][origColuna].toString()) && (Math.abs(i1-origLinha)==2)) {
				if (origColuna<j1) {
				    linhaCapturada=i1-1;
				    colunaCapturada=j1-1;
				    ativaCapturada="sim"+((char)('a' +colunaCapturada))+(8 - linhaCapturada)+"se"+orig_coluna+orig_linha;
				    						 
				} else if(origColuna>j1) {
					 linhaCapturada=i1-1;
			    	 colunaCapturada=j1+1;
			    	 ativaCapturada="sim"+((char)('a' +colunaCapturada))+(8 - linhaCapturada)+"sw"+orig_coluna+orig_linha;
			    	 
				} 
			} else if(partidaDeDamas.getJogadorCorrente()==Cor.RED && s.equals(pec[origLinha][origColuna].toString()) && (Math.abs(i1-origLinha)==2)) {
				
                if (origColuna<j1)	{				
				    linhaCapturada=i1+1;
				    colunaCapturada=j1-1;
				    ativaCapturada="sim"+((char)('a' +colunaCapturada))+(8 - linhaCapturada) +"ne"+orig_coluna+orig_linha;
				 } else if(origColuna>j1) {
               	 linhaCapturada=i1+1;
               	 colunaCapturada=j1+1;
               	 ativaCapturada="sim"+((char)('a' +colunaCapturada))+(8 - linhaCapturada) +"nw"+orig_coluna+orig_linha;


                }	 
			}   
		
		} else if (i2 !=0 || j2 !=0) {
			if(partidaDeDamas.getJogadorCorrente()==Cor.BLACK && s.equals(pec[origLinha][origColuna].toString()) && (Math.abs(i1-origLinha)==2)) {
				if(origColuna<j1) {
					linhaCapturada=i1-1;
					colunaCapturada=j1-1;
					ativaCapturada="sim"+((char)('a' +colunaCapturada))+(8 - linhaCapturada) +"se"+orig_coluna+orig_linha;
					

		        } else if(origColuna>j1) {
				    linhaCapturada=i1-1;
					colunaCapturada=j1+1;
					ativaCapturada="sim"+((char)('a' +colunaCapturada))+(8 - linhaCapturada) + "sw"+orig_coluna+orig_linha;
					

		        }
			} else	if(partidaDeDamas.getJogadorCorrente()==Cor.BLACK && s.equals(pec[origLinha][origColuna].toString()) && (Math.abs(i2-origLinha)==2)) {	
				   if(origColuna<j2) {
				      linhaCapturada=i2-1;
				      colunaCapturada=j2-1;
				      ativaCapturada="sim"+((char)('a' +colunaCapturada))+(8 - linhaCapturada) +"se"+orig_coluna+orig_linha;
				      

		            } else if(origColuna>j2) {
					  linhaCapturada=i2-1;
					  colunaCapturada=j2+1;
					  ativaCapturada="sim"+((char)('a' +colunaCapturada))+(8 - linhaCapturada)+"sw"+orig_coluna+orig_linha;
					  
		            }
			} else if(partidaDeDamas.getJogadorCorrente()==Cor.RED && s.equals(pec[origLinha][origColuna].toString()) && (Math.abs(i1-origLinha)==2)) {
				
                     if (origColuna<j1)	{				
				          linhaCapturada=i1+1;
				          colunaCapturada=j1-1;
				          ativaCapturada="sim"+((char)('a' +colunaCapturada))+(8 - linhaCapturada)+"ne"+orig_coluna+orig_linha;
				          

                     } else if(origColuna>j1) {
               	      linhaCapturada=i1+1;
               	      colunaCapturada=j1+1;
               	      ativaCapturada="sim"+((char)('a' +colunaCapturada))+(8 - linhaCapturada)+"nw"+orig_coluna+orig_linha;
               	      

                     }    
           } else if(partidaDeDamas.getJogadorCorrente()==Cor.RED && s.equals(pec[origLinha][origColuna].toString()) && (Math.abs(i2-origLinha)==2)) {    	      
                     if (origColuna<j2)	{				
			              linhaCapturada=i2+1;
			              colunaCapturada=j2-1;
			              ativaCapturada="sim"+((char)('a' +colunaCapturada))+(8 - linhaCapturada)+"ne"+orig_coluna+orig_linha;
			              

                      } else if(origColuna>j2) {
          	               linhaCapturada=i2+1;
          	               colunaCapturada=j2+1;
          	               ativaCapturada="sim"+((char)('a' +colunaCapturada))+(8 - linhaCapturada)+"nw"+orig_coluna+orig_linha;
          	            

                      }          
           }          
		}      
		
		System.out.println(ativaCapturada);
        return new PosicaoDaPeca((char)('a' +colunaCapturada),8 - linhaCapturada, ativaCapturada);	
        
	}
}