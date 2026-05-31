package Class;
public class GridWaysPractice {

    static int count = 0;

    /*  Time - O(2^m+n)     Space - O(m + n)  */
    public static void f(int m, int n, int i, int j, String output) {
        if(i == m - 1 && j == n - 1) {
            count++;
            System.out.println(output);
            return;
        }

        if(i >= m || j >= n) return;

        // right move
        f(m, n, i, j + 1, output + "R");

        // down move
        f(m, n, i + 1, j, output + "D");
    }
    
    public static void main(String[] args) {
        count = 0;
        f(4, 4, 0, 0, "");
        System.out.println(count);
    }
}
