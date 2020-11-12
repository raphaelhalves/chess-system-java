package boardgame;

public class Piece {

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
	
}
