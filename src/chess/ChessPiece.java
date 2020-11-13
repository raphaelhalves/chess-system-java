package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece{
	
	//classe "PE�A DE XADREZ", � uma subclasse de Piece
	
	private Color color;

	//construtor 
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	//n�o h� o setColor, pois n�o � poss�vel setar a cor e alter�-la
	
	public Color getColor() {
		return color;
	}

	
	
	
	
	
}
