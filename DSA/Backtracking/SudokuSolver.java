package Backtracking;

public class SudokuSolver {

    /*  Time  -  O(9^m) - where m is the number of empty cells
        Space -  O(n^2) - board space + call stack space 
    */
    public static boolean f(int sudoku[][], int row, int col) {
        if(row == sudoku.length) {
            printBoard(sudoku);
            return true;
        }

        int nextRow = row, nextCol = col + 1;
        if(col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0) {
            return f(sudoku, nextRow, nextCol);
        }

        for(int digit = 1; digit <= 9; digit++) {
            if(isValid(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if(f(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        
        return false;
    }

    public static boolean isValid(int sudoku[][], int row, int col, int digit) {
        // check row
        for(int j = 0; j < 9; j++) {
            if(sudoku[row][j] == digit) return false;
        }

        // check column
        for(int i = 0; i < 9; i++) {
            if(sudoku[i][col] == digit) return false;
        }

        // check 3 x 3 grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(sudoku[i][j] == digit) return false;
            }
        }

        return true;
    }

    public static void printBoard(int sudoku[][]) {
        for(int i = 0; i < sudoku.length; i++) {
            for(int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int sudoku[][] =   {{5,3,0,0,7,0,0,0,0},
                            {6,0,0,1,9,5,0,0,0},
                            {0,9,8,0,0,0,0,6,0},
                            {8,0,0,0,6,0,0,0,3},
                            {4,0,0,8,0,3,0,0,1},
                            {7,0,0,0,2,0,0,0,6},
                            {0,6,0,0,0,0,2,8,0},
                            {0,0,0,4,1,9,0,0,5},
                            {0,0,0,0,8,0,0,7,9}};
        f(sudoku, 0, 0);
    }
}
