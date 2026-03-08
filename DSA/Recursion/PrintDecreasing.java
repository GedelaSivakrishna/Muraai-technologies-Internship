public class PrintDecreasing {

    // Print numbers in decreasing sequence without using loops
    /*  Time  - O(n)
        Space - O(n)
    */
    public static void printDecreasing(int n) {
        // base case
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }

        System.out.print(n + " ");
        printDecreasing(n - 1);
    }
    
    public static void main(String[] args) {
        printDecreasing(5);
    }
}
