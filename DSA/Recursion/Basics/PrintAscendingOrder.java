package Basics;

public class PrintAscendingOrder {

    public static void f(int n) {
        // base case
        if(n == 10) {
            System.out.print(n);
            return;
        }

        // self work
        System.out.print(n + " ");

        // recursive call
        f(n + 1);
    }
    
    public static void main(String[] args) {
        f(1);
    }
}
