package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	//� nessa classe que constar� as regras do jogo de xadrez

	private Board board;
	
	//essa classe � repons�vel por saber as dimens�es do tabuleiros, por isso � instanciado um tabuleiro 8 por 8
	
	public ChessMatch() {
		board = new Board(8,8);
		
		//ao criar o construtor da partida o m�todo � chamada e a partida inicia, esse m�todo instancia as pe�as e suas posi��es
		initialSetup();
	}
	
	//m�todo respons�vel por retornar uma matriz de pe�as de xadrez correspondetes a esta partida
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows();i++) {
			for(int j=0; j<board.getColumns();j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	//colocar nova pe�a
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column,row).toPosition());
	}
	
	//m�todo respons�vel por iniciar a partida de xadrez, colocando as pe�as no tabuleiro
	
	private void initialSetup() {
		
		//1� placePiece(instanciando a pe�a(tabuleiro, cor da pe�a))
		//2� instancia uma posi��o para essa pe�a no tabuleiro "board"
		
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
	}
}
