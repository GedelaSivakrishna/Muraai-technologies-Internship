public class VeryEasyProblem {

    public static boolean canPrintCopies(int time, int x, int y, int n) {
        int copies1 = time / x;
        int copies2 = time / y;
        return copies1 + copies2 >= n; 
    }

    // Time O(log(max(x, y) * n))
    //Space O(1)
    public static int veryEasyProblem(int n, int x, int y) {
        if(n == 1) {
            return Math.min(x, y);
        }

        int lo = Math.min(x, y), hi = n * Math.max(x, y);
        int ans = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(canPrintCopies(mid, x, y, n - 1)) {
                // found potential answer
                ans = mid;
                hi = mid - 1;
            } else {
                // if cannot print in time, increase time
                lo = mid + 1;
            }
        }
        return ans + Math.min(x, y);
    }
    
    public static void main(String[] args) {
        int n = 4, x = 1, y = 1;
        // ans 3
        System.out.println(veryEasyProblem(n, x, y));
        int n2 = 5, x2 = 1, y2 = 2;
        // ans 4
        System.out.println(veryEasyProblem(n2, x2, y2));
    }
}
