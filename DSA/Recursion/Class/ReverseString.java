package Class;
public class ReverseString {

    /*  f(str, i) = reverses String from i to n */
    public static String f(String str, int i) {
        // base case
        if(i == str.length()) {
            return "";
        }
        
        return f(str, i + 1) + str.charAt(i);
    }

    /*  f1(str, i) = Reverses String from i to 0 */
    public static String f1(String str, int i) {
        // base case
        if(i < 0) return "";

        return str.charAt(i) + f1(str, i - 1);
    }
    
    public static void main(String[] args) {
        // System.out.println(f("siva", 0)); // avis
        // System.out.println(f("windows", 0)); // swodniw
        // System.out.println(f1("Google", 5)); // elgooG
        System.out.println(f1("Microsoft", 8)); // tfosorciM
    }
}
