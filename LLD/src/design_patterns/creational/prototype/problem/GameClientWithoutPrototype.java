package design_patterns.creational.prototype.problem;

public class GameClientWithoutPrototype {
	public static void main(String[] args) {
		GameBoard gameBoard = new GameBoard();
		gameBoard.addPiece(new GamePiece("Red", 1));
		gameBoard.addPiece(new GamePiece("Blue", 5));
		gameBoard.showBoardState();

		// Checkpoint this state
		GameBoard copiedBoard = new GameBoard();
		for (GamePiece piece : gameBoard.getPieces()) {
			copiedBoard.addPiece(new GamePiece(piece.getColor(), piece.getPosition()));
		}

		System.out.println("Copied Board");
		copiedBoard.showBoardState();
	}
}