package application;

import chess.ChessPiece;

public class UI {
	
	//user interface - ser� criado o m�todo printBoard recebendo a matriz de pe�as da partida

	public static void printBoard(ChessPiece[][] pieces) {
		
		//vai percorrer toda a matriz e aplicar o m�todo de imprimir pe�as ou tracinhos em cada posi��o
		
		for(int i=0; i<pieces.length;i++) {
			System.out.print((8- i) + " ");
			for(int j=0; j< pieces.length;j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	//imprimir pe�as ou "-" tracinhos quando n�o tiver pe�a na posi��o
	
	private static void printPiece(ChessPiece piece) {
		if (piece == null) {
			System.out.print("-");
		}
		else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}
}
