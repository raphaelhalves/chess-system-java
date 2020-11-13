package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

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

	//m�todo para verificar se h� uma pe�a advers�ria nessa posi��o
	protected boolean isThereOpponentPiece(Position position) {
		//a vari�vel "p" est� recebendo a pe�a desta posi��o
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		/*no return est� sendo testado se a pe�a "p" � diferente de nulo, ou seja, se h� pe�a na posi��o, 
		e havendo se a cor dela � diferente da cor da minha pe�a, por fim retorna se isso � verdadeiro ou falso
		*/
		return p != null && p.getColor() != color;
	}
	
	
	
	
}
