package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	//� nessa classe que constar� as regras do jogo de xadrez

	private Board board;
	
	//essa classe � repons�vel por saber as dimens�es do tabuleiros, por isso � instanciado um tabuleiro 8 por 8
	
	public ChessMatch() {
		board = new Board(8,8);
		
		//ao criar o construtor da partida o m�todo � chamada e a partida inicia, esse m�todo instancia as pe�as e suas posi��es
		initialSetup();
	}
	
	//m�todo respons�vel por retornar uma matriz de pe�as de xadrez correspondetes a esta partida
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows();i++) {
			for(int j=0; j<board.getColumns();j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	//m�todo respons�vel por setar uma posi��o nova
	public ChessPiece performChessmove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		//opera��o respons�vel por validar a posi��o de origem, se realmente existe uma pe�a na posi��o de origem
		validateSourcePosition(source);
		
		//Opera��o respons�vel por validar a posi��o de destino da pe�a, se realmente a pe�a pode fazer o movimento para essa nova posi��o
		validateTargetPosition(source, target);
		
		Piece capturedPiece = makeMove(source, target);
		//downcasting para ChessPiece porque a vari�vel capturedPiece era do tipo Piece
		return (ChessPiece)capturedPiece;
		
	}
	
	//como dito acima, esse m�todo retorno se de fato existe uma pe�a na posi��o de origem, para s� depois mov�-la para seu destino
	private void validateSourcePosition(Position position) {
		
		//lan�ando uma exce��o para a hip�tese de n�o existir uma pe�a na posi��o de origem
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		
		//se n�o tiver nenhum movimento poss�vel para a pe�a, est� sendo lan�ada uma exce��o
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) {
		
		//a condi��o � se para a pe�a de origem o movimento N�O � poss�vel para o destino, significa que n�o pode mexer para l�
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	//m�todo respons�vel por movimentar a pe�a, recebendo uma posi��o de origem, e uma posi��o de destino
	private Piece makeMove(Position source, Position target) {
		
		//retirei a pe�a na posi��o de origem
		Piece p = board.removePiece(source);
		
		//pe�a capturada, remover a pe�a na posi��o de destino, sai p entrar a nova pe�a
		Piece capturedPiece = board.removePiece(target);
		
		//agora a vari�vel "p" que representa a posi��o de destino passar� a valer a nova posi��o, a qual inclusive removeu uma pe�a q estava nela
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	
	//colocar nova pe�a
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column,row).toPosition());
	}
	
	//m�todo respons�vel por iniciar a partida de xadrez, colocando as pe�as no tabuleiro
	
	private void initialSetup() {
		
		//1� placePiece(instanciando a pe�a(tabuleiro, cor da pe�a))
		//2� instancia uma posi��o para essa pe�a no tabuleiro "board"
		
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
