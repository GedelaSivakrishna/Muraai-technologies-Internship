package Basics;

public class Hello {

    /*  Time - O(n),    Space - O(n) */
    public static void f(int n) {
        // base case
        if(n == 500) return;

        // self work
        System.out.println("Hello");

        // recursive call
        f(n + 1);
    }

    public static void main(String[] args) {
        f(0);
    }
}
