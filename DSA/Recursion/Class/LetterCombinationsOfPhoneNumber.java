package Class;
import java.util.ArrayList;
public class LetterCombinationsOfPhoneNumber {

    public static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static ArrayList<String> result = new ArrayList<>();
    
    /*  Time - O(4^n)   Space - O(n) */
    public static void f(String digits, int idx, String output) {
        if(idx == digits.length()) {
            result.add(output);
            return;
        }
        
        int digit = digits.charAt(idx) - '0';
        String letters = map[digit];

        for(int i = 0; i < letters.length(); i++) {
            f(digits, idx + 1, output + letters.charAt(i));
        }
    }
    
    public static void main(String[] args) {
        f("23", 0, "");
        for(String val : result)
            System.out.println(val);
    }
}
