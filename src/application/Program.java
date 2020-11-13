package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();

		while (true) {
			try {
			//método retirado do stackeroverflow para limpar a tela do terminal após a jogada, mantendo apenas o tabuleiro atual
			UI.clearScreen();
			
			//imprimir o tabuleiro na tela
			UI.printBoard(chessMatch.getPieces());
			
			System.out.println();
			//posição de origem
			System.out.print("Source: ");
			ChessPosition source  = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.print("target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = chessMatch.performChessmove(source, target);
			}
			catch(ChessException e) {
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
