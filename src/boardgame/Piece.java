package boardgame;

public class Piece {

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
	
}
