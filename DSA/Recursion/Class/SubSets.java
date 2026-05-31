package Class;
public class SubSets {

    /*  Time - O(2^n),  Space - O(n) */
    public static void f(String str, int i, String substr) {
        // base case
        if(i == str.length()) {
            System.out.println(substr);
            return;
        }

        // ith character included in substr
        f(str, i + 1, substr + str.charAt(i));

        // ith character excluded in substr
        f(str, i + 1, substr);

    }
    
    public static void main(String[] args) {
        // f("abc", 0, "");
        f("siva", 0, "");
    }
}
