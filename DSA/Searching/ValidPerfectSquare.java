public class ValidPerfectSquare {

    // Time O(log n)
    //Space O(1)
    public static boolean validPerfectSquare(int num) {
        long lo = 1, hi = num;
        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            
            if((mid * mid) == num) {
                return true;
            }
            if((mid * mid) > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int n = 16;
        int n1 = 216;
        int n2 = 169;
        System.out.println(validPerfectSquare(n));
        System.out.println(validPerfectSquare(n1));
        System.out.println(validPerfectSquare(n2));
    }
}
