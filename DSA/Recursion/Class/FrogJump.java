package Class;
public class FrogJump {

    /*  Approach 1
          f(i) = min(f(i + 1) + |hi - hi+1|, f(i + 2) + |hi - hi+2|)
          Here, f(i) calculates the minimum cost to go from i to N
    */
    public static int f(int heights[], int i) {
        // base case
        if(i == heights.length - 1) return 0; // if already at Nth stone, cost to jump from N -> N is 0

        // handle only 1 jump case
        if(i == heights.length - 2) {
            return f(heights, i + 1) + Math.abs(heights[i] - heights[i + 1]);
        }

        return Math.min(f(heights, i + 1) + Math.abs(heights[i] - heights[i + 1]), f(heights, i + 2) + Math.abs(heights[i] - heights[i + 2]));
    }

    /*  Approach 2
            f(N) = min(f(N-1) + |hn-1 - hn|, f(N-2) + |hn-2 - hn|)
            Here, f(N) calculates the minimum cost to go from N to 1
    */
    public static int f1(int heights[], int i) {
        // base case
        if(i == 0) return 0; // if already at 1st stone, cost to jump from 1 -> 1 is 0

        // handle only 1 jump case
        if(i == 1) {
            return f1(heights, i - 1) + Math.abs(heights[i] - heights[i - 1]);
        }

        return Math.min(f1(heights, i - 1) + Math.abs(heights[i] - heights[i - 1]), f1(heights, i - 2) + Math.abs(heights[i] - heights[i - 2]));
    }
    
    public static void main(String[] args) {
        int heights[] = {10, 30, 40, 20};
        int heights2[] = {10, 10};
        // System.out.println(f(heights, 0)); // 30
        // System.out.println(f1(heights, 3)); // 30
        System.out.println(f(heights2, 0)); // 0
        // System.out.println(f1(heights2, 1)); // 0
    }
}
