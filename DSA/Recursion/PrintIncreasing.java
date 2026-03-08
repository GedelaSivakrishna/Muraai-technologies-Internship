public class PrintIncreasing {

    // Print increasing sequence without using loops
    /*  Time  - O(n)
        Space - O(n)
    */
    public static void printIncreasing(int n) {
        // base case
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }

        printIncreasing(n - 1);
        System.out.print(n + " ");
    }
    
    public static void main(String[] args) {
        printIncreasing(5);
    }
}
