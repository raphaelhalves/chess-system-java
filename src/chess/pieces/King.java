package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	//se trata da peça "rei" do xadrez e é uma subclasse de ChessPiece(peça de xadrez)

	
	//construtor pegando da superclasse board e color
	public King(Board board, Color color) {
		super(board, color);
	}

	//a peça será representada na tela como um "K"
	@Override
	public String toString() {
		return "K";
	}
	
}
