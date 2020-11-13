package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece{
	
	//classe "PEÇA DE XADREZ", é uma subclasse de Piece
	
	private Color color;

	//construtor 
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	//não há o setColor, pois não é possível setar a cor e alterá-la
	
	public Color getColor() {
		return color;
	}

	
	
	
	
	
}
