package Backtracking;
public class NKnights {

    static int count = 0;

    /*  Time  - O(n!)
        Space - O(n^2)
    */
    public static void nKnights(char[][] board, int row) {
        if(row == board.length) {
            // printBoard(board);
            count++;
            return;
        }

        for(int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'K';
                nKnights(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        if(row - 2 >= 0) {
            if(col - 1 >= 0 && board[row - 2][col - 1] == 'K')
                return false;

            if(col + 1 < board.length && board[row - 2][col + 1] == 'K')
                return false;
        }
        
        if(row - 1 >= 0) {
            if(col - 2 >= 0 && board[row - 1][col - 2] == 'K')
                return false;

            if(col + 2 < board.length && board[row - 1][col + 2] == 'K')
                return false;
        }

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
        int n = 8;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        count = 0;
        nKnights(board, 0);
        System.out.println("Total ways = " + count);
    }
}
