package application;

import chess.ChessPiece;

public class UI {
	
	//user interface - será criado o método printBoard recebendo a matriz de peças da partida

	public static void printBoard(ChessPiece[][] pieces) {
		
		//vai percorrer toda a matriz e aplicar o método de imprimir peças ou tracinhos em cada posição
		
		for(int i=0; i<pieces.length;i++) {
			System.out.print((8- i) + " ");
			for(int j=0; j< pieces.length;j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	//imprimir peças ou "-" tracinhos quando não tiver peça na posição
	
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
