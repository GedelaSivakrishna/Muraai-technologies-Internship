package Backtracking;

import java.util.Arrays;

public class KnightsTour {

    static int rowMoves[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int colMoves[] = {1, 2, 2, 1, -1, -2, -2, -1};

    /*  Time  - O(8^(n * n))
        Space - O(n*n)
    */
    public static void f(int board[][], int row, int col, int step) {
        if(step == board.length * board.length) {
            printBoard(board);
            return;
        }
        

        for(int i = 0; i < 8; i++) {
            int nextRow = row + rowMoves[i];
            int nextCol = col + colMoves[i];
            if(isValid(board, nextRow, nextCol)) {
                board[nextRow][nextCol] = step;
                f(board, nextRow, nextCol, step + 1);
                board[nextRow][nextCol] = -1;
            }
        }
    }

    /* Best case Time  - O(n*n) This is possibile when knight a valid move at every choice which leads us to the ending
       Worst case Time - O(8^(n*n)) This occurs even for single solution, when wrong choice is made and need to backtrack
       Space - O(n^2) board space + call stack
    */
    public static boolean f_singleSolution(int board[][], int row, int col, int step) {
        if(step == board.length * board.length) {
            printBoard(board);
            return true;
        }

        for(int i = 0; i < 8; i++) {
            int nextRow = row + rowMoves[i];
            int nextCol = col + colMoves[i];
            if(isValid(board, nextRow, nextCol)) {
                board[nextRow][nextCol] = step;
                if(f_singleSolution(board, nextRow, nextCol, step + 1)) {
                    return true;
                }
                board[nextRow][nextCol] = -1;
            }
        }

        // If explored all the 8 moves for a cell and still didn't find a valid move, return false, backtrack and make another choice
        return false;
    }

    public static boolean isValid(int board[][], int row, int col) {
        int n = board.length;
        return row >= 0 && row < n && col >= 0 && col < n && board[row][col] == -1;
    }

    public static void printBoard(int board[][]) {
        System.out.println("--------- Chess Board ----------");
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int n = 7;
        int board[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], -1);
        }
        // printBoard(board);
        board[0][0] = 0;
        // f(board, 0, 0, 1);
        if (f_singleSolution(board, 0, 0, 1)) {
            System.out.println("Solution exists");
        } else {
            System.out.println("Solution doesn't exist");
        }
    }
}
