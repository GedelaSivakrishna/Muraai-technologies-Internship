import java.util.Scanner;
import java.util.Stack;
public class PrintConsonants {

    public static void print(Stack<Character> stack) {
        if(stack.isEmpty()) return;

        char ch = stack.pop();
        print(stack);
        System.out.print(ch + " ");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            
            if(n < 0) {
                System.out.println("Invalid Input");
                return;
            }

            if(n == 21) {
                System.out.println("Stack is empty");
                return;
            } 

            Stack<Character> stack = new Stack<>();
            String vowels = "aeiou";
            for(char ch = 'a'; ch <= 'z'; ch++) {
                if(vowels.indexOf(ch) == -1) {
                    stack.push(ch);
                }
            }
            
            if(n > 21) {
                print(stack);
            } else {
                // pop first n characters
                while(n-- > 0) {
                    stack.pop();
                }
                print(stack);
            }

        } catch(Exception e) {
            System.out.println("Invalid Input");
        }
    }
}
