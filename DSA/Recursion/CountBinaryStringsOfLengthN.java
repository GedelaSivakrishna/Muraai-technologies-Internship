public class CountBinaryStringsOfLengthN {
    // count binary Strings of length n without consecutive ones
    // Time: O(n)
    //Space: O(n)
    public static int f(int n) {
        // base case
        if(n == 1) return 2;
        if(n == 2) return 3;

        return f(n - 1) + f(n - 2);
    }
    
    public static void main(String[] args) {
        System.out.println(f(4));
    }
}
