package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	//se trata da pe�a "rei" do xadrez e � uma subclasse de ChessPiece(pe�a de xadrez)

	
	//construtor pegando da superclasse board e color
	public King(Board board, Color color) {
		super(board, color);
	}

	//a pe�a ser� representada na tela como um "K"
	@Override
	public String toString() {
		return "K";
	}
	
}
