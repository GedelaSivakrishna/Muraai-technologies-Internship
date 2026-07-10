public class Factorial {

    // Time: O(n)
    //Space: O(n)
    public static int f(int n) {
        // base case
        if(n == 1) return 1;

        return n * f(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(f(5));
    }
}