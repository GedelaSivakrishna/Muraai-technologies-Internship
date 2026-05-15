package Class;
public class GridWays {

    /*  f(i, j, m, n, path) = f(i, j + 1, m, n, path + "R") // Here we assume this functions works correctly and find all the 
                                paths correctly from (i, j + 1) to (m - 1, n - 1) and we just add "R" to all paths.
                              f(i + 1, j, m, n, path + "D") // Here we assume this functions works correctly and find all the 
                                paths correctly from (i + 1, j) to (m - 1, n - 1) and we just add "D" to all paths.
     */
    /*  Time  - O(2 ^ m + n) // The total function calls in recursive tree 
        Space - O(m + n) // The maximum depth of recursive tree
    */
    static int ways = 0;
    public static void f(int i, int j, int m, int n, String path) {
        if(i == m || j == n) return; // we cannot go out of the grid boundaries

        if(i == m - 1 && j == n - 1) { // print the path, once we reach the destination
            System.out.println(path);
            ways++; // to count the total possible path recursively
            return;
        }

        f(i, j + 1, m, n, path + "R"); // This function finds out all paths correctly from (i + 1, j) to (m - 1, n - 1) and 
                                       // we add "R" as we make right move
        f(i + 1, j, m, n, path + "D"); // This function finds out all path correctly from (i + 1, j) to (m - 1, n - 1), we add
                                       // "D" to the paths, as we make down move 
    }

    /*  Time  - O(n)
        Space - O(1)
    */
    public static int factorial(int n) {
        if(n == 1) return 1;

        return n * factorial(n - 1);
    }

    /*  Time  - O(min(m, n))
        Space - O(min(m, n))
    */
    public static int countGridWays(int m, int n) {
        // int N = m - 1 + n - 1;
        // int r = Math.min(m-1, n-1);
        // int val = 1;
        // for(int i = 1; i <= r; i++) {
        //     val *= N--;
        // }
        // int ways = val / factorial(r); 
        // return ways;

        int res = 1;
        int N = m + n - 2;
        int r = Math.min(m-1, n-1);

        for(int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return res;
    }

    // HW: define recursive relation
    public static void countGridWaysRecursively(int i, int j, int m, int n) {
        if(i == m || j == n) return; // we cannot go out of the grid boundaries

        if(i == m - 1 && j == n - 1) { 
            ways++; // to count the total possible path recursively
            return;
        }

        countGridWaysRecursively(i, j + 1, m, n);

        countGridWaysRecursively(i + 1, j, m, n);
    }

    public static void main(String[] args) {
        // f(0, 0, 3, 3, "");
        // f(0, 0, 2, 1, "");
        // System.out.println(countGridWays(3, 3)); // 6
        // System.out.println(countGridWays(4, 4)); // 20
        countGridWaysRecursively(0, 0, 3, 3);
        System.out.println(ways);
    }
}