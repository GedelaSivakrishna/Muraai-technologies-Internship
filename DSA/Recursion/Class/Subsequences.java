package Class;
public class Subsequences {

    /*  Time - O(2^n)   Space - O(n)
        Here 'n' is length of String
    */
    public static void f(String str, int idx, String subsequence) {
        if(idx == str.length()) {
            System.out.println(subsequence);
            return;
        }

        // include the char at idx
        f(str, idx + 1, subsequence + str.charAt(idx));

        // skip the char at idx
        f(str, idx + 1, subsequence);
    }
    
    public static void main(String[] args) {
        f("abc", 0, ""); /* abc, ab, ac, a, bc, b, c, '' */
    }
}
