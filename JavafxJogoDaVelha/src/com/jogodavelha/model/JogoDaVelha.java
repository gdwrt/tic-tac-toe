package com.jogodavelha.model;

import java.util.Random;

public class JogoDaVelha {

	private static char opcaoEscolhida = '1';
	private static char[][] tabelaJogo = new char[3][3];

	public static char[][] getTabelaJogo() {
		return tabelaJogo;
	}

	public static void setTabelaJogo(char[][] tabelaJogo) {
		JogoDaVelha.tabelaJogo = tabelaJogo;
	}

	public static char getOpcaoEscolhida() {
		return opcaoEscolhida;
	}

	public static void setOpcaoEscolhida(char opcaoEscolhida) {
		JogoDaVelha.opcaoEscolhida = opcaoEscolhida;
	}

	public static int validarJogo() {
		// vertical
		for (int y = 0; y < 3; y++) {
			if (tabelaJogo[0][y] == tabelaJogo[1][y] && tabelaJogo[0][y] == tabelaJogo[2][y]
					&& tabelaJogo[0][y] != '1') {
				return 1;
			}
		}
		// horizontal
		for (int x = 0; x < 3; x++) {
			if (tabelaJogo[x][0] == tabelaJogo[x][1] && tabelaJogo[x][0] == tabelaJogo[x][2]
					&& tabelaJogo[x][0] != '1') {
				return 1;
			}
		}
		// diagonal
		if (tabelaJogo[0][0] == tabelaJogo[1][1] && tabelaJogo[0][0] == tabelaJogo[2][2] && tabelaJogo[0][0] != '1') {
			return 1;
		} else if (tabelaJogo[2][0] == tabelaJogo[1][1] && tabelaJogo[2][0] == tabelaJogo[0][2]
				&& tabelaJogo[2][0] != '1') {
			return 1;
		}
		return 0;
	}

	public static int gerarJogadaCumputador() {
		
		int achei = 0;
		
		for(int i=0; i<tabelaJogo.length; ++i)
			for(int j=0; j<tabelaJogo.length; ++j)
				if(tabelaJogo[i][j] == '1')
					achei++;
		
		if(achei == 0){
			return 10;
		}
				 
		
		boolean jogadaSorteada = false;
		Random r = new Random();
		int x = 4;
		int y = 4;
		
		while (jogadaSorteada == false) {
			 x = r.nextInt(3);
			 y = r.nextInt(3);
			 System.out.println(x+"  "+y); 
			if (tabelaJogo[x][y] == '1') {
				if (opcaoEscolhida == 'X') {
					tabelaJogo[x][y] = 'O';
					jogadaSorteada = true;
				} else {
					tabelaJogo[x][y] = 'X';
					jogadaSorteada = true;
				}		
			}
		}
		if(x == 0 && y == 0)
			return 1;
		else if(x == 0 && y == 1)
			return 2;
		else if(x == 0 && y == 2)
			return 3;
		else if(x == 1 && y == 0)
			return 4;
		else if(x == 1 && y == 1)
			return 5;
		else if(x == 1 && y == 2)
			return 6;
		else if(x == 2 && y == 0)
			return 7;
		else if(x == 2 && y == 1)
			return 8;
		else if(x == 2 && y == 2)
			return 9;
		else {
			return 10;
		}
	}
	public static int counterStrikeComputador(){
		
		//horizontal
		if(tabelaJogo[0][0] == tabelaJogo[0][1] && tabelaJogo[0][0] != '1' && tabelaJogo[0][2] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[0][2] = 'O';
				return 3;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[0][2] = 'X';
				return 3;
			}
			return 11;
			
		} else if(tabelaJogo[0][0] == tabelaJogo[0][2] && tabelaJogo[0][0] != '1' && tabelaJogo[0][1] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[0][1] = 'O';
				return 2;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[0][1] = 'X';
				return 2;
			}
			return 11;
			
		} else if(tabelaJogo[0][1] == tabelaJogo[0][2] && tabelaJogo[0][1] != '1' && tabelaJogo[0][0] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[0][0] = 'O';
				return 1;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[0][0] = 'X';
				return 1;
			}
			return 11;
			
		} 
		
		else if(tabelaJogo[1][0] == tabelaJogo[1][1] && tabelaJogo[1][0] != '1' && tabelaJogo[1][2] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[1][2] = 'O';
				return 6;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[1][2] = 'X';
				return 6;
			}
			return 11;
			
		} else if(tabelaJogo[1][0] == tabelaJogo[1][2] && tabelaJogo[1][0] != '1' && tabelaJogo[1][1] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[1][1] = 'O';
				return 5;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[1][1] = 'X';
				return 5;
			}
			return 11;
			
		} else if(tabelaJogo[1][1] == tabelaJogo[1][2] && tabelaJogo[1][1] != '1' && tabelaJogo[1][0] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[1][0] = 'O';
				return 4;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[1][0] = 'X';
				return 4;
			}
			return 11;
			
		}
		
		
		else if(tabelaJogo[2][0] == tabelaJogo[2][1] && tabelaJogo[2][0] != '1' && tabelaJogo[2][2] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[2][2] = 'O';
				return 9;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[2][2] = 'X';
				return 9;
			}
			return 11;
			
		} else if (tabelaJogo[2][0] == tabelaJogo[2][2] && tabelaJogo[2][0] != '1' && tabelaJogo[2][1] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[2][1] = 'O';
				return 8;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[2][1] = 'X';
				return 8;
			}
			return 11;
			
		} else if(tabelaJogo[2][1] == tabelaJogo[2][2] && tabelaJogo[2][1] != '1' && tabelaJogo[2][0] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[2][0] = 'O';
				return 7;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[2][0] = 'X';
				return 7;
			}
			return 11;
			
		}
		
		
		else if (tabelaJogo[0][0] == tabelaJogo[1][0] && tabelaJogo[0][0] != '1' && tabelaJogo[2][0] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[2][0] = 'O';
				return 7;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[2][0] = 'X';
				return 7;
			}
			return 11;
			
		} else if(tabelaJogo[0][0] == tabelaJogo[2][0] && tabelaJogo[0][0] != '1' && tabelaJogo[1][0] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[1][0] = 'O';
				return 4;
			} else if(opcaoEscolhida == 'X'){
				tabelaJogo[1][0] = 'X';
				return 4;
			}
			return 11;
			
		} else if(tabelaJogo[1][0] == tabelaJogo[2][0] && tabelaJogo[1][0] != '1' && tabelaJogo[0][0] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[0][0] = 'O';
				return 1;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[0][0] = 'X';
				return 1;
			}
			return 11;
			
		}
		
		else if(tabelaJogo[0][1] == tabelaJogo[1][1] && tabelaJogo[0][1] != '1' && tabelaJogo[2][1] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[2][1] = 'O';
				return 8;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[2][1] = 'X';
				return 8;
			}
			return 11;
			
			
		} else if (tabelaJogo[0][1] == tabelaJogo[2][1] && tabelaJogo[0][1] != '1' && tabelaJogo[1][1] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[1][1] = 'O';
				return 5;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[1][1] = 'X';
				return 5;
			}
			return 11;
			
		} else if(tabelaJogo[1][1] == tabelaJogo[2][1] && tabelaJogo[1][1] != '1' && tabelaJogo[0][1] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[0][1] = 'O';
				return 2;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[0][1] = 'X';
				return 2;
			}
			return 11;
			
		}
		
		
		else if(tabelaJogo[0][2] == tabelaJogo[1][2] && tabelaJogo[0][2] != '1' && tabelaJogo[2][2] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[2][2] = 'O';
				return 9;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[2][2] = 'O';
				return 9;
			}
			return 11;
			
		} else if(tabelaJogo[0][2] == tabelaJogo[2][2] && tabelaJogo[0][2] != '1' && tabelaJogo[1][2] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[1][2] = 'O';
				return 6;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[1][2] = 'X';
				return 6;
			}
			return 11;
			
		} else if(tabelaJogo[1][2] == tabelaJogo[2][2] && tabelaJogo[1][2] != '1' && tabelaJogo[0][2] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[0][2] = 'O';
				return 3;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[0][2] = 'X';
				return 3;
			}
			return 11;
			
		}
		
		else if(tabelaJogo[0][0] == tabelaJogo[1][1] && tabelaJogo[0][0] != '1' && tabelaJogo[2][2] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[2][2] = 'O';
				return 9;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[2][2] = 'X';
				return 9;
			}
			return 11;
			
		} else if(tabelaJogo[0][0] == tabelaJogo[2][2] && tabelaJogo[0][0] != '1' && tabelaJogo[1][1] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[1][1] = 'O';
				return 5;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[1][1] = 'X';
				return 5;
			}
			return 11;
			
		} else if(tabelaJogo[1][1] == tabelaJogo[2][2] && tabelaJogo[1][1] != '1' && tabelaJogo[0][0] == '1'){
			if(opcaoEscolhida == 'X'){
				tabelaJogo[0][0] = 'O';
				return 1;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[0][0] = 'X';
				return 1;
			}
			return 11;
		}
		
		
		else if (tabelaJogo[2][0] == tabelaJogo[1][1] && tabelaJogo[2][0] != '1' && tabelaJogo[0][2] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[0][2] = 'O';
				return 3;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[0][2] = 'X';
				return 3;
			}
			return 11;
			
		} else if (tabelaJogo[2][0] == tabelaJogo[0][2] && tabelaJogo[2][0] != '1' && tabelaJogo[1][1] == '1'){
			
			if(opcaoEscolhida == 'X'){
				tabelaJogo[1][1] = 'O';
				return 5;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[1][1] = 'X';
				return 5;
			}
			return 11;
			
		}else if(tabelaJogo[1][1] == tabelaJogo[0][2] && tabelaJogo[1][1] != '1' && tabelaJogo[2][0] == '1'){
			if(opcaoEscolhida == 'X'){
				tabelaJogo[2][0] = 'O';
				return 7;
			} else if(opcaoEscolhida == 'O'){
				tabelaJogo[2][0] = 'X';
				return 7;
			}
			return 11;
		} else {
			return 11;
		}
		
		
	}

}
