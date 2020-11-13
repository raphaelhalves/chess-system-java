package boardgame;

public class Board {

	private int rows;
	private int columns;
	
	//matriz de pe�as
	
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		
		//n�o faz sentido um tabuleiro que n�o tenha ao menos 1 linha e 1 coluna, por isso essa condi��o e exce��o
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 columns.");
		}
		this.rows = rows;
		this.columns = columns;
		
		//instanciando uma matriz da classe Piece, contendo o n�mero de linhas e colunos passados como argumento no construtor
		pieces = new Piece[rows][columns];
	}

	//criando o get de rows e columns (linhas/colunas), n�o foi criado os sets e n�o foram criados get/set da matriz
	//no projeto haver� m�todos espec�ficos para retornar as posi��es da matriz
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	//m�todo respons�vel por retornar a matriz pieces(linha/coluna)
	
	public Piece piece(int row, int column) {
		
		//se a posi��o n�o existir, lan�a a exce��o
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board.");
		}
		return pieces[row][column];
	}

	//sobrecarga do m�todo anterior, mas agora recebe como argumento position, retorna position e seus gets (linha/coluna)
	
	public Piece piece(Position position) {
		
		//se a posi��o n�o existir, lan�a a exce��o
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board.");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//m�todo colocar pe�a - 
	
	public void placePiece(Piece piece, Position position) {
		
		//se j� existir uma pe�a nessa posi��o, lan�a a exce��o
		if(thereIsAPiece(position)) {
			throw new BoardException("there is already a piece on position" + position);
		}
		
		//vai ter que acessar a matriz (linha/coluna) e atribuir a pe�a que veio como argumento (colocando uma pe�a na posi��o)
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//m�todo respons�vel por remover uma pe�a
	public Piece removePiece(Position position) {
		
		//programa��o defensiva, lan�ando uma exce��o na hip�tese de n�o existir a posi��o selecionada
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		//se a posi��o for igual a nulo (lembre que nulo � caracterizada por "-", ou seja, posi��o vaga e n�o tem uma pe�a ali
		if(piece(position) == null) {
			return null;
		}
		
		//criou uma vari�vel do tipo "pe�a" recebendo a posi��o e depois alterando para nulo, ou seja, remove a pe�a e passa a ficar com espa�o vago "-"
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	
	
	
	
	
	//essa posi��o existe? esse m�todo vai verificar se a posi��o est� dentro da matriz 8x8(tabuleiro)
	private boolean positionExists(int row, int column) {
		return row >=0 && row < rows && column >= 0 && column < columns;
	}
	
	//existindo a posi��o, esse m�todo vai retornar a linha e coluna
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//tem uma pe�a nessa posi��o?
	public boolean thereIsAPiece(Position position) {
		//testa se a posi��o j� existe, lan�a uma exce��o caso j� exista
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board.");
		}
		return piece(position) != null;
	}
	
	
	
	
	
	
	
}
