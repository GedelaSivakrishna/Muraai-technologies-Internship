package Class;
public class Factorial {

    /*
        In recursion, the call stack space complexity is the maximum depth of the call stack.
        Total Space complexity = call stack space + additional space taken by any data structure
    */

    /*  Time  - O(n)
        Space - O(n)
    */
    public static long factorial(long n) {
        // base case
        if(n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(20));
    }
}