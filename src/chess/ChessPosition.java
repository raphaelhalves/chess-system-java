package chess;

import boardgame.Position;

public class ChessPosition {

	
	//atributo coluna é do tipo char pois as colunas serão "a", "b", "c", etc.
	private char column;
	private int row;
	
	
	public ChessPosition(char column, int row) {

		//se algo da estrutura condicional for verdadeiro, lança a exceção, pois é necessário que seja instanciado em 8x8
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	/*método responsável por converter a posição da matriz pela posição do jogo de xadrez
	 * ou seja, ex= a posição 0,0 em A8.
	 */
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	//converter a posição do xadrez pela matriz
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	@Override
	public String toString() {
		return "" + column + row;
	}
	
}
