package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	//é nessa classe que constará as regras do jogo de xadrez

	private Board board;
	
	//essa classe é reponsável por saber as dimensões do tabuleiros, por isso é instanciado um tabuleiro 8 por 8
	
	public ChessMatch() {
		board = new Board(8,8);
		
		//ao criar o construtor da partida o método é chamada e a partida inicia, esse método instancia as peças e suas posições
		initialSetup();
	}
	
	//método responsável por retornar uma matriz de peças de xadrez correspondetes a esta partida
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows();i++) {
			for(int j=0; j<board.getColumns();j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	//método responsável por setar uma posição nova
	public ChessPiece performChessmove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		//operação responsável por validar a posição de origem, se realmente existe uma peça na posição de origem
		validateSourcePosition(source);
		
		//Operação responsável por validar a posição de destino da peça, se realmente a peça pode fazer o movimento para essa nova posição
		validateTargetPosition(source, target);
		
		Piece capturedPiece = makeMove(source, target);
		//downcasting para ChessPiece porque a variável capturedPiece era do tipo Piece
		return (ChessPiece)capturedPiece;
		
	}
	
	//como dito acima, esse método retorno se de fato existe uma peça na posição de origem, para só depois movê-la para seu destino
	private void validateSourcePosition(Position position) {
		
		//lançando uma exceção para a hipótese de não existir uma peça na posição de origem
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		
		//se não tiver nenhum movimento possível para a peça, está sendo lançada uma exceção
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) {
		
		//a condição é se para a peça de origem o movimento NÃO é possível para o destino, significa que não pode mexer para lá
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	//método responsável por movimentar a peça, recebendo uma posição de origem, e uma posição de destino
	private Piece makeMove(Position source, Position target) {
		
		//retirei a peça na posição de origem
		Piece p = board.removePiece(source);
		
		//peça capturada, remover a peça na posição de destino, sai p entrar a nova peça
		Piece capturedPiece = board.removePiece(target);
		
		//agora a variável "p" que representa a posição de destino passará a valer a nova posição, a qual inclusive removeu uma peça q estava nela
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	
	//colocar nova peça
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column,row).toPosition());
	}
	
	//método responsável por iniciar a partida de xadrez, colocando as peças no tabuleiro
	
	private void initialSetup() {
		
		//1º placePiece(instanciando a peça(tabuleiro, cor da peça))
		//2º instancia uma posição para essa peça no tabuleiro "board"
		
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
