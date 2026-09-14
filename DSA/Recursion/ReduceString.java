public class ReduceString {

    public static void f(String str, int idx, String output) {
        // base case
        if(idx >= str.length()) {
            System.out.println(output);
            return;
        }

        // self work
        char ch = str.charAt(idx);
        if(ch != 'x') 
            output += ch;

        f(str, idx + 1, output);
    }
    
    public static void main(String[] args) {
        f("abcxxadxacxe", 0, "");
    }
}
