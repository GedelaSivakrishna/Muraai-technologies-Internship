package Basics;

public class PrintA2Z {

    public static void f(char ch) {
        // base case: stop when reached 'z'
        if(ch == 'Z') {
            System.out.print(ch);
            return;
        }

        // self work
        System.out.print(ch + " ");

        // recursive call
        f((char)(ch + 1));
    } 
    
    public static void main(String[] args) {
        f('A');
    }
}
