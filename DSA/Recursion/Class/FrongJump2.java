package Class;
public class FrongJump2 {

    public static int f(int heights[], int i, int k) {
        if(i == heights.length - 1) return 0; // If frog is on Nth stone, it requires 0 cost to go to N

        int ans = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++) {
            if(i + j >= heights.length) break; // Frog cannot make a jump

            ans = Math.min(f(heights, i + j, k) + Math.abs(heights[i] - heights[i + j]), ans);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int heights[] = {10, 30, 40, 50, 20};
        System.out.println(f(heights, 0, 3)); // 30
        // System.out.println(f(heights, 0, 3)); // 70
    }
}
