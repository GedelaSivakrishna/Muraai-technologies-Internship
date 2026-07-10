public class PrintingPatterns {

    public static void g(int n) {
        // base case
        if(n <= 0) return;

        // self work
        System.out.print("* ");
        g(n - 1);
    }

    public static void f(int n, int row, int col) {
        // base case
        if(row > n) {
            return;
        }
        // call fn to go to next row
        if(col > (n - row + 1)) {
            System.out.println();
            f(n, row + 1, 1);
            return;
        }

        // self work
        System.out.print("* ");
        
        // recursive call to print the next * in current row
        f(n, row, col + 1);
    }
    
    public static void main(String[] args) {
        f(5, 1, 1);
    }
}
