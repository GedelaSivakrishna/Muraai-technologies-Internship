package Basics;

public class PrintDescendingOrder {

    public static void f(int n) {
        // base case
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }

        // recursive call
        f(n - 1);

        // self work
        System.out.print(n + " ");
    }
    
    public static void main(String[] args) {
        f(10);
    }
}
