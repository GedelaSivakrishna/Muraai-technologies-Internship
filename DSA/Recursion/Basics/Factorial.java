package Basics;

public class Factorial {

    /*  Time - O(n),    Space - O(n) */
    public static long f(int n) {
        // base case
        if(n == 1) return n;

        // self work + recursive call
        return n * f(n - 1);
    }
    
    public static void main(String[] args) {
        // System.out.println(f(5));
        // System.out.println(f(6));
        // System.out.println(f(7));
        // System.out.println(f(8));
        // System.out.println(f(9));
        // System.out.println(f(10));
        // System.out.println(f(21));
    }
}
