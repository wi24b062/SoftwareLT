package org.example;
import java.util.Scanner;
public class TicTacToe
{
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe()
    {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
        this.board = new Board();
    }

    public void start()
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            board.print();
            System.out.println("Player " + currentPlayer.getMarker() + ", enter row and column (e.g. 0 2): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (!board.isCellEmpty(x, y))
            {
                System.out.println("Cell already occupied. Try again.");
                continue;
            }

            board.place(x, y, currentPlayer.getMarker());

            if (hasWinner())
            {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                break;
            }

            if (board.isFull())
            {
                board.print();
                System.out.println("It's a draw!");
                break;
            }

            switchCurrentPlayer();
        }
        scanner.close();
    }

    public void switchCurrentPlayer()
    {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner()
    {
        char[][] c = board.getCells();
        char m = currentPlayer.getMarker();

        // Zeilen, Spalten und Diagonalen prüfen
        for (int i = 0; i < 3; i++)
        {
            if ((c[i][0] == m && c[i][1] == m && c[i][2] == m) ||
                    (c[0][i] == m && c[1][i] == m && c[2][i] == m))
                return true;
        }

        return (c[0][0] == m && c[1][1] == m && c[2][2] == m) ||
                (c[0][2] == m && c[1][1] == m && c[2][0] == m);
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isValidInput(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

}
