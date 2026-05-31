package Basics;

public class NthFibonacci {

    /*  Time - O(2^n),    Space - O(n) */
    public static int f(int n) {
        // base case
        if(n == 0 || n == 1) return n;

        // recursive call + self work
        return f(n - 1) + f(n - 2);
    }
    
    public static void main(String[] args) {
        System.out.println(f(0)); // 0
        System.out.println(f(1)); // 1
        System.out.println(f(2)); // 1
        System.out.println(f(3)); // 2
        System.out.println(f(4)); // 3
        System.out.println(f(5)); // 5
        System.out.println(f(6)); // 8
    }
}
