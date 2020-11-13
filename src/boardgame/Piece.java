package boardgame;

public abstract class Piece {

	//n�o � a posi��o do xadrez, mas uma posi��o simples da matriz, s� � vis�vel dentro do pacote boardgame
	
	protected Position position;
	
	private Board board;

	//a posi��o de uma pe�a rec�m criada � nula, n�o foi colocada no tabuleiro ainda
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	//getBoard foi alterado para protected, somente classes do mesmo pacote boardgame e subclasses de "Piece" � que ir�o poder acessar o tabuleiro de uma pe�a
	
	protected Board getBoard() {
		return board;
	}

	//n�o h� o setBoard pois n�o ser� permitido a altera��o do tabuleiro
	
	
	//opera��o para verificar os movimentos poss�veis de uma pe�a, abstrata pq aqui � muito gen�rica, cada pe�a seguir� uma ordem espec�fica de movimenta��o
	public abstract boolean[][] possibleMoves();
	
	
	//testar positivo ou falso sobre a possibilidade da pe�a se mover
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	//existe pelo menos um movimento poss�vel para a pe�a? ou est� travada?
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
