package Backtracking;
public class NQueens {

    static int ways = 0;

    /*  Time - O(n!),   
        Space - O(n^2)  Board space
    */
    public static void nQueens(char board[][], int row) {
        if(row == board.length) {
            printBoard(board);
            return;
        }

        for(int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }

    /*  Time - O(n) */
    public static boolean isSafe(char board[][], int row, int col) {

        // vertically up
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q') return false;
        }

        // top left
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }

        // top right
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }

        // If all sides are safe, return true
        return true;
    }

    public static void printBoard(char board[][]) {
        System.out.println("--------- Chess Board ----------");
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int n = 1;
        char board[][] = new char[n][n];
        // mark all places with 'X'
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = 'X';
            }
        }
        nQueens(board, 0);
    }
}
