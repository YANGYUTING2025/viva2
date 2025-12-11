import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter row " + i + ": ");
            String temp = input.next();
            for (int j = 0; j < 3; j++) {
                board[i][j] = temp.charAt(j);
            }
        }
        input.close();

        int countX = countMoves(board, 'X');
        int countO = countMoves(board, 'O');
        if (countX == countO || countX == countO + 1) {
            char winner = checkWinner(board);
            if (winner == '.') {
                System.out.println("No winner");
            } else System.out.println("Winner: " + winner);
        } else System.out.println("Invalid board: number of moves is not valid.");
    }

    private static int countMoves(char[][] board, char player) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == player) {
                    count++;
                }
            }
        }
        return count;
    }

    private static char checkWinner(char[][] board) {
        // check row
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '.') {
                return board[i][0];
            }
        }
        // check column
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != '.') {
                return board[0][i];
            }
        }
        // check diagonals
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '.') {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '.') {
            return board[0][2];
        }
        return '.';
    }
}
