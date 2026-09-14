public class Fibonacci {

    public static int f(int n) {
        // base case
        if(n == 0 || n == 1) return n;

        return f(n - 1) + f(n - 2);
    }
    
    public static void main(String[] args) {
        // System.out.println(f(0));
        // System.out.println(f(1));
        // System.out.println(f(2));
        // System.out.println(f(3));
        // System.out.println(f(4));
        // System.out.println(f(5));
        // System.out.println(f(6));
        System.out.println(f(30));
    }
}
