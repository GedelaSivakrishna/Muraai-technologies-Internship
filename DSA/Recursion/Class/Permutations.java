package Class;
public class Permutations {

    /*  Time -  O(n * n!) finding each permutation took n time and total n! permutations for n length String
        Space - O(n)
    */
    public static void f(String str, String output) {
        if(str.length() == 0) {
            System.out.println(output);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i + 1);
            f(newStr, output + str.charAt(i));
        }
    }
    
    public static void main(String[] args) {
        // f("abc", "");
        // f("ab", "");
        f("a", "");
    }
}
