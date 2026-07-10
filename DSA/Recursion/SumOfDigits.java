public class SumOfDigits {
    // d -> number of digits in n
    // Time: O(d)
    //Space: O(d)
    public static int f(int n) {
        // base case
        if(n / 10 == 0) return n % 10;

        return n % 10 + f(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(f(2345));
    }
}