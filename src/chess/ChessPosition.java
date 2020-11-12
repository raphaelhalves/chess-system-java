package chess;

import boardgame.Position;

public class ChessPosition {

	
	//atributo coluna � do tipo char pois as colunas ser�o "a", "b", "c", etc.
	private char column;
	private int row;
	
	
	public ChessPosition(char column, int row) {

		//se algo da estrutura condicional for verdadeiro, lan�a a exce��o, pois � necess�rio que seja instanciado em 8x8
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

	/*m�todo respons�vel por converter a posi��o da matriz pela posi��o do jogo de xadrez
	 * ou seja, ex= a posi��o 0,0 em A8.
	 */
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	//converter a posi��o do xadrez pela matriz
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	@Override
	public String toString() {
		return "" + column + row;
	}
	
}
