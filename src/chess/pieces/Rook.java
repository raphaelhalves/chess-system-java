package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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
		
		Position p = new Position(0, 0);
		
		//verificar movimento para CIMA
		p.setValues(position.getRow() - 1, position.getColumn());
		
		//Enquanto a posição "p" existir e não tiver uma peça lá, ou seja, enquanto a posição estiver vaga, constará como verdadeira
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			
			//indicando que essa posição é verdadeira(está vaga), e que a peça pode se mover por ela 
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		
		//irá verificar se a posição existe e se há um oponente nela, caso sim torna o movimento da peça possível para realizar a captura da peça do adversário
		if(getBoard().positionExists(p) && isThereOpponentPiece(p))	{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//verificar movimento para ESQUERDA
		p.setValues(position.getRow(), position.getColumn() - 1);
		
		//Enquanto a posição "p" existir e não tiver uma peça lá, ou seja, enquanto a posição estiver vaga, constará como verdadeira
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			
			//indicando que essa posição é verdadeira(está vaga), e que a peça pode se mover por ela 
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		
		//irá verificar se a posição existe e se há um oponente nela, caso sim torna o movimento da peça possível para realizar a captura da peça do adversário
		if(getBoard().positionExists(p) && isThereOpponentPiece(p))	{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//verificar movimento para DIREITA
		p.setValues(position.getRow(), position.getColumn() + 1);
		
		//Enquanto a posição "p" existir e não tiver uma peça lá, ou seja, enquanto a posição estiver vaga, constará como verdadeira
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			
			//indicando que essa posição é verdadeira(está vaga), e que a peça pode se mover por ela 
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		
		//irá verificar se a posição existe e se há um oponente nela, caso sim torna o movimento da peça possível para realizar a captura da peça do adversário
		if(getBoard().positionExists(p) && isThereOpponentPiece(p))	{
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//verificar movimento para BAIXO
				p.setValues(position.getRow() + 1, position.getColumn());
				
				//Enquanto a posição "p" existir e não tiver uma peça lá, ou seja, enquanto a posição estiver vaga, constará como verdadeira
				while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					
					//indicando que essa posição é verdadeira(está vaga), e que a peça pode se mover por ela 
					mat[p.getRow()][p.getColumn()] = true;
					p.setRow(p.getRow() + 1);
				}
				
				//irá verificar se a posição existe e se há um oponente nela, caso sim torna o movimento da peça possível para realizar a captura da peça do adversário
				if(getBoard().positionExists(p) && isThereOpponentPiece(p))	{
					mat[p.getRow()][p.getColumn()] = true;
				}
		
		
		
		
		
		
		
		
		return mat;
	}
	
}
