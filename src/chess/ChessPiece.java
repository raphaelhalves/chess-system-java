package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

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

	//método para verificar se há uma peça adversária nessa posição
	protected boolean isThereOpponentPiece(Position position) {
		//a variável "p" está recebendo a peça desta posição
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		/*no return está sendo testado se a peça "p" é diferente de nulo, ou seja, se há peça na posição, 
		e havendo se a cor dela é diferente da cor da minha peça, por fim retorna se isso é verdadeiro ou falso
		*/
		return p != null && p.getColor() != color;
	}
	
	
	
	
}
