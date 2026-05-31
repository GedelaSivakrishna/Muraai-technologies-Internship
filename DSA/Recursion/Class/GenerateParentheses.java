package Class;
public class GenerateParentheses {

    public static void f(int n, int o, int c, String output) {
        if(c == n) {
            System.out.println(output);
            return;
        }

        // we can add closing parentheses only when (o > c)
        if(o > c) {
            f(n, o, c + 1, output + ")");
        }

        // we can add opening parentheses till (o < n)
        if(o < n) {
            f(n, o + 1, c, output + "(");
        }
    }
    
    public static void main(String[] args) {
        // f(3, 0, 0, "");
        // f(5, 0, 0, "");
        f(10, 0, 0, "");
    }
}
