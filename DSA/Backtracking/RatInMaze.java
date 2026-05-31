package Backtracking;
import java.util.ArrayList;
import java.util.Collections;
public class RatInMaze {

    static ArrayList<String> result = new ArrayList<>();
    static boolean visited[][];
    
    /*  Time - O(4^(n*n)) -> In worst case, the maximum depth of the recursion tree can go upto n^2 where we visit all cells in matrix  
        Space - O(n^2)  -> Auxillary array + maximum call stack depth
    */
    public static void f(int i, int j, String path, int maze[][]) {
        // print the path if reached end
        if(i == maze.length - 1 && j == maze.length - 1) {
            result.add(path);
            return;
        }

        // mark current cell visited
        visited[i][j] = true;

        // right
        if(isValid(i, j + 1, maze)) {
            f(i, j + 1, path + "R", maze);
        }

        // down
        if(isValid(i + 1, j, maze)) {
            f(i + 1, j, path + "D", maze);
        }

        // up
        if(isValid(i - 1, j, maze)) {
            f(i - 1, j, path + "U", maze);
        }

        // left
        if(isValid(i, j - 1, maze)) {
            f(i, j - 1, path + "L", maze);
        }

        visited[i][j] = false;
    }

    public static boolean isValid(int row, int col, int maze[][]) {
        int n = maze.length;
        return row >= 0 && col >= 0 && row < n && col < n && maze[row][col] == 1 && !visited[row][col];
    }
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        result.clear();
        if(maze.length == 0) return result;
        visited = new boolean[maze.length][maze.length];

        if(maze[0][0] == 1) { // start, only if (0, 0) cell is valid
            f(0, 0, "", maze);
        }
        Collections.sort(result);
        return result;
    }
    
    public static void main(String[] args) {

    //    int maze[][] = {{1, 0, 0, 0},
    //                    {1, 1, 0, 1},
    //                    {1, 1, 0, 0},
    //                    {0, 1, 1, 1}};
       int maze[][] = {};
       RatInMaze obj = new RatInMaze();
       ArrayList<String> result = obj.ratInMaze(maze);
       for(String str : result)
            System.out.println(str);
    }
}
