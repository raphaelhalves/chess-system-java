package boardgame;

public abstract class Piece {

	//não é a posição do xadrez, mas uma posição simples da matriz, só é visível dentro do pacote boardgame
	
	protected Position position;
	
	private Board board;

	//a posição de uma peça recém criada é nula, não foi colocada no tabuleiro ainda
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	//getBoard foi alterado para protected, somente classes do mesmo pacote boardgame e subclasses de "Piece" é que irão poder acessar o tabuleiro de uma peça
	
	protected Board getBoard() {
		return board;
	}

	//não há o setBoard pois não será permitido a alteração do tabuleiro
	
	
	//operação para verificar os movimentos possíveis de uma peça, abstrata pq aqui é muito genérica, cada peça seguirá uma ordem específica de movimentação
	public abstract boolean[][] possibleMoves();
	
	
	//testar positivo ou falso sobre a possibilidade da peça se mover
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	//existe pelo menos um movimento possível para a peça? ou está travada?
	public boolean isThereAnyPossibleMove() {
		
		boolean[][] mat = possibleMoves();
		
		//vai percorrer toda a matriz 
		for(int i = 0; i<mat.length; i++) {
			for(int j = 0; j<mat.length;j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
}
