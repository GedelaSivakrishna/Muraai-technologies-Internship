package Basics;

public class PrintZ2A {

    public static void f(char ch) {
        // base case
        if(ch == 'Z') {
            System.out.print(ch + " ");
            return;
        }

        // recursive call
        f((char)(ch + 1));

        // self work
        System.out.print(ch + " ");
    }
    
    public static void main(String[] args) {
        f('A');
    }
}
