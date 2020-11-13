package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	//se trata da pe�a "torre" do xadrez e � uma subclasse de ChessPiece(pe�a de xadrez)
	
	//construtor pegando da superclasse board e color
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	//a pe�a ser� representada na tela como um "R"
	@Override
	public String toString() {
		return "R";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		//verificar movimento para CIMA
		p.setValues(position.getRow() - 1, position.getColumn());
		
		//Enquanto a posi��o "p" existir e n�o tiver uma pe�a l�, ou seja, enquanto a posi��o estiver vaga, constar� como verdadeira
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			
			//indicando que essa posi��o � verdadeira(est� vaga), e que a pe�a pode se mover por ela 
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		
		//ir� verificar se a posi��o existe e se h� um oponente nela, caso sim torna o movimento da pe�a poss�vel para realizar a captura da pe�a do advers�rio
		if(getBoard().positionExists(p) && isThereOpponentPiece(p))	{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//verificar movimento para ESQUERDA
		p.setValues(position.getRow(), position.getColumn() - 1);
		
		//Enquanto a posi��o "p" existir e n�o tiver uma pe�a l�, ou seja, enquanto a posi��o estiver vaga, constar� como verdadeira
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			
			//indicando que essa posi��o � verdadeira(est� vaga), e que a pe�a pode se mover por ela 
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		
		//ir� verificar se a posi��o existe e se h� um oponente nela, caso sim torna o movimento da pe�a poss�vel para realizar a captura da pe�a do advers�rio
		if(getBoard().positionExists(p) && isThereOpponentPiece(p))	{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//verificar movimento para DIREITA
		p.setValues(position.getRow(), position.getColumn() + 1);
		
		//Enquanto a posi��o "p" existir e n�o tiver uma pe�a l�, ou seja, enquanto a posi��o estiver vaga, constar� como verdadeira
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			
			//indicando que essa posi��o � verdadeira(est� vaga), e que a pe�a pode se mover por ela 
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		
		//ir� verificar se a posi��o existe e se h� um oponente nela, caso sim torna o movimento da pe�a poss�vel para realizar a captura da pe�a do advers�rio
		if(getBoard().positionExists(p) && isThereOpponentPiece(p))	{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//verificar movimento para BAIXO
				p.setValues(position.getRow() + 1, position.getColumn());
				
				//Enquanto a posi��o "p" existir e n�o tiver uma pe�a l�, ou seja, enquanto a posi��o estiver vaga, constar� como verdadeira
				while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					
					//indicando que essa posi��o � verdadeira(est� vaga), e que a pe�a pode se mover por ela 
					mat[p.getRow()][p.getColumn()] = true;
					p.setRow(p.getRow() + 1);
				}
				
				//ir� verificar se a posi��o existe e se h� um oponente nela, caso sim torna o movimento da pe�a poss�vel para realizar a captura da pe�a do advers�rio
				if(getBoard().positionExists(p) && isThereOpponentPiece(p))	{
					mat[p.getRow()][p.getColumn()] = true;
				}
		
		
		
		
		
		
		
		
		return mat;
	}
	
}
