package test;

import org.example.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testGameInitialization() {
        assertNotNull(game);  // Spiel darf nicht null sein
    }

    @Test
    public void testSwitchCurrentPlayer() {
        char first = game.getCurrentPlayer().getMarker();
        game.switchCurrentPlayer();
        char second = game.getCurrentPlayer().getMarker();
        assertNotEquals(first, second);  // Marker muss sich nach Wechsel ändern
    }

    @Test
    public void testHasWinnerFalseInitially() {
        assertFalse(game.hasWinner());  // Am Anfang darf noch niemand gewonnen haben
    }

    @Test
    public void testValidInputCheck() {
        assertTrue(game.isValidInput(1, 2));      // gültig
        assertFalse(game.isValidInput(-1, 0));    // negativ = ungültig
        assertFalse(game.isValidInput(0, 3));     // größer als erlaubt = ungültig
    }
}
