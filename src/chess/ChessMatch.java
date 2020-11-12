package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	//é nessa classe que constará as regras do jogo de xadrez

	private Board board;
	
	//essa classe é reponsável por saber as dimensões do tabuleiros, por isso é instanciado um tabuleiro 8 por 8
	
	public ChessMatch() {
		board = new Board(8,8);
		
		//ao criar o construtor da partida o método é chamada e a partida inicia, esse método instancia as peças e suas posições
		initialSetup();
	}
	
	//método responsável por retornar uma matriz de peças de xadrez correspondetes a esta partida
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows();i++) {
			for(int j=0; j<board.getColumns();j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	//colocar nova peça
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column,row).toPosition());
	}
	
	//método responsável por iniciar a partida de xadrez, colocando as peças no tabuleiro
	
	private void initialSetup() {
		
		//1º placePiece(instanciando a peça(tabuleiro, cor da peça))
		//2º instancia uma posição para essa peça no tabuleiro "board"
		
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
	}
}
