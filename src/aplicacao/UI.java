package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import partida.Cor;
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

	public static PosicaoDaPeca lerPosicionamentoDasPecas(Scanner sc) {
		
	    try {
			String s =sc.nextLine();
			char coluna =s.charAt(0);
			int linha =Integer.parseInt(s.substring(1));
			return new PosicaoDaPeca(coluna,linha);
	    }
	    catch (RuntimeException e) {
	    	throw new InputMismatchException ("Erro de leitura na PosicaoDaPeca. Valores válidos são de a1 até h8.");
	    }
	}	
	
	public static void montaTabuleiro(PecaDaPartida[][] pecas) {
		int nblack=0;
		int nwhite=0;
		int row = 0;
		int col=0;
		for (int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pecas.length; j++) {
				if (nblack == nwhite) {
				   nblack++;
				} else {
				    nwhite++;
				}
				imprimePeca(pecas[i][j], nblack, nwhite, row, col);
				col++;
			}
			System.out.println();
			row++;
			
		}
		System.out.println("   a  b  c  d  e  f  g  h");
	}

	private static void imprimePeca(PecaDaPartida peca, int nblack, int nwhite, int row, int col) { // imprime uma única peça
		if (peca == null) {
			if (nblack != nwhite) {
				if(row%2 ==0 ) {
					System.out.print(ANSI_YELLOW_BACKGROUND + "   " + ANSI_RESET);
				} else {
					System.out.print(ANSI_WHITE_BACKGROUND + "   " + ANSI_RESET);
				}
			} else  {
				 if(row%2 ==0 ) {
				 		System.out.print(ANSI_WHITE_BACKGROUND + "   " + ANSI_RESET);
				 } else {
			 			System.out.print(ANSI_YELLOW_BACKGROUND + "   " + ANSI_RESET);
			 	 }
			}
			
		} else {
		    if(peca.getCor() == Cor.WHITE ) {
		    	if ((row  == 0  || row == 2 || row == 4 || row == 6) && col%2 == 0) { 
		    		System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_GREEN + " " + peca + " " + ANSI_RESET);
		    	} else if (	(row == 0 || row == 2 || row == 4 || row == 6) && col%2  != 0) {
		    		System.out.print(ANSI_WHITE_BACKGROUND + ANSI_GREEN + " " + peca + " " + ANSI_RESET);
		    	} else if (( row == 1 || row == 3 || row == 5 || row == 7) && col%2 == 0) {
		    		System.out.print(ANSI_WHITE_BACKGROUND + ANSI_GREEN + " " + peca + " " + ANSI_RESET);
		    	}  else if (( row == 1 || row == 3 || row == 5 || row == 7) && col%2 != 0) {
		    		System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_GREEN + " " + peca + " " + ANSI_RESET);
		    	}
		     } else {
		    	 if ((row  == 0  || row == 2 || row == 4 || row == 6) && col%2 == 0) { 
		    		System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_RED + " " + peca + " " + ANSI_RESET);
		    	 } else if (	(row == 0 || row == 2 || row == 4 || row == 6) && col%2  != 0) {
		    		System.out.print(ANSI_WHITE_BACKGROUND + ANSI_RED + " " + peca + " " + ANSI_RESET);
		    	 } else if (( row == 1 || row == 3 || row == 5 || row == 7) && col%2 == 0) {
		    		System.out.print(ANSI_WHITE_BACKGROUND + ANSI_RED + " " + peca + " " + ANSI_RESET);
		    	 }  else if (( row == 1 || row == 3 || row == 5 || row == 7) && col%2 != 0) {
		    		System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_RED + " " +  peca + " " + ANSI_RESET);
		    	 }  
		    }
		}    	  
		    	  
		 
		//System.out.print(" ");
		      
	}


}