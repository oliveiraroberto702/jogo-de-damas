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
		 boolean ativaCapturada=false; 
		 int linhaCapturada=0, colunaCapturada=0; //meu
		 
		 while (true) {
			 try {
				 UI.limpaTela();
				 UI.imprimePartida(partidaDeDamas, capturada);
				 System.out.println();
				 System.out.print("Origem: ");
				 PosicaoDaPeca origem = UI.lerPosicionamentoDasPecas(sc);
				 
				 boolean [][] possiveisMovimentos = partidaDeDamas.possiveisMovimentos(origem);
				//meu UI.limpaTela();
				// UI.montaTabuleiro(partidaDeDamas.getPecas(), possiveisMovimentos);
				 System.out.println();
				 System.out.print("Destino: ");
				 PosicaoDaPeca destino = UI.lerPosicionamentoDasPecas(sc);
				 //meu
				
				
				 PecaDaPartida [][] pec = partidaDeDamas.getPecas();
				
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
						
					}
					   
				 }
				 System.out.println();
				 System.out.print("Origem: " + origem);
				 
				 char orig_coluna=origem.getColuna();
				 int orig_linha=origem.getLinha();
					
				 int origLinha=8-orig_linha;
				 int origColuna=orig_coluna - 'a';
				
				 String s = "peão";
				 boolean a;
				 if (i2==0 && j2==0 ) {
					
					if(partidaDeDamas.getJogadorCorrente()==Cor.BLACK && s.equals(pec[origLinha][origColuna].toString()) && (Math.abs(i1-origLinha)==2)) {
						if (origColuna<j1) {
						    linhaCapturada=i1-1;
						    colunaCapturada=j1-1;
						    ativaCapturada=true;
						    						 
						} else if(origColuna>j1) {
							 linhaCapturada=i1-1;
					    	 colunaCapturada=j1+1;
					    	 ativaCapturada=true;
					    	 
						} 
					} else if(partidaDeDamas.getJogadorCorrente()==Cor.RED && s.equals(pec[origLinha][origColuna].toString()) && (Math.abs(i1-origLinha)==2)) {
						
	                     if (origColuna<j1)	{				
						    linhaCapturada=i1+1;
						    colunaCapturada=j1-1;
						    ativaCapturada=true;
						 } else if(origColuna>j1) {
	                    	 linhaCapturada=i1+1;
	                    	 colunaCapturada=j1+1;
	                    	 ativaCapturada=true;


	                     }	 
					}   
				
				} else if (i2 !=0 || j2 !=0) {
					if(partidaDeDamas.getJogadorCorrente()==Cor.BLACK && s.equals(pec[origLinha][origColuna].toString()) && (Math.abs(i1-origLinha)==2)) {
						if(origColuna<j1) {
							linhaCapturada=i1-1;
							colunaCapturada=j1-1;
							ativaCapturada=true;
							

				        } else if(origColuna>j1) {
						    linhaCapturada=i1-1;
							colunaCapturada=j1+1;
							ativaCapturada=true;
							

				        }
					} else	if(partidaDeDamas.getJogadorCorrente()==Cor.BLACK && s.equals(pec[origLinha][origColuna].toString()) && (Math.abs(i2-origLinha)==2)) {	
						   if(origColuna<j2) {
						      linhaCapturada=i2-1;
						      colunaCapturada=j2-1;
						      ativaCapturada=true;
						      

				            } else if(origColuna>j2) {
							  linhaCapturada=i2-1;
							  colunaCapturada=j2+1;
							  ativaCapturada=true;
							  
				            }
					} else if(partidaDeDamas.getJogadorCorrente()==Cor.RED && s.equals(pec[origLinha][origColuna].toString()) && (Math.abs(i1-origLinha)==2)) {
						
	                          if (origColuna<j1)	{				
						          linhaCapturada=i1+1;
						          colunaCapturada=j1-1;
						          ativaCapturada=true;
						          

	                          } else if(origColuna>j1) {
	                    	      linhaCapturada=i1+1;
	                    	      colunaCapturada=j1+1;
	                    	      ativaCapturada=true;
	                    	      

	                          }    
	                } else if(partidaDeDamas.getJogadorCorrente()==Cor.RED && s.equals(pec[origLinha][origColuna].toString()) && (Math.abs(i2-origLinha)==2)) {    	      
	                          if (origColuna<j2)	{				
					              linhaCapturada=i2+1;
					              colunaCapturada=j2-1;
					              ativaCapturada=true;
					              

                               } else if(origColuna>j2) {
                   	               linhaCapturada=i2+1;
                   	               colunaCapturada=j2+1;
                   	               ativaCapturada=true;
                   	            

                               }          
	                }          
				}              
			
				          
				
				
				
				
				PosicaoDaPeca destinoCapturada= new PosicaoDaPeca ((char) ('a' + colunaCapturada), 8 - linhaCapturada);
				
				/*				 
				 System.out.println();
				 System.out.print("Destino: ");
				 PosicaoDaPeca destino = UI.lerPosicionamentoDasPecas(sc);
				*/
					
				 PecaDaPartida pecaCapturada = partidaDeDamas.performaMovimentoDaPartida(origem, destino, destinoCapturada); 
				 if(pecaCapturada != null) {
					capturada.add(pecaCapturada); 
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
