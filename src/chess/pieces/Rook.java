package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	//se trata da peça "torre" do xadrez e é uma subclasse de ChessPiece(peça de xadrez)
	
	//construtor pegando da superclasse board e color
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	//a peça será representada na tela como um "R"
	@Override
	public String toString() {
		return "R";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}
	
}
