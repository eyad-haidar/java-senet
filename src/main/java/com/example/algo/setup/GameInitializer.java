package com.example.algo.setup;

import com.example.algo.state.Cell;
import com.example.algo.state.GameState;
import com.example.algo.state.Piece;

import java.util.ArrayList;
import java.util.List;

import com.example.algo.player.*;

/*
 * DEV_NOTES: the returns here are wrong , just creating the functions . 
 */
public class GameInitializer {
	public GameState createNewGame() {
		BoardFactory factory = new BoardFactory();
		Cell[] board = factory.createBoard();

		List<Player> playersList = createPlayers();

		List<Piece> pieces = createPieces(playersList);

		placePiecesOnBoard(pieces, playersList);

		// Convert players list to array for GameState
		Player[] playersArray = playersList.toArray(new Player[0]);

		// NOTE_FOR_YOUSEF: GameState needs a new constructor that accepts these parameters, I'll add it.
		return new GameState(board, pieces, playersArray);
	}

	protected List<Player> createPlayers() {
		List<Player> players = new ArrayList<>();

		Player player1 = new Player("Player 1", null);
		players.add(player1);

		Player player2 = new Player("Player 2", null);
		players.add(player2);

		return players;
	}

	protected List<Piece> createPieces(List<Player> players) {
		List<Piece> pieces = new ArrayList<>();

		Player player1 = players.get(0);
		Player player2 = players.get(1);

		// Create 7 pieces for Player 1
		for (int i = 0; i < 7; i++) {
			Piece piece = new Piece(player1, -1);
			pieces.add(piece);
		}

		// Create 7 pieces for Player 2
		for (int i = 0; i < 7; i++) {
			Piece piece = new Piece(player2, -1);
			pieces.add(piece);
		}

		return pieces;
	}

	private void placePiecesOnBoard(List<Piece> pieces, List<Player> players) {
		int player1PieceIndex = 0;
		int player2PieceIndex = 7; // Place in the List not the Board

		for (int cellNumber = 1; cellNumber <= 14; cellNumber++) {
			Piece pieceToPlace;

			if (cellNumber % 2 == 1) {
				pieceToPlace = pieces.get(player1PieceIndex);
				player1PieceIndex++;
			} else {
				pieceToPlace = pieces.get(player2PieceIndex);
				player2PieceIndex++;
			}

			// Move the piece to the right initial position
			pieceToPlace.moveTo(cellNumber);
		}
	}
}
