public class PaintersPartition {

    public static boolean canPaint(int A, int[] C, int N, int mid, int B) {
        int painters = 1;
        int unitsPainted = 0;
        int i = 0;
        while(i < N) {
            if((unitsPainted + C[i] * B) > mid) {
                painters++;
                if(painters > A) {
                    return false;
                }
                unitsPainted = 0;
                continue;
            } else {
                unitsPainted += C[i];
                i++;
            }
        }
        return painters <= A;
    }

    // Time: O(n * log(summation of C[i] * B - maxVal * B))
    //Space: O(1)
    public static int paintersPartition(int A, int B, int[] C) {
        int maxVal = Integer.MIN_VALUE, summation = 0;
        int N = C.length;
        for(int i = 0; i < N; i++) {
            maxVal = Math.max(maxVal, C[i]);
            summation += C[i];
        }

        int lo = maxVal * B;
        int hi = summation * B;
        int ans = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(canPaint(A, C, N, mid, B)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans % 10000003;
    }

    public static void main(String[] args) {
        int A = 2;
        int B = 5;
        int[] C = {1, 10};
        int A2 = 10;
        int B2 = 1;
        int[] C2 = {1, 8, 11, 3};
        // ans 50
        System.out.println(paintersPartition(A, B, C));
        // ans 11
        System.out.println(paintersPartition(A2, B2, C2));
    }
}