package boardgame;

public class Board {

	private int rows;
	private int columns;
	
	//matriz de peças
	
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		
		//não faz sentido um tabuleiro que não tenha ao menos 1 linha e 1 coluna, por isso essa condição e exceção
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 columns.");
		}
		this.rows = rows;
		this.columns = columns;
		
		//instanciando uma matriz da classe Piece, contendo o número de linhas e colunos passados como argumento no construtor
		pieces = new Piece[rows][columns];
	}

	//criando o get de rows e columns (linhas/colunas), não foi criado os sets e não foram criados get/set da matriz
	//no projeto haverá métodos específicos para retornar as posições da matriz
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	//método responsável por retornar a matriz pieces(linha/coluna)
	
	public Piece piece(int row, int column) {
		
		//se a posição não existir, lança a exceção
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board.");
		}
		return pieces[row][column];
	}

	//sobrecarga do método anterior, mas agora recebe como argumento position, retorna position e seus gets (linha/coluna)
	
	public Piece piece(Position position) {
		
		//se a posição não existir, lança a exceção
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board.");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//método colocar peça - 
	
	public void placePiece(Piece piece, Position position) {
		
		//se já existir uma peça nessa posição, lança a exceção
		if(thereIsAPiece(position)) {
			throw new BoardException("there is already a piece on position" + position);
		}
		
		//vai ter que acessar a matriz (linha/coluna) e atribuir a peça que veio como argumento (colocando uma peça na posição)
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//método responsável por remover uma peça
	public Piece removePiece(Position position) {
		
		//programação defensiva, lançando uma exceção na hipótese de não existir a posição selecionada
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		//se a posição for igual a nulo (lembre que nulo é caracterizada por "-", ou seja, posição vaga e não tem uma peça ali
		if(piece(position) == null) {
			return null;
		}
		
		//criou uma variável do tipo "peça" recebendo a posição e depois alterando para nulo, ou seja, remove a peça e passa a ficar com espaço vago "-"
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	
	
	
	
	
	//essa posição existe? esse método vai verificar se a posição está dentro da matriz 8x8(tabuleiro)
	private boolean positionExists(int row, int column) {
		return row >=0 && row < rows && column >= 0 && column < columns;
	}
	
	//existindo a posição, esse método vai retornar a linha e coluna
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//tem uma peça nessa posição?
	public boolean thereIsAPiece(Position position) {
		//testa se a posição já existe, lança uma exceção caso já exista
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board.");
		}
		return piece(position) != null;
	}
	
	
	
	
	
	
	
}
