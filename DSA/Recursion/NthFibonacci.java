public class NthFibonacci {

    /*  Fibonacci series
        0 1 1 2 3 5 8 13 21 34 55 89 144 . . .

        The first & second term are 0 and 1 and the rest are the sum of previous two terms.
    */

        /*  Time  - O(n)
            Space - O(1)
        */
    public static int nthFibonacciLoopApproach(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int lastM1 = 1;
        int lastM2 = 0;

        for(int i = 2; i < n; i++) {
            int temp = lastM1;
            lastM1 = lastM1 + lastM2;
            lastM2 = temp;
        }

        return lastM1 + lastM2;
    }

    /*  Time  - O(2^n)
        Space - O(n)
    */
    public static int nthFibonacci(int n) {
        // base case
        if(n == 0 || n == 1) {
            return n;
        }

        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }
    
    public static void main(String[] args) {
        // System.out.println(nthFibonacciLoopApproach(0)); // 0
        // System.out.println(nthFibonacciLoopApproach(1)); // 1
        // System.out.println(nthFibonacciLoopApproach(5)); // 5
        // System.out.println(nthFibonacciLoopApproach(12)); // 144
        // System.out.println(nthFibonacci(0)); // 0
        // System.out.println(nthFibonacci(1)); // 1
        // System.out.println(nthFibonacci(5)); // 5
        // System.out.println(nthFibonacci(12)); // 144
    }
}
