public class PrintFibonacci {

    /*  Fibonacci series
        0 1 1 2 3 5 8 . . .
    */

    /*  Time  - O(n)
        Space - O(1)
    */
    public static void printFibonacciLoopApproach(int n) {
        if(n == 0) {
            System.out.println("0");
        } else if(n == 1) {
            System.out.println("0 1");
        } else {
            int lastM2 = 0;
            int lastM1 = 1;

            for(int i = 0; i <= n; i++) {
                System.out.print(lastM2 + " ");

                int temp = lastM1;
                lastM1 = lastM1 + lastM2;
                lastM2 = temp;
            }
        }
    }

    public static void printFibonacci(int n, int lastM2, int lastM1) {
        // base case
        if(n == 0) {
            System.out.print(n + " ");
            return;
        }

        printFibonacci(n - 1, lastM2, lastM1);
        int nthTerm = lastM1 + lastM2;
        System.out.print(nthTerm + " ");

        // update variables
        int temp = lastM1;
        lastM1 = lastM1 + lastM2;
        lastM2 = temp;
    }
    
    public static void main(String[] args) {
        printFibonacciLoopApproach(0);
        printFibonacciLoopApproach(1);
        printFibonacciLoopApproach(5);
    }
}
