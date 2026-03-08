public class ReduceString {

    /*  Time  - O(n)
        Space - O(n)
    */
    public static void f(String str, int idx, char ch, String output) {
        // base case
        if(idx == str.length()) {
            System.out.println(output);
            return;
        }

        // work
        if(str.charAt(idx) != ch) {
            f(str, idx + 1, ch, output + str.charAt(idx));
        } else {
            f(str, idx + 1, ch, output);
        }
    }

    public static void main(String[] args) {
        String str = "abcxedxfg";
        f(str, 0, 'x', ""); // abcedfg
    }
    
}
